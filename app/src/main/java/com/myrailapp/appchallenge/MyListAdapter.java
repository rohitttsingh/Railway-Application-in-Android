package com.myrailapp.appchallenge;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] maintitle;
    private final String[] mainsubtitle;
    private final Integer[] imgid;


    public MyListAdapter(Activity context, String[] maintitle, Integer[] imgid, String[] mainsubtitle){



        super(context,R.layout.mylistview,maintitle);
        this.context=context;
        this.imgid=imgid;
        this.maintitle=maintitle;
        this.mainsubtitle=mainsubtitle;



    }
    public View getView(int position, View view, ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView =inflater.inflate(R.layout.mylistview, null,true);
        TextView titletext = rowView.findViewById(R.id.title);
        TextView subtitlee = rowView.findViewById(R.id.subtitle);
        ImageView imageView = rowView.findViewById(R.id.icon);
        ImageView view1 = rowView.findViewById(R.id.icon);

        titletext.setText(maintitle[position]);
        subtitlee.setText(mainsubtitle[position]);
        imageView.setImageResource(imgid[position]);


        return rowView;
    }
}
