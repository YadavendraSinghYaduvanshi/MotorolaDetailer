package com.cpm.motoroladetailer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cpm.motoroladetailer.GetterSetter.VisitCountGetterSetter;
import com.cpm.motoroladetailer.R;
import com.cpm.motoroladetailer.database.MotorolaDetailerDB;

public class HomeFragment extends Fragment implements View.OnClickListener {
    ImageView smartCameraImg,superFastProcessorImg,notchDisplayProcessorImg,turboPowerChargingImg;
    String backStateName,visit_date="",emp_id="";
    boolean fragmentPopped,val;
    MotorolaDetailerDB db;
    VisitCountGetterSetter visitCountObj = null;
    int smartCameraSystemCounter = 0,superFastProcessorCounter=0,notchDisplayProcessorCounter=0,turboPowerChargingCounter=0,count=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_home, container, false);
        declaration(view);
        return view;
    }

    private void declaration(View view) {
        smartCameraImg           = (ImageView)view.findViewById(R.id.smart_camera_system);
        superFastProcessorImg    = (ImageView)view.findViewById(R.id.super_fast_processor);
        notchDisplayProcessorImg = (ImageView)view.findViewById(R.id.u_notch_display_processor);
        turboPowerChargingImg    = (ImageView)view.findViewById(R.id.turbo_power_charging);

        smartCameraImg.setOnClickListener(this);
        superFastProcessorImg.setOnClickListener(this);
        notchDisplayProcessorImg.setOnClickListener(this);
        turboPowerChargingImg.setOnClickListener(this);

        // creating new object of the Database
        db = new MotorolaDetailerDB(getActivity());
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.smart_camera_system:
                // do your code
                db.open();
                visitCountObj = db.getInsertedVisitCountData(emp_id,visit_date);
                if(visitCountObj.getSmart_camera_count() != 0){
                    count  = visitCountObj.getSmart_camera_count();
                    count = count + 1 ;
                   val = db.updateVisitCountData(visit_date,emp_id,1,count);
                }else{
                    smartCameraSystemCounter++ ;
                    val = db.insertVisitCountData(visit_date,smartCameraSystemCounter,1,emp_id);
                }
                if(val){
                    loadFragment(new SmartCameraSelectionOptionFragment());
                }
                break;

            case R.id.super_fast_processor:
                // do your code
                db.open();
                visitCountObj = db.getInsertedVisitCountData(emp_id,visit_date);
                if(visitCountObj.getSuper_fast_processor_count() != 0){
                    count  = visitCountObj.getSuper_fast_processor_count();
                    count  = count + 1 ;
                    val    = db.updateVisitCountData(visit_date,emp_id,1,count);
                }else{
                    superFastProcessorCounter++;
                    val  = db.insertVisitCountData(visit_date,superFastProcessorCounter,2,emp_id);
                }
                if(val){
                    loadFragment(new SuperFastProcessorVideoFargment());
                }
                break;

            case R.id.u_notch_display_processor:
                // do your code
                db.open();
                visitCountObj = db.getInsertedVisitCountData(emp_id,visit_date);
                if(visitCountObj.getU_notch_display_count() != 0){
                    count  = visitCountObj.getU_notch_display_count();
                    count  = count + 1 ;
                    val    = db.updateVisitCountData(visit_date,emp_id,3,count);
                }else{
                    notchDisplayProcessorCounter++;
                    val = db.insertVisitCountData(visit_date,notchDisplayProcessorCounter,3,emp_id);
                }
                if(val){
                    loadFragment(new UNotchDesignDisplayVideoFragment());
                }

                break;

            case R.id.turbo_power_charging:
                // do your code
                db.open();
                visitCountObj = db.getInsertedVisitCountData(emp_id,visit_date);
                if(visitCountObj.getTurbo_power_charging_count() != 0){
                    count  = visitCountObj.getTurbo_power_charging_count();
                    count  = count + 1 ;
                    val    = db.updateVisitCountData(visit_date,emp_id,4,count);
                }else{
                    turboPowerChargingCounter++;
                    val = db.insertVisitCountData(visit_date,turboPowerChargingCounter,4,emp_id);
                }
                if(val){
                    loadFragment(new TurboPowerChargingVideoFragment());
                }

                break;

            default:
                break;
        }
    }

    private void loadFragment(Fragment fragment) {
        backStateName = fragment.getClass().getName();
        FragmentManager fm = getActivity().getSupportFragmentManager();
      //  fragmentPopped = fm.popBackStackImmediate (backStateName, 0);

//        if (!fragmentPopped) { //fragment not in back stack, create it.
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
          //  fragmentTransaction.setCustomAnimations(R.anim.alpha, R.anim.translate);
            fragmentTransaction.replace(R.id.home_fragment, fragment);
            fragmentTransaction.addToBackStack(backStateName); // adding fragment to back stack
            fragmentTransaction.commit(); // save the changes
       // }
    }
}
