package com.wang.peise;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Shop1Activity extends Activity {

    private WebView mWv_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop1);
        mWv_1 = findViewById(R.id.wv_1);
        mWv_1.getSettings().setJavaScriptEnabled(true);
        mWv_1.setWebViewClient(new MyWebViewClient());
        mWv_1.loadUrl("https://detail.1688.com/offer/540431628756.html?spm=a261b.2187593.1998088710.11.20787a38dZz8aL");
    }
    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public void onPageFinished(WebView view, String url){
            super.onPageFinished(view, url);
        }
    }
    @Override
    public boolean onKeyDown(int keycode, KeyEvent event){
        if (keycode == KeyEvent.KEYCODE_BACK && mWv_1.canGoBack()){
            mWv_1.goBack();
            return true;
        }
        return super.onKeyDown(keycode, event);
    }
}