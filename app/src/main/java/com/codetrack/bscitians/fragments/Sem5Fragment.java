package com.codetrack.bscitians.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codetrack.bscitians.*;

public class Sem5Fragment extends Fragment {

    public Sem5Fragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);}
    @Override
            public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_sem5fragment,container ,false);
    }
}
