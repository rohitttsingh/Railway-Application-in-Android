package com.myrailapp.appchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import es.dmoral.toasty.Toasty;

public class signup extends AppCompatActivity {
VideoView videoView;
Uri uri;
TextView user;
Button sucess,error;
ProgressDialog progressDialog;
EditText num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rawvideo);
        videoview.setVideoURI(uri);
        num=(EditText)findViewById(R.id.phonenumber);
       videoview.start();
       user= (TextView)findViewById(R.id.name);
       sucess=findViewById(R.id.signup_btn);
       error=findViewById(R.id.login_btn);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();}

       progressDialog= new ProgressDialog(com.myrailapp.appchallenge.signup.this);
       progressDialog.setTitle("Signing Up");
       progressDialog.setMessage("We Are Creating Your Account ");
       sucess.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if (num.length()==10) {
                   progressDialog.show();
                   Toasty.success(getApplicationContext(),"Welcome : " + user.getText(),Toasty.LENGTH_LONG).show();
                   Intent intent=new Intent(signup.this,signin.class);
                   startActivity(intent);

               } else {

                   Toasty.error(getApplicationContext(), "ENTER VALID PHONE NUMBER", Toasty.LENGTH_SHORT).show();

               }

//                   try{
//
//                       Thread.sleep(3000);
//
//                   } catch (InterruptedException e){
//                       e.printStackTrace();
//                   }


                   //

           }
       });

       error.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toasty.error(getApplicationContext(),"Please First Sign Up",Toasty.LENGTH_SHORT).show();;
           }
       });

    }

}