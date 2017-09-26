package com.codetrack.bscitians;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ComingSoon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_comming_soon);
    }
}
