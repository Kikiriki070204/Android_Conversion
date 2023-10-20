package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class Intro extends AppCompatActivity {

    private TextView txt;
    private CountDownTimer countdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        txt= findViewById(R.id.time);

        countdown= new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millis) {
                txt.setText(String.valueOf(millis/1000));
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(Intro.this, MainActivity.class));
                finish();
            }
        }.start();

    }
}