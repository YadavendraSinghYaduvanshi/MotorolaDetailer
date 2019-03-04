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

public class SuperFastPeformanceFragment extends Fragment implements View.OnClickListener {

    ImageView processorImg,ramImg,osImg;
    String backStateName;
    boolean fragmentPopped;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_super_fast_peformance, container, false);
        declaration(view);
        return view;
    }


    private void declaration(View view) {
        processorImg = (ImageView)view.findViewById(R.id.processor);
        ramImg       = (ImageView)view.findViewById(R.id.ram);
        osImg        = (ImageView)view.findViewById(R.id.os);

        processorImg.setOnClickListener(this);
        ramImg.setOnClickListener(this);
        osImg.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.processor:
                // do your code
                loadFragment(new TurboPowerChargingVideoFragment());
                break;

            case R.id.ram:
                // do your code
                loadFragment(new RAMVideoFragment());
                break;

            case R.id.os:
                // do your code
                loadFragment(new LatestOSVideoFragment());
                break;

            default:
                break;
        }
    }

    private void loadFragment(Fragment fragment) {
        backStateName = fragment.getClass().getName();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fragmentPopped = fm.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped) { //fragment not in back stack, create it.
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.home_fragment, fragment);
            fragmentTransaction.addToBackStack(backStateName); // adding fragment to back stack
            fragmentTransaction.commit(); // save the changes
        }
    }

}
