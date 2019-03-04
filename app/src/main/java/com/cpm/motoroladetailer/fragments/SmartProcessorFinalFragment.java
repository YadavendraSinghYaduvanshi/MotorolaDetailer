package com.cpm.motoroladetailer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cpm.motoroladetailer.R;

public class SmartProcessorFinalFragment extends Fragment{
    ImageView rearImg1,selfieImg2;
    String backStateName;
    boolean fragmentPopped;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_smart_processor_final_screen, container, false);
        return view;
    }
}
