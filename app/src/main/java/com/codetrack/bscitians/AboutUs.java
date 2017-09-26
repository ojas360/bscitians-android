package com.codetrack.bscitians;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    TextView about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_about_us);
        setTitle("About us -Bscitians");
        this.about = (TextView) findViewById(R.id.about_content);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            this.about.setText(Html.fromHtml("<h3><b>Application for Bsc-It Students</h3>" +
                    "MUMBAI UNIVERSITY</font></b>\n" +
                    "<br/>The most accurate and credible guide for your Bscit Graduation.<br/>\n" +
                    "<br/>This app enables bscit students to access necessary <b>learning</b> materials on their phone.<br/>\n" +
                    "<br/>Bscitians provide <b><i>Notes</i></b>,<b><i>Syllabus</i></b>,<b><i>Question Papers</i></b>,<b><i>Practicals </i></b> of bscit course.<br/>\n" +
                    "<br/><b>We also provide Guidance for Final Year Projects.</b><br/>\n"+
                    "<br/>If You Have Any Suggestions , Feedback or Queries. Fill out our Feedback Form or contact us at <b><u>thecodetrack@gmail.com</u></b>..\n" +
                    "<br/>\n" +
                    "<br/>All the best.....",Html.FROM_HTML_MODE_LEGACY));
        }
        else {
            this.about.setText(Html.fromHtml(  "<h3><b>Application for Bsc-It Students</h3>"+
                    "MUMBAI UNIVERSITY</font></b>\n" +
                    "<br/>"+
                    "<br/>The most accurate and credible guide for your Bscit Graduation.<br/>\n" +
                    "<br/>This app enables bscit students to access necessary <b>learning</b> materials on their phone.<br/>\n" +
                    "<br/>Bscitians provide <b><i>Notes</i></b>,<b><i>Syllabus</i></b>,<b><i>Question Papers</i></b>,<b><i>Practicals </i></b> of bscit course.<br/>\n" +
                    "<br/><b>We also provide Guidance for Final Year Projects.</b><br/>\n"+
                    "<br/>If You Have Any Suggestions , Feedback or Queries. Fill out our Feedback Form or contact us at <b><u>thecodetrack@gmail.com</u></b>..\n" +
                    "<br/>\n" +
                    "<br/>All the best....."));
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
            case R.id.action_share:
                Intent intent1 = new Intent("android.intent.action.SEND");
                intent1.setType("text/plain");
                intent1.putExtra("android.intent.extra.SUBJECT", "BSCITIANS");
                intent1.putExtra("android.intent.extra.TEXT", "BSCITIANS - Download notes,syllabus,question papers of bscit \n\nWe also provide praticals solutions & tools required to perform them \n\nThe most accurate and credible guide for your Bscit Graduation:\nhttps://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                AboutUs.this.startActivity(Intent.createChooser(intent1, "Share App"));
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
