package com.wang.peise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JisuanActivity extends AppCompatActivity {

    private TextView textView;
    private EditText mEt1;
    private EditText mEt2;
    private EditText mEt3;
    private EditText mEt4;
    private EditText mEt5;
    private EditText mEt6;
    private EditText mEt7;
    private EditText mEt8;
    private EditText mEt9;
    private EditText mEt10;
    private EditText mEt11;
    private EditText mEt12;
    private EditText mEt13;
    private EditText mEt14;
    private Button mBtnjisuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jisuan);
        mEt1 = findViewById(R.id.sz_1);
        mEt2 = findViewById(R.id.sz_2);
        mEt3 = findViewById(R.id.sz_3);
        mEt4 = findViewById(R.id.sz_4);
        mEt5 = findViewById(R.id.sz_5);
        mEt11 = findViewById(R.id.sz_6);
        mEt12 = findViewById(R.id.sz_7);
        mEt6 = findViewById(R.id.jg_1);
        mEt7 = findViewById(R.id.jg_2);
        mEt8 = findViewById(R.id.jg_3);
        mEt9 = findViewById(R.id.jg_4);
        mEt10 = findViewById(R.id.jg_5);
        mEt13 = findViewById(R.id.jg_6);
        mEt14 = findViewById(R.id.jg_7);
        textView = findViewById(R.id.tv);
        mBtnjisuan = findViewById(R.id.btn);
        mBtnjisuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numStr1 = mEt1.getText().toString();
                String numStr2 = mEt2.getText().toString();
                String numStr3 = mEt3.getText().toString();
                String numStr4 = mEt4.getText().toString();
                String numStr5 = mEt5.getText().toString();
                String numStr6 = mEt6.getText().toString();
                String numStr7 = mEt7.getText().toString();
                String numStr8 = mEt8.getText().toString();
                String numStr9 = mEt9.getText().toString();
                String numStr10 = mEt10.getText().toString();
                String numStr11 = mEt11.getText().toString();
                String numStr12 = mEt12.getText().toString();
                String numStr13 = mEt13.getText().toString();
                String numStr14 = mEt14.getText().toString();

                double num1 = Double.parseDouble(numStr1);
                double num2 = Double.parseDouble(numStr2);
                double num3 = Double.parseDouble(numStr3);
                double num4 = Double.parseDouble(numStr4);
                double num5 = Double.parseDouble(numStr5);
                double num6 = Double.parseDouble(numStr6);
                double num7 = Double.parseDouble(numStr7);
                double num8 = Double.parseDouble(numStr8);
                double num9 = Double.parseDouble(numStr9);
                double num10 = Double.parseDouble(numStr10);
                double num11 = Double.parseDouble(numStr11);
                double num12 = Double.parseDouble(numStr12);
                double num13 = Double.parseDouble(numStr13);
                double num14 = Double.parseDouble(numStr14);

                double sum = num1*num6+num2*num7+num3*num8+num4*num9+num5*num10+num11*num13+num12*num14;
                textView.setText(sum+"元/1000份");
            }
        });
    }

}