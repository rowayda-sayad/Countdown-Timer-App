package com.example.countdowntimerudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView timer;
    TextView timeElapsed;
    Button resetBtn;

    private final long startTime = 20 * 1000; //20,000 ms which means 20 sec
    private final long interVAL = 1000; //1 sec

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = findViewById(R.id.timer);
        timeElapsed = findViewById(R.id.timeElapsed);

        resetBtn = findViewById(R.id.resetBtn);

        CountDownTimer ctd = new CountDownTimer(startTime, interVAL) {
            @Override
            public void onTick(long l) {
                timer.setText("Timer: " + l / 1000); //divide by thous. to get seconds only
                timeElapsed.setText("Time Elapsed: " + (startTime - l) / 1000);
            }

            @Override
            public void onFinish() {
                timer.setText("TIMER FINISHED");
            }
        };
        ctd.start();

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctd.cancel();
                ctd.start();
            }
        });
    }
}