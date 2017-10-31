package com.codetrack.bscitians;


import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;


public class PdfView extends AppCompatActivity {

    Context context;
    @BindView(R.id.btn_download)
    ImageButton download;
    @BindView(R.id.btn_refresh)
    ImageButton refresh;
    @BindView(R.id.btn_share)
    ImageButton share;
    @BindView(R.id.syllabus_viewer)
    WebView pdfviews;
    Resources res;
    String url = "";
    String name = "Syllabus";

    private GoogleApiClient client;


    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("rn Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();


        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    private class Callback extends WebViewClient {
        private Callback() {

        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_pdfview);
       isNetworkAvailable();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.url = extras.getString("link");
            this.name = extras.getString("name");
        }
        setTitle(this.name);
        this.pdfviews.setWebViewClient(new WebViewClient());
        this.pdfviews.getSettings().setJavaScriptEnabled(true);
        this.pdfviews.getSettings().setBuiltInZoomControls(true);
        this.pdfviews.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        this.pdfviews.getSettings().setAppCacheEnabled(true);
        this.pdfviews.setScrollBarStyle(View.SCROLLBARS_INSIDE_INSET);
        WebSettings webSettings = this.pdfviews.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setDomStorageEnabled(true);
        webSettings.setSaveFormData(true);
        final ProgressDialog loading = ProgressDialog.show(this, "Loading...", "Please wait...", false, true);
        loading.setOnCancelListener(new OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                PdfView.this.pdfviews.setWebChromeClient(null);

            }
        });

        loading.setMessage("Loading PDF...");
        this.pdfviews.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + url);

        this.pdfviews.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    loading.show();
                } else {
                    loading.cancel();
                }
            }
        });


        this.refresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PdfView.this.finish();
                PdfView.this.startActivity(PdfView.this.getIntent());
            }
        });

        this.share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", "BSCITIANS");
                intent.putExtra("android.intent.extra.TEXT", "BSCITIANS \n\n Get PDF copy of " + PdfView.this.name + " by installing the  App from Google Playstore:\nhttps://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                PdfView.this.startActivity(Intent.createChooser(intent, "Share App"));
            }
        });


        this.download.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                DownloadManager.Request request=new DownloadManager.Request(Uri.parse(url));
                request.setTitle(name);
                request.setDescription("File is being downloaded.");
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                String nameofFile= URLUtil.guessFileName(url,null, MimeTypeMap.getFileExtensionFromUrl(url));

                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,nameofFile);

                ((DownloadManager) PdfView.this.getSystemService(Context.DOWNLOAD_SERVICE)).enqueue(request);
                Toast.makeText(PdfView.this.getApplicationContext(), "Downloading has started", Toast.LENGTH_LONG).show();

            }
        });


        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    public class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                URL myurl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("GET");
                connection.connect();

                File rootdiect=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"MY PDF");

                if(!rootdiect.exists()){
                    rootdiect.mkdirs();
                }
                String nameofFile= URLUtil.guessFileName(url,null, MimeTypeMap.getFileExtensionFromUrl(url));
                File file=new File(rootdiect,nameofFile);

                file.createNewFile();

                InputStream ip=connection.getInputStream();

                FileOutputStream output=new FileOutputStream(file);
                byte[] buffer =new byte[1024];
                int bytecount=0;

                while ((bytecount=ip.read(buffer))>0)
                {
                    output.write(buffer,0,bytecount);
                }

                output.close();

                Intent in=new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                in.setData(Uri.fromFile(file));


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Toast.makeText(getApplicationContext(), "Download Completed", Toast.LENGTH_LONG).show();

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
                PdfView.this.startActivity(Intent.createChooser(intent1, "Share App"));
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
