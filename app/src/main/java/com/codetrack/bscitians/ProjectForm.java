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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.codetrack.bscitians.util.FormValidator;
import com.codetrack.bscitians.util.SendMail;

import butterknife.BindView;

public class ProjectForm extends AppCompatActivity implements View.OnClickListener {

    private boolean projectFlag = false;
    @BindView(R.id.complete)
    RadioButton compelte;
    @BindView(R.id.guidance)
    RadioButton guidance;
    @BindView(R.id.userName)
    EditText name;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.userPhone)
    EditText phone;
    @BindView(R.id.projectDescription)
    EditText description;
    @BindView(R.id.buttonRequest)
    Button Send;
    @BindView(R.id.projectTypes)
    Spinner projectType;
    @BindView(R.id.language)
    Spinner lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        compelte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                projectFlag = true;
            }
        });

        guidance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                projectFlag = false;
            }
        });

        Send.setOnClickListener(this);

        setTitle("Request Project");
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
        name = (EditText) findViewById(R.id.userName);
        // TextWatcher would let us check oo error on the fly
        name.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                SendMail.hasText(name);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });


                email = (EditText) findViewById(R.id.userEmail);
        email.addTextChangedListener(new TextWatcher() {
            // after every change has been made to this editText, we would like to check validity
            public void afterTextChanged(Editable s) {
                SendMail.isEmailAddress(email, true);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        phone = (EditText) findViewById(R.id.userPhone);
        phone.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                SendMail.isPhoneNumber(phone, false);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        description=(EditText)findViewById(R.id.projectDescription);
        description.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                SendMail.hasText(description);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

    
    }
    
    
    private boolean checkFormValidator() {
        boolean ret = true;

        if (!SendMail.hasText(name)) ret = false;
        if (!SendMail.isEmailAddress(email, true)) ret = false;
        if (!SendMail.isPhoneNumber(phone, false)) ret = false;
        if (!SendMail.hasText(description)) ret = false;
        if(projectType.getSelectedItem().toString().equalsIgnoreCase("Select Project Type"))
        {
            setSpinnerError(projectType,"required");
        }
        if(lang.getSelectedItem().toString().equalsIgnoreCase("Select Language"))
        {
            setSpinnerError(lang,"required");
        }
        return ret;
    }

    static public void setSpinnerError(Spinner spinner, String error){
        View selectedView = spinner.getSelectedView();
        if (selectedView != null && selectedView instanceof TextView) {
            TextView selectedTextView = (TextView) selectedView;
            selectedTextView.setError(error);
        }
    }

    public void setEmail() {
        String projectScope;
        if (projectFlag == true) {
            projectScope = "Compelte project";
        } else {
            projectScope = "Guidance for project";
        }
        String emailid = email.getText().toString().trim();
        String subject = "Project Request By " + name.getText().toString().trim() + "(" + phone.getText().toString().trim() + ")";
        String subjectUser = "Thanks for choosing us for your project.";
        String body = name.getText().toString().trim() + "(" + phone.getText().toString().trim() + ")\n" +
                "Project Type:" + projectType.getSelectedItem().toString() + "\n" +
                "Laguage:" + lang.getSelectedItem().toString() + "\n" + projectScope + "\n" + "Description:" + description.getText().toString().trim();

        String bodyUser = "We are glad that you have chose us for Your Final Year Project.\n" +
                "\n" +
                "We understand the impact of final year project on you and your career, We are here to help you out through this.\n" +
                "\n" +
                "Our team will analyse your Project request and will get back to you soon.\n" +
                "\n" +
                "Regards\n" +
                "CodeTrack";

        try {

            SharedPreferences pref = getApplicationContext().getSharedPreferences("bscitians" ,MODE_PRIVATE);
            String b=pref.getString("ae", null);         // getting String

            //Creating om object

            FormValidator sm = new FormValidator(this, "thecodetrack@gmail.com", subject, body , "bscitians1217@gmail.com", b);

            FormValidator sm1 = new FormValidator(this, emailid, subjectUser, bodyUser , "bscitians1217@gmail.com" ,b );

            //Executing sendmail to send email
            sm.execute();
            sm1.execute();

            name.setText("");
            email.setText("");
            phone.setText("");
            description.setText("");
            projectType.setSelection(0);
            lang.setSelection(0);


        } catch (Exception e) {
            //Showing a error message
            Toast.makeText(getApplicationContext(), "Some Error Occured in Sending Message", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View v) {
        isNetworkAvailable();
        if ( checkFormValidator() )
            setEmail();
        else
            Toast.makeText(ProjectForm.this, "Form is not properly filled.", Toast.LENGTH_LONG).show();

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
                Intent intent = new Intent(this, AboutUs.class);
                startActivity(intent);
                break;
            case R.id.action_share:
                Intent intent1 = new Intent("android.intent.action.SEND");
                intent1.setType("text/plain");
                intent1.putExtra("android.intent.extra.SUBJECT", "BSCITIANS");
                intent1.putExtra("android.intent.extra.TEXT", "BSCITIANS - Download notes,syllabus,question papers of bscit \n\nWe also provide praticals solutions & tools required to perform them \n\nThe most accurate and credible guide for your Bscit Graduation:\nhttps://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                ProjectForm.this.startActivity(Intent.createChooser(intent1, "Share App"));
                break;
            case R.id.feedback:
                Intent intentfeed = new Intent(this, FeedbackForm.class);
                startActivity(intentfeed);
                break;
            case R.id.action_rate:
                try {
                    Uri shareUri = Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                    Intent shareIntent = new Intent(Intent.ACTION_VIEW, shareUri);
                    startActivity(shareIntent);
                    break;
                } catch (ActivityNotFoundException e) {
                    Uri shareUri = Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                    Intent shareIntent = new Intent(Intent.ACTION_VIEW, shareUri);
                    startActivity(shareIntent);
                    break;
                }

        }
        return true;

    }
}
