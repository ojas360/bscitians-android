package com.codetrack.bscitians;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.codetrack.bscitians.adapter.NotesListAdapter;
import com.codetrack.bscitians.app.AppController;
import com.codetrack.bscitians.model.Notes;

import butterknife.BindView;

public class NotesActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String url = "http://bscitians.ml/get_notes.php?subject_id=";
    private ProgressDialog pDialog;
    private List<Notes> notesList = new ArrayList<Notes>();
    @BindView(R.id.list1)
    ListView listView;
    private NotesListAdapter adapter;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.notes_activity);
        Intent intent1=getIntent();
        name= intent1.getStringExtra("name");
        setTitle("Notes");
        isNetworkAvailable();
        String id=intent1.getStringExtra("subject_id");

        adapter = new NotesListAdapter(this, notesList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        String requestUrl = url + id;
        // Creating volley request obj
        JsonArrayRequest notesReq = new JsonArrayRequest(requestUrl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Notes notes = new Notes();
                                notes.setTitle(obj.getString("name"));
                                notes.setLink(obj.getString("link"));
                                notesList.add(notes);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Intent intent=new Intent(NotesActivity.this,PdfView.class);

                                    TextView d = (TextView) view.findViewById(R.id.titlepapers);
                                    String link = view.getTag().toString();
                                    String name = d.getText().toString();
                                    intent.putExtra("link",link);
                                    intent.putExtra("name",name);
                                    startActivity(intent);
                                    //Toast.makeText(getApplicationContext(), String.valueOf(l),Toast.LENGTH_SHORT).show();
                                }
                            });


                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(notesReq);
    }

    public void download_click(View view)
    {
        String temp = view.getContentDescription().toString();
        DownloadManager.Request request=new DownloadManager.Request(Uri.parse(temp));
        request.setTitle(name);
        request.setDescription("no is being downloaded.");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        String nameofFile= URLUtil.guessFileName(temp,null, MimeTypeMap.getFileExtensionFromUrl(temp));

        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,nameofFile);

        ((DownloadManager) NotesActivity.this.getSystemService(Context.DOWNLOAD_SERVICE)).enqueue(request);
        Toast.makeText(NotesActivity.this.getApplicationContext(), "Downloading has started", Toast.LENGTH_LONG).show();

    }
    public void isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if( (activeNetworkInfo != null && activeNetworkInfo.isConnected())==false){
            new AlertDialog.Builder(this).setTitle("No Internet Connection").setMessage("Please check your internet connection...").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dlg, int sumthin) {
                    dlg.cancel();
                    finish();
                }
            }).show();
        }
    }

    @Override
    public void onContentChanged(){
        super.onContentChanged();
        View empty = findViewById(R.id.empty1);
        ListView list = (ListView)findViewById(R.id.list1);
        list.setEmptyView(empty);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);

        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_aboutus:
                Intent intent=new Intent(this,AboutUs.class);
                startActivity(intent);
                break;
            case R.id.action_share:
                Intent intent1 = new Intent("android.intent.action.SEND");
                intent1.setType("text/plain");
                intent1.putExtra("android.intent.extra.SUBJECT", "BSCITIANS");
                intent1.putExtra("android.intent.extra.TEXT", "BSCITIANS - Download notes,syllabus,question papers of bscit \n\nWe also provide praticals solutions & tools required to perform them \n\nThe most accurate and credible guide for your Bscit Graduation:\nhttps://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                NotesActivity.this.startActivity(Intent.createChooser(intent1, "Share App"));
                break;
            case R.id.feedback:
                Intent intentfeed=new Intent(this,FeedbackForm.class);
                startActivity(intentfeed);
                break;
            case R.id.action_rate:
                try {
                    Uri shareUri=Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                    Intent shareIntent=new Intent(Intent.ACTION_VIEW,shareUri);
                    startActivity(shareIntent);
                    break;
                }
                catch (ActivityNotFoundException e){
                    Uri shareUri=Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                    Intent shareIntent=new Intent(Intent.ACTION_VIEW,shareUri);
                    startActivity(shareIntent);
                    break;
                }

        }
        return true;
    }


}