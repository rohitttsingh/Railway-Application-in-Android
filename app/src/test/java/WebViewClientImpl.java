public class WebViewClientImpl extends Web {
    private Activity activity = null;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if(url.indexOf("journaldev.com") > -1 ) return false;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;
    }
}
