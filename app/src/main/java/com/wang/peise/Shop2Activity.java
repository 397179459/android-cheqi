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

public class Shop2Activity extends Activity {

    private WebView mWv_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop2);
        mWv_2 = findViewById(R.id.wv_2);
        mWv_2.getSettings().setJavaScriptEnabled(true);
        mWv_2.setWebViewClient(new MyWebViewClient());
        mWv_2.loadUrl("https://shop1469638281611.1688.com/?spm=a261b.2187593.1998088710.5.57017a38soKz89");
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
        if (keycode == KeyEvent.KEYCODE_BACK && mWv_2.canGoBack()){
            mWv_2.goBack();
            return true;
        }
        return super.onKeyDown(keycode, event);
    }
}