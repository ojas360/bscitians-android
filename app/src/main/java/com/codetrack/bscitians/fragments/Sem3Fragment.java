package com.codetrack.bscitians.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codetrack.bscitians.*;

public class Sem3Fragment extends Fragment {

    public Sem3Fragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);}
    @Override
            public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_sem3fragment,container ,false);
    }
}
