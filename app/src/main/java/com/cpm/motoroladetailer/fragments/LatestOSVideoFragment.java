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

import com.cpm.motoroladetailer.Constant.CommonString;
import com.cpm.motoroladetailer.R;


public class LatestOSVideoFragment extends Fragment {

    String path;
    VideoView videoView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_latest_osvideo, container, false);
        decalartion(view);
        return view;
    }

    private void decalartion(View view) {
        videoView =
                (VideoView) view.findViewById(R.id.video_view);

        getActivity().getWindow().setFormat(PixelFormat.UNKNOWN);
        path = CommonString.VIDEO_PATH + "media.mp4";

        Uri uri=Uri.parse(path);
        //    videoView.setVideoPath(CommonString.VIDEO_PATH + "/media11.mp4);
        videoView.setVideoURI(uri);

        MediaController mediaController = new
                MediaController(getActivity());
        mediaController.setAnchorView(videoView);

        mediaController.setVisibility(View.GONE);
        videoView.setMediaController(mediaController);

        videoView.start();
    }
}
