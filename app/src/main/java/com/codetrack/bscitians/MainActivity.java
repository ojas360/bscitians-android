package com.codetrack.bscitians;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.codetrack.bscitians.util.RuntimePermission;

public class MainActivity extends RuntimePermission {
    // cretaing variable of buttons
    private static final int REQUEST_PERMISSION=10;
    boolean doubleBackToExitPressedOnce = false;
    public ImageButton syllabus,questionpaper,program,notes,tools,tutorials;

    MediaPlayer btnClick;

    public void init(){
        syllabus=(ImageButton)findViewById(R.id.syllabus);
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pass=new Intent(MainActivity.this,SemestersActivity.class);
                pass.putExtra("screen","syllabus");
                btnClick = MediaPlayer.create(getApplicationContext(), R.raw.btnclick);
                     btnClick.start();

                startActivity(pass);
            }
        });
        questionpaper=(ImageButton)findViewById(R.id.questionPapers) ;
        questionpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pass=new Intent(MainActivity.this,SemestersActivity.class);
                pass.putExtra("screen","paper");
                btnClick = MediaPlayer.create(getApplicationContext(), R.raw.btnclick);
                btnClick.start();
                startActivity(pass);
            }
        });

        notes=(ImageButton)findViewById(R.id.notes);
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pass=new Intent(MainActivity.this,SemestersActivity.class);
                pass.putExtra("screen","notes");
                btnClick = MediaPlayer.create(getApplicationContext(), R.raw.btnclick);
                btnClick.start();
                startActivity(pass);
            }
        });
        program=(ImageButton)findViewById(R.id.practicals);
        program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pass=new Intent(MainActivity.this,PracticalsActivity.class);
                btnClick = MediaPlayer.create(getApplicationContext(), R.raw.btnclick);
                btnClick.start();
                startActivity(pass);
            }
        });

        tutorials=(ImageButton)findViewById(R.id.tutorials);
        tutorials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pass=new Intent(MainActivity.this,ProjectForm.class);
                btnClick = MediaPlayer.create(getApplicationContext(), R.raw.btnclick);
                btnClick.start();
                startActivity(pass);
            }
        });
        tools=(ImageButton)findViewById(R.id.tools);
        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pass=new Intent(MainActivity.this,ToolsActivity.class);
                btnClick = MediaPlayer.create(getApplicationContext(), R.raw.btnclick);
                btnClick.start();
                startActivity(pass);
            }
        });

    }
    @Override
    public void onPermmissionGranted(int requestCode) {
       /* Toast.makeText(getApplicationContext(),"PERMISSION GRANTTED",Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);

        requestAppPermission(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},R.string.permission,REQUEST_PERMISSION);
        return super.onCreateOptionsMenu(menu);

    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();
        if(id==R.id.action_aboutus)
        {
            Intent intent=new Intent(this,AboutUs.class);
            startActivity(intent);
            return true;
        }

        if(id==R.id.feedback)
        {
            Intent intent=new Intent(this,FeedbackForm.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.action_share){
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", "BSCITIANS");
            intent.putExtra("android.intent.extra.TEXT", "BSCITIANS - Download notes,syllabus,question papers of bscit \n\nWe also provide praticals solutions & tools required to perform them \n\nThe most accurate and credible guide for your Bscit Graduation:\nhttps://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
            MainActivity.this.startActivity(Intent.createChooser(intent, "Share App"));

            return true;
        }

        if(id==R.id.action_rate)
        {
            try {
                Uri shareUri=Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                Intent shareIntent=new Intent(Intent.ACTION_VIEW,shareUri);
                startActivity(shareIntent);
            }
            catch (ActivityNotFoundException e){
                Uri shareUri=Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                Intent shareIntent=new Intent(Intent.ACTION_VIEW,shareUri);
                startActivity(shareIntent);
            }

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icon2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            //super.onBackPressed();

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
            startActivity(intent);
            finish();
            System.exit(0);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press BACK again to leave", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

}
