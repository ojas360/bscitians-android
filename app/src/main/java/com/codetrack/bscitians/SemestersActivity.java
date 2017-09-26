package com.codetrack.bscitians;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

public class SemestersActivity extends AppCompatActivity {
    String Json_STRING,Json_url;
    JSONObject jsonObject;
    public Button s1,s2,s3,s4,s5,s6;
    String name="Semesters",screen;

    public void init(){
        screen=getIntent().getExtras().getString("screen");
        setTitle(this.name);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_semesters);
        s1=(Button)findViewById(R.id.sem1);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String screen = getIntent().getStringExtra("screen");
                String url = "https://www.dropbox.com/s/40dvf5vjcd3a3g7/sem1.pdf?dl=1";
                if(screen.equalsIgnoreCase("syllabus")) {
                    Intent intent = new Intent(SemestersActivity.this, PdfView.class);
                    intent.putExtra("link",url);
                    intent.putExtra("name", "Semester 1 Syllabus");
                    startActivity(intent);

                }
                else {
                    Intent pass = new Intent(SemestersActivity.this, SubjectActivity.class);
                    pass.putExtra("sem_id", "0");
                    pass.putExtra("screen", screen);
                    startActivity(pass);
                }
            }
        });

        s2=(Button)findViewById(R.id.sem2);
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String screen = getIntent().getStringExtra("screen");
                String url = "https://www.dropbox.com/s/hy6yq72x3wxtfy9/sem2.pdf?dl=1";
                if(screen.equalsIgnoreCase("syllabus")) {
                    Intent intent = new Intent(SemestersActivity.this, PdfView.class);
                    intent.putExtra("link",url);
                    intent.putExtra("name", "Semester 2 Syllabus");
                    startActivity(intent);

                }
                else {
                    Intent pass = new Intent(SemestersActivity.this, SubjectActivity.class);
                    pass.putExtra("sem_id", "1");
                    pass.putExtra("screen", screen);
                    startActivity(pass);
                }
            }
        });

        s3=(Button)findViewById(R.id.sem3);
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String screen = getIntent().getStringExtra("screen");
                String url = "https://www.dropbox.com/s/bi57mf9r8t2t2um/sem3.pdf?dl=1";
                if(screen.equalsIgnoreCase("syllabus")) {
                    Intent intent = new Intent(SemestersActivity.this, PdfView.class);
                    intent.putExtra("link",url);
                    intent.putExtra("name", "Semester 3 Syllabus");
                    startActivity(intent);

                }
                else {
                    Intent pass = new Intent(SemestersActivity.this, SubjectActivity.class);
                    pass.putExtra("sem_id", "2");
                    pass.putExtra("screen", screen);
                    startActivity(pass);
                }
            }
        });

        s4=(Button)findViewById(R.id.sem4);
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String screen = getIntent().getStringExtra("screen");
                String url = "https://www.dropbox.com/s/dw4oknqsgyksfyv/sem4.pdf?dl=1";
                if(screen.equalsIgnoreCase("syllabus")) {
                    Intent intent = new Intent(SemestersActivity.this, PdfView.class);
                    intent.putExtra("link",url);
                    intent.putExtra("name", "Semester 4 Syllabus");
                    startActivity(intent);

                }
                else {
                    Intent pass = new Intent(SemestersActivity.this, SubjectActivity.class);
                    pass.putExtra("sem_id", "3");
                    pass.putExtra("screen", screen);
                    startActivity(pass);
                }
            }
        });

        s5=(Button)findViewById(R.id.sem5);
        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String screen = getIntent().getStringExtra("screen");
                String url = "https://www.dropbox.com/s/qiztgpr7i96g021/sem5.pdf?dl=1";
                if(screen.equalsIgnoreCase("syllabus")) {
                    Intent intent = new Intent(SemestersActivity.this, PdfView.class);
                    intent.putExtra("link",url);
                    intent.putExtra("name", "Semester 5 Syllabus");
                    startActivity(intent);

                }
                else {
                    Intent pass = new Intent(SemestersActivity.this, SubjectActivity.class);
                    pass.putExtra("sem_id", "4");
                    pass.putExtra("screen", screen);
                    startActivity(pass);
                }
            }
        });

        s6=(Button)findViewById(R.id.sem6);
        s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String screen = getIntent().getStringExtra("screen");
                String url = "https://www.dropbox.com/s/472ukhqcbaudalq/sem6.pdf?dl=1";
                if(screen.equalsIgnoreCase("syllabus")) {
                    Intent intent = new Intent(SemestersActivity.this, PdfView.class);
                    intent.putExtra("link",url);
                    intent.putExtra("name", "Semester 6 Syllabus");
                    startActivity(intent);

                }
                else {
                    Intent pass = new Intent(SemestersActivity.this, SubjectActivity.class);
                    pass.putExtra("sem_id", "5");
                    pass.putExtra("screen", screen);
                    startActivity(pass);
                }
            }
        });
        init();

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
                SemestersActivity.this.startActivity(Intent.createChooser(intent1, "Share App"));
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
