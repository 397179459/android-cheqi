package com.wang.peise;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class QuseActivity extends Activity {

    private WebView mWv1;


    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quse);
        mWv1 = findViewById(R.id.wv1);
        mWv1.getSettings().setJavaScriptEnabled(true);
        mWv1.setWebViewClient(new MyWebViewClient());
        mWv1.loadUrl("http://link.fobshanghai.com/rgbcolor.htm");
    }
    class MyWebViewClient extends WebViewClient{
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
        if (keycode == KeyEvent.KEYCODE_BACK && mWv1.canGoBack()){
            mWv1.goBack();
            return true;
        }
        return super.onKeyDown(keycode, event);
    }
}


