package com.wang.peise;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class CallActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
    }
}
