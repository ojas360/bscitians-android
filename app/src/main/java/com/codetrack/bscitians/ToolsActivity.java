package com.codetrack.bscitians;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import  com.codetrack.bscitians.fragments.*;
import java.util.ArrayList;
import java.util.List;


public class ToolsActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.tools_activity);
        setTitle("Tools and Softwares");

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
    public void isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if( (activeNetworkInfo != null && activeNetworkInfo.isConnected())==false){
            new AlertDialog.Builder(this).setTitle("No Internet Connection").setMessage("Please check your internet connection...").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dlg, int sumthin) {
                    dlg.cancel();
                }
            }).show();
        }
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Sem1Fragment(), "Semester 1");
        adapter.addFrag(new Sem2Fragment(), "Semester 2");
        adapter.addFrag(new Sem3Fragment(), "semester 3");
        adapter.addFrag(new Sem4Fragment(), "Semester 4");
        adapter.addFrag(new Sem5Fragment(), "Semester 5");
        adapter.addFrag(new Sem6Fragment(), "Semester 6");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    public void turboc(View view){
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri=Uri.parse("http://www.mediafire.com/download/ejo1mabnmhweqb8/TurboC%2B%2B_for_Windows_8n7_v3.7.9.9.zip");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void mp8085_download(View view){
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri=Uri.parse("http://www.mediafire.com/download/63a3zv2z3alraxq/8085_Setup.zip");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void np_download(View view){
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri=Uri.parse("https://notepad-plus-plus.org/download/");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void oracle(View view){
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri=Uri.parse("http://www.mediafire.com/download/2oapyc16y85y2zk/Oracle_Sql_11g.zip");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void jdk_32bit(View view){
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri=Uri.parse("http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void codevision(View view){
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri=Uri.parse("http://www.mediafire.com/download/3au4u2h131tech2/CODEVISION_EVAL.zip");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }


    public void proteus(View view){
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri=Uri.parse("https://app.box.com/s/mk68msetjdn7eznehjcjdx02hxm6pvbm");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void visual(View view) {
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri = Uri.parse("https://www.visualstudio.com/en-us/products/visual-studio-express-vs.aspx");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void netbeans(View view) {
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri = Uri.parse("https://netbeans.org/downloads/start.html?platform=windows&lang=en&option=javase");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    public void redhat(View view) {
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri = Uri.parse("http://rhnproxy1.uvm.edu/pub/redhat/rhel5-as-x86/isos/rhel-server-5.6-i386-dvd.iso");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }



    public void packet(View view) {
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri = Uri.parse("http://www.cs.rpi.edu/~kotfid/packettracer/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void qgis(View view) {
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri = Uri.parse("https://www.qgis.org/en/site/forusers/download.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    public void mathlab(View view) {
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri = Uri.parse("https://www.mathworks.com/downloads/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    public void staruml(View view) {
       /* Toast.makeText(getApplicationContext(),"button click working",Toast.LENGTH_LONG).show();*/
        Uri uri = Uri.parse("http://staruml.io/download");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
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
                ToolsActivity.this.startActivity(Intent.createChooser(intent1, "Share App"));
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
