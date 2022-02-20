package com.myrailapp.appchallenge;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.view.View;
import android.view.Window;

import android.view.WindowManager;


public class SplashScreen extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        Window window = getWindow() ;


        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();}


            Thread splashTread = new Thread(){


            @Override

            public void run() {

                try {

                    sleep(3500);

                    startActivity(new Intent(SplashScreen.this,MainActivity.class));

                    finish();

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

                super.run();

            }

        };

        splashTread.start();

    }


}