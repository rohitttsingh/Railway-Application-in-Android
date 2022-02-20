package com.myrailapp.appchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {
     EditText num;
    Button error;
    ProgressDialog progressDialog;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//////
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });


//////


        error = findViewById(R.id.submit_btn);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        progressDialog= new ProgressDialog(com.myrailapp.appchallenge.MainActivity.this);

        progressDialog.setMessage("Redirecting To Sign Up Page ");
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();}


        num = (EditText) findViewById(R.id.answer);

        //



        //
        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //num.getText().toString(),
                if (Objects.equals(num.getText().toString(),"17")) {
                    progressDialog.show();
                    Intent intent = new Intent(MainActivity.this, search.class);
                    startActivity(intent);
                } else {
                    Toasty.warning(getApplicationContext(), "Wrong Captcha TRY AGAIN !", Toasty.LENGTH_SHORT).show();
                }
            }
        });


    }


}