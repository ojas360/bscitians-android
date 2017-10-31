package com.codetrack.bscitians;
import com.android.volley.toolbox.NetworkImageView;
import com.codetrack.bscitians.adapter.SubjectsListAdapter;
import com.codetrack.bscitians.app.AppController;
import com.codetrack.bscitians.model.Subjects;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import butterknife.BindView;

public class SubjectActivity extends AppCompatActivity {
    private static final String TAG = SubjectActivity.class.getSimpleName();
    int semid;
    String screenName ="";
    private static final String url = "http://bscitians.ml/get_subjects.php?sem_id=";
    private ProgressDialog pDialog;
    private List<Subjects> subjectsList = new ArrayList<Subjects>();
    @BindView(R.id.list)
    ListView listView;
    private SubjectsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_subject);

        setTitle("Subjects");
        isNetworkAvailable();
        Intent intent=getIntent();
        semid = Integer.parseInt(intent.getStringExtra("sem_id"));
        this.screenName = intent.getStringExtra("screen");

        adapter = new SubjectsListAdapter(this, subjectsList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        int id = semid+1;
        String requestUrl = null;
        if(screenName.equalsIgnoreCase("pracs"))
        {
            requestUrl= url + id+"&practicals=yes";
        }else
        {
            requestUrl= url + id;
        }

        // Creating volley request obj
        JsonArrayRequest subjectsReq = new JsonArrayRequest(requestUrl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                Subjects subjects = new Subjects();
                                subjects.setId(obj.getString("subject_id"));
                                subjects.setTitle(obj.getString("name"));
                                subjects.setThumbnailUrl(obj.getString("image_path"));
                                subjects.setDescription(obj.getString("description"));
                                if(screenName.equalsIgnoreCase("pracs"))
                                {
                                    subjects.setLink(obj.getString("pdf_link"));
                                }
                                subjectsList.add(subjects);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    String subjectid = String.valueOf(view.getTag());
                                    String screen = screenName;
                                    if(screen.equalsIgnoreCase("paper")) {
                                        Intent intent = new Intent(SubjectActivity.this, PapersActivity.class);
                                        intent.putExtra("subject_id", subjectid);
                                        startActivity(intent);

                                    }
                                    if(screen.equalsIgnoreCase("notes"))
                                    {
                                        Intent intent = new Intent(SubjectActivity.this, NotesActivity.class);
                                        intent.putExtra("subject_id", subjectid);
                                        startActivity(intent);
                                    }
                                    if(screen.equalsIgnoreCase("pracs"))
                                    {
                                        TextView title = (TextView)view.findViewById(R.id.title);
                                        String name = title.getText().toString();
                                        NetworkImageView c = (NetworkImageView)view.findViewById(R.id.thumbnail);
                                        String link = c.getContentDescription().toString();
                                        Intent intent = new Intent(SubjectActivity.this, PdfView.class);
                                        intent.putExtra("name", name);
                                        intent.putExtra("link",link);
                                        startActivity(intent);
                                    }
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
        AppController.getInstance().addToRequestQueue(subjectsReq);
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
    public void onContentChanged(){
        super.onContentChanged();
        View empty = findViewById(R.id.empty4);
        ListView list = (ListView)findViewById(R.id.list);
        list.setEmptyView(empty);
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
                SubjectActivity.this.startActivity(Intent.createChooser(intent1, "Share App"));
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
