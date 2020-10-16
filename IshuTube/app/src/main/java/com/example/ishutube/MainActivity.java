package com.example.ishutube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView tut = findViewById(R.id.tut);
        tut.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.clip); // only play video , no controls

        //now providing media controllers to the app

        MediaController mediaController = new MediaController(this);
        tut.setMediaController(mediaController);
        mediaController.setAnchorView(tut);      // in brackets: name of the id


        // to start the video
        tut.start();


    }
}
