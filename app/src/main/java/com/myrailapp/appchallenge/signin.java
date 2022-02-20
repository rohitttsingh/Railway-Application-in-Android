package com.myrailapp.appchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import es.dmoral.toasty.Toasty;

public class signin extends AppCompatActivity {
VideoView videoView;
Uri uri;
TextView username;
Button success;
ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        success=findViewById(R.id.signin);
        username=(TextView)findViewById(R.id.name);
        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rawvideo);
        videoview.setVideoURI(uri);
        videoview.start();

        progressDialog= new ProgressDialog(com.myrailapp.appchallenge.signin.this);
        progressDialog.setTitle("Signing In");
        progressDialog.setMessage("Opening Your Account ");

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();}

        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                Toasty.success(getApplicationContext(),"Signed in successfully : "+ username.getText(),Toasty.LENGTH_LONG);

                Intent intent= new Intent(signin.this,search.class);
                startActivity(intent);

//                try{
//
//                    Thread.sleep(3000);
//
//                } catch (InterruptedException e){
//                    e.printStackTrace();
//                }

            }
        });
    }
}