package com.myrailapp.appchallenge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class LastActivity extends AppCompatActivity {
    ListView listView;
   ActionBar actionBar;
   MediaPlayer mediaPlayer;
    ProgressDialog progressDialog;



    String[] main_title ={"YPR BKN EXP-06587 ", "YPR ADI FEST SPL-06502", "BARMER AC EXP-04805","TN OKHA EXP-0956","SBC JU FEST SPL-06508","JP SUVIDHA EXP-06521","PUNE NZM AC SPL-02493","NZM  SPL-029352"
                         ,"YPR BKN EXP-06587 ", "YPR ADI FEST SPL-06502", "BARMER AC EXP-04805","TN OKHA EXP-0956","SBC JU FEST SPL-06508","JP SUVIDHA EXP-06521","PUNE NZM AC SPL-02493","NZM  SPL-029352"};
    Integer[] imgid = {R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo,R.drawable.logo};
    String[] main_subtitle= {"50 Seats Available(SL/AC)","30 Seats Available(SL/AC)","10 Seats Available(SL/AC)"," 200 Seats Available(SL/AC)","50 Seats Available(SL/AC)","50 Seats Available(SL/AC)","50 Seats Available(SL/AC)"
                            ,"50 Seats Available(SL/AC)","50 Seats Available(SL/AC)","50 Seats Available(SL/AC)","50 Seats Available(SL/AC)","50 Seats Available(SL/AC)","50 Seats Available(SL/AC)","50 Seats Available(SL/AC)","50 Seats Available(SL/AC)","50 Seats Available(SL/AC)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        progressDialog= new ProgressDialog(com.myrailapp.appchallenge.LastActivity.this);

        progressDialog.setMessage("Redirecting to the official page ");
        String s= getIntent().getStringExtra("from");
        String s1= getIntent().getStringExtra("to");

     //action bar
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle(s + " - " + s1);//textView.getText().toString());
        getSupportActionBar().setSubtitle("Train Availability List");

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#02457A"));
        actionBar.setBackgroundDrawable(colorDrawable);
        //lol



        listView= findViewById(R.id.list);
        MyListAdapter adapter=new MyListAdapter(this, main_title,imgid,main_subtitle);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                progressDialog.show();
                String value =adapter.getItem(position);


                Toasty.success(LastActivity.this, value ,Toast.LENGTH_SHORT).show();
               Intent intent= new Intent(LastActivity.this,website.class);
               intent.putExtra("lastkey",value);
               intent.putExtra("fromlast", s);
               intent.putExtra("tolast",s1);
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
                Intent intent= new Intent(LastActivity.this,SplashScreen.class);
                startActivity(intent);
                Toasty.success(this,"Logged Out",Toasty.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Intent intent1= new Intent(LastActivity.this,aboutuss.class);
                startActivity(intent1);
                break;
            case R.id.bug:
                Toasty.success(this,"Bug Reposted Successfully",Toasty.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}