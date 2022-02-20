package com.myrailapp.appchallenge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import es.dmoral.toasty.Toasty;

public class website extends AppCompatActivity {

WebView webView ;
ActionBar actionBar;
WebViewClient webViewClient;
KeyEvent event;
private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_website);
        String s= getIntent().getStringExtra("pnrkey");
        String s1=getIntent().getStringExtra("searchkey");
        String s2= getIntent().getStringExtra("from");
        String s3= getIntent().getStringExtra("to");
        String s5=getIntent().getStringExtra("pnrnum");
        this.webView = (WebView) findViewById(R.id.webb);

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

    String value = null;

    if (value ==s1) {
        webView = (WebView) findViewById(R.id.webb);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.confirmtkt.com/pnr-status");
        webView.getSettings().setJavaScriptEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("My Rail App");
        getSupportActionBar().setSubtitle("PNR - " + s5);

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#02457A"));
        actionBar.setBackgroundDrawable(colorDrawable);

    }
    else if (value == s){
        webView = (WebView) findViewById(R.id.webb);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.irctc.co.in/nget/train-search");
        webView.getSettings().setJavaScriptEnabled(true);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("My Rail App");
        getSupportActionBar().setSubtitle(s2+" - "+s3);

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#02457A"));
        actionBar.setBackgroundDrawable(colorDrawable);


        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.logout:
                Intent intent= new Intent(website.this,SplashScreen.class);
                Toasty.success(this,"Logged Out",Toasty.LENGTH_SHORT).show();

                startActivity(intent);
                break;
            case R.id.about:
                Intent intent1= new Intent(website.this,aboutuss.class);
                startActivity(intent1);
                break;

            case R.id.bug:
                Toasty.success(this,"Bug Reposted Successfully",Toasty.LENGTH_SHORT).show();
                break;
        }
        return true;

    }

}
