package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    AudioManager audioManager;
    //for playing the music
   public void playon(View view)
   {
       player.start();
       TextView status = findViewById(R.id.status);
       status.setText("Play");
   }
   // for pause
   public void pause(View view)
   {
       player.pause();
       TextView status = findViewById(R.id.status);
       status.setText("Pause");
   }
   // for stop
   public void stop(View view)
   {
       player.stop();
       TextView status = findViewById(R.id.status);
       status.setText("Stop");
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inserting music file
        player = MediaPlayer.create(this,R.raw.music);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE); //Service provided by A.S

        int maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        SeekBar seekVol = findViewById(R.id.seekVol);

        // setting max and min value of vol.
        seekVol.setMax(maxVol); // for max volume
        seekVol.setProgress(curVol); //for current volume

        seekVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // you have to type only seekVol.setOnSeekBarChangeListener(new SeekBar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { // all code will appear automatically

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar seekprog = findViewById(R.id.seekProg);
        seekprog.setMax(player.getDuration());

         new Timer().scheduleAtFixedRate(new TimerTask() {
             @Override
             public void run() {
                 seekprog.setProgress(player.getCurrentPosition()); // to make seekbar going
             }
         }, 0, 100000); // period for update
        seekprog.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                player.seekTo(progress); // it will contain  progress of music
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
   }
}
