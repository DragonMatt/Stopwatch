package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Button startPause;
    private Button reset;
    private Chronometer timer;
    private long displayTime = 0;

    public static final String TAG = MainActivity.class.getSimpleName();
    // Look up the Log class for Android
    // List all the levels of logging and when they're used
    // lowest to highest priority list below
    // wtf: What a Terrible Failure
    // v: Verbose (lowest priority)
    // d: Debug
    // i: Info
    // w: Warning
    // e: Error
    // a: Assert (highest priority)

    // launched app --> onCreate, onStart, onResume
    // rotate --> onStop, onDestroy, onCreate, onStart, onResume
    // hit the square button --> onPause, onStop
    // click back on the app from the square button --> onStop, onStart, onResume
    // hit the circle button --> onPause, onStop
    // relaunch the app from the phone navigation (not play button) --> onStop, onStart, onResume
    // hit the back button --> onPause, onStop, onDestroy

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();

        Log.d(TAG, "onCreate: ");
    }

    private void wireWidgets() {
        startPause = findViewById(R.id.button_main_startPause);
        reset = findViewById(R.id.button_main_reset);
        timer = findViewById(R.id.chronometer_main_timer);
    }

    private void setListeners() {
        startPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.setBase(SystemClock.elapsedRealtime() - displayTime);
                timer.start();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.setBase(SystemClock.elapsedRealtime());
                timer.stop();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}