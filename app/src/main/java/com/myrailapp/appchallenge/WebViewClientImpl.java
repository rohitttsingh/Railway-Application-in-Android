package com.myrailapp.appchallenge;

import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.Uri;
import android.content.Intent;

public class WebViewClientImpl extends  WebViewClient{
    private Activity activity = null;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }


    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if(url.indexOf("https://www.confirmtkt.com/") > -1 ) return false;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;
    }
}
