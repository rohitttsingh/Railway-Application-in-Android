package com.myrailapp.appchallenge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

import es.dmoral.toasty.Toasty;

public class pnrsearch extends AppCompatActivity {
Button error;
EditText num;
ProgressDialog progressDialog;
ActionBar actionBar;
private AdView mAdView ,mAdView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnrsearch);


        // ads
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
        //

        // ads
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView1 = findViewById(R.id.adView1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest1);

        mAdView1.setAdListener(new AdListener() {
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
        //

        error=findViewById(R.id.search_btn);
        num=(EditText) findViewById(R.id.pnr);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("My Rail App");
        getSupportActionBar().setSubtitle("Check PNR");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#02457A"));
        actionBar.setBackgroundDrawable(colorDrawable);


        progressDialog= new ProgressDialog(com.myrailapp.appchallenge.pnrsearch.this);

        progressDialog.setMessage("We Are Redirecting You to The Page ");

//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();}

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num.length()==10) {
                    progressDialog.show();
                    Intent intent=new Intent(pnrsearch.this,website.class);
                    intent.putExtra("pnrnum",num.getText().toString());
                    intent.putExtra("pnrkey",error.getText().toString());
                    startActivity(intent);
                } else {
                    Toasty.error(getApplicationContext(), "ENTER 10 DIGIT OF PNR", Toasty.LENGTH_SHORT).show();
                }


            }

        });

    }@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.logout:
                Intent intent= new Intent(pnrsearch.this,SplashScreen.class);
                startActivity(intent);
                Toasty.success(this,"Logged Out",Toasty.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Intent intent1= new Intent(pnrsearch.this,aboutuss.class);
                startActivity(intent1);
                break;
            case R.id.bug:
                Toasty.success(this,"Bug Reposted Successfully",Toasty.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}