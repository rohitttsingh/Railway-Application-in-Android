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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import es.dmoral.toasty.Toasty;

public class search extends AppCompatActivity
{
Button btn_pnr,btn_search;
ProgressDialog progressDialog;
TextView textView, textView1;
ActionBar actionBar;
private AdView mAdView , mAdView1;


String[] listitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

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

//


        btn_pnr=findViewById(R.id.pnr_btn);
        btn_search=findViewById(R.id.search_btn);
       // textView=findViewById(R.id.from);
       // textView1=findViewById(R.id.to);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        listitem = getResources().getStringArray(R.array.city);
        AutoCompleteTextView textView =findViewById(R.id.from);
        AutoCompleteTextView textView1 =findViewById(R.id.to);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,listitem);
        textView.setAdapter(adapter);
        textView1.setAdapter(adapter);


        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("My Rail App");
        getSupportActionBar().setSubtitle("Search Train ");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#02457A"));
        actionBar.setBackgroundDrawable(colorDrawable);

        progressDialog= new ProgressDialog(com.myrailapp.appchallenge.search.this);

        progressDialog.setMessage("We Are Redirecting You to The Page ");

//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();}

        btn_pnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(search.this,pnrsearch.class);
                startActivity(intent);
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    progressDialog.show();
                    Intent intent = new Intent(search.this, website.class);

                    intent.putExtra("from", textView.getText().toString());
                    intent.putExtra("to", textView1.getText().toString());
                    intent.putExtra("searchkey", btn_search.getText().toString());
                    startActivity(intent);

            }
        });
    }
    @Override
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
                Intent intent= new Intent(search.this,SplashScreen.class);
                startActivity(intent);
                Toasty.success(this,"Logged Out",Toasty.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Intent intent1= new Intent(search.this,aboutuss.class);
                startActivity(intent1);
                break;
            case R.id.bug:
                Toasty.success(this,"Bug Reposted Successfully",Toasty.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}