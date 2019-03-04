package com.cpm.motoroladetailer.fragments;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.cpm.motoroladetailer.Constant.CommonFunctions;
import com.cpm.motoroladetailer.R;

public class TurboPowerChargingVideoFragment extends Fragment {
    String path;
    VideoView videoView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_turbo_power_charging_viedo, container, false);
        decalartion(view);
        return  view;
    }


    private void decalartion(View view) {
        videoView =
                (VideoView) view.findViewById(R.id.video_view);

        CommonFunctions.setVideoSize(getActivity(),videoView, R.raw.turbo_power_charging);
    }
}
