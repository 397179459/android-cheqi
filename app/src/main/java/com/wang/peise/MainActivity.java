package com.wang.peise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnPs;
    private Button mBtnJs;
    private Button mBtnQs;
    private Button mBtnSk;
    private Button mBtnTp;
    private Button mBtnCall;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnPs = findViewById(R.id.btn_ps);
        mBtnPs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PeiseActivity.class);
                startActivity(intent);
            }
        });

        mBtnJs = findViewById(R.id.btn_js);
        mBtnJs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,JisuanActivity.class);
                startActivity(intent);
            }
        });

        mBtnQs = findViewById(R.id.btn_qs);
        mBtnQs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,QuseActivity.class);
                startActivity(intent);
            }
        });

        mBtnSk = findViewById(R.id.btn_sk);
        mBtnSk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SekaActivity.class);
                startActivity(intent);
            }
        });

        mBtnTp = findViewById(R.id.btn_tp);
        mBtnTp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PhotoActivity.class);
                startActivity(intent);
            }
        });

        mBtnCall = findViewById(R.id.btn_call);
        mBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CallActivity.class);
                startActivity(intent);
            }
        });
    }
}


