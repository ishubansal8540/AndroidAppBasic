package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    // Use of this type of code in app like making a stopwatch,data collection
    // we can use handler and runable



    int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // now countdown
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                Log.d("Ishu","ontick: hi ");
            }

            @Override
            public void onFinish() {
          Log.d("Ishu","done with it");
            }
        }.start();
    }



/*
Log.e: This is for when bad stuff happens. Use this tag in places like inside a catch statement. You know that an error has occurred and therefore you're logging an error.
Log.w: Use this when you suspect something shady is going on. You may not be completely in full on error mode, but maybe you recovered from some unexpected behavior. Basically, use this to log stuff you didn't expect to happen but isn't necessarily an error. Kind of like a "hey, this happened, and it's weird, we should look into it."
Log.i: Use this to post useful information to the log. For example: that you have successfully connected to a server. Basically use it to report successes.
Log.d: Use this for debugging purposes. If you want to print out a bunch of messages so you can log the exact flow of your program, use this. If you want to keep a log of variable values, use this.
Log.v: Use this when you want to go absolutely nuts with your logging. If for some reason you've decided to log every little thing in a particular part of your app, use the Log.v tag.
And as a bonus...

Log.wtf: Use this when stuff goes absolutely, horribly, holy-crap wrong. You know those catch blocks where you're catching errors that you never should get...yeah, if you wanna log them use Log.wtf

 Log.v(); // Verbose
Log.d(); // Debug
Log.i(); // Info
Log.w(); // Warning
Log.e(); // Error
 */









     /*   //  Task Scheduler using Handler and Runnable
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
             // code to execute
                number ++;
                Toast.makeText( MainActivity.this,"this is toast " + number, Toast.LENGTH_SHORT ).show();
                handler.postDelayed(this,1000); // toast will come again and again after 1 sec
            }
        };
        handler.post(run);

    }*/
}

// handler and runable are use for makeing something run for ever (task or anything)