package com.example.uiailatreuphu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class M000_Splash_Actitity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m000_splash_activity);
        initViews();
    }

    private void initViews() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(M000_Splash_Actitity.this, M001_Main_Actitity.class);
                startActivity(intent);
            }

            int x=0;
        },2000);
    }
}