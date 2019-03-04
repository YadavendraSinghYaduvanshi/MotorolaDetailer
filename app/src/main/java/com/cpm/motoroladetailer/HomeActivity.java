package com.cpm.motoroladetailer;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.cpm.motoroladetailer.Constant.CommonFunctions;
import com.cpm.motoroladetailer.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CommonFunctions.setScreenFullView(HomeActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       loadFragment();
    }


    public void loadFragment() {
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        HomeFragment fragment = new HomeFragment();
       // fragmentTransaction.setCustomAnimations(R.anim.alpha, R.anim.translate);
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
