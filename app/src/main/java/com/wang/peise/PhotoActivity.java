package com.wang.peise;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PhotoActivity extends Activity {

    int [] images = new int[] {
            R.drawable.a,
            R.drawable.b, R.drawable.ac,R.drawable.c,R.drawable.ca,R.drawable.cb,R.drawable.cd,
            R.drawable.d, R.drawable.e,R.drawable.f,R.drawable.fd,R.drawable.g,R.drawable.h,
            R.drawable.i,R.drawable.j,R.drawable.m,R.drawable.n,R.drawable.nb,R.drawable.o,
            R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,R.drawable.w,
            R.drawable.x,R.drawable.y
    };
    int currentImg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        LinearLayout main = (LinearLayout) findViewById(R.id.root);

        final ImageView image = new ImageView(this);
        main.addView(image);
        image.setImageResource(images[0]);
        image.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         image.setImageResource(images[++currentImg % images.length]);
                                     }
                                 }
        );
    }
}