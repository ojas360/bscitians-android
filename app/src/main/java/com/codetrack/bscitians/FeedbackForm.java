package com.codetrack.bscitians;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codetrack.bscitians.util.FormValidator;
import com.codetrack.bscitians.util.SendMail;

import java.util.regex.Pattern;

import butterknife.BindView;

public class FeedbackForm extends AppCompatActivity implements View.OnClickListener {

    //Declaring EditText
    @BindView(R.id.editTextEmail)
    EditText editTextEmail;

    @BindView(R.id.editTextSubject)
    EditText editTextSubject;

    @BindView(R.id.editTextMessage)
    EditText editTextMessage;

    @BindView(R.id.buttonSend)
    Button buttonSend;

    @Override
    public void onClick(View v) {
        isNetworkAvailable();
        if ( checkFormValidator() )
           sendEmail();
        else
            Toast.makeText(FeedbackForm.this, "Form is not properly filled.", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonSend.setOnClickListener(this);

        setTitle("Feedback Form");
        isNetworkAvailable();

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

    private void registerViews() {
        editTextEmail = (EditText) findViewById(R.id.userName);
        editTextEmail.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                SendMail.hasText(editTextEmail);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });


        editTextSubject = (EditText) findViewById(R.id.userEmail);
        editTextSubject.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                SendMail.isEmailAddress(editTextSubject, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });


        editTextMessage=(EditText)findViewById(R.id.projectDescription);
        editTextMessage.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                SendMail.hasText(editTextMessage);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });


    }

    private boolean checkFormValidator() {
        boolean ret = true;

        if (!SendMail.hasText(editTextSubject)) ret = false;
        if (!SendMail.isEmailAddress(editTextEmail,true)) ret = false;
        if (!SendMail.hasText(editTextMessage)) ret = false;

        return ret;
    }


    private void sendEmail() {
        //Getting content for email
        String email = editTextEmail.getText().toString().trim();
        String subject = "Feedback";
        String message = "Name : " + editTextSubject.getText().toString().trim()+"\n"+editTextMessage.getText().toString().trim();
        String subject1 = "Feedback Acknowledgment";
        String message1 = "Thank You For Your Feedback! We Are Glad to Hear From You And We are always Open To New Ideas and Suggestions.\n" +
                "\n" +
                "Keep using our Application and do share it with Your Friends.\n" +
                "\n" +
                "Regards\n" +
                "CodeTrack\n";

        try {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("bscitians" ,MODE_PRIVATE);
            String b=pref.getString("ae", null);         // getting String
            FormValidator sm = new FormValidator(this, "thecodetrack@gmail.com", subject, message, "bscitians1217@gmail.com", b);

            FormValidator sm1 = new FormValidator(this, email, subject1, message1, "bscitians1217@gmail.com", b);

            //Executing sendmail to send email
            sm.execute();
            sm1.execute();
            editTextSubject.setText("");
            editTextEmail.setText("");
            editTextMessage.setText("");
            //Showing a success message
        }catch (Exception e)
        {
            //Showing a error message
            Toast.makeText(getApplicationContext(),"Some Error Occured in Sending Message",Toast.LENGTH_LONG).show();
        }
    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
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
                FeedbackForm.this.startActivity(Intent.createChooser(intent1, "Share App"));
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
