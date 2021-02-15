package com.lavender.BitCoin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

import com.lavender.BitCoin.R;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        CountDownTimer countDownTimer = new CountDownTimer(3000, 2000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(Splash.this,ChooseActivity.class));
                finish();
            }
        }.start();
    }
}
