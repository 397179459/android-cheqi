package com.wang.peise;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by wang on 2018/5/3.
 */

public class CarActivity extends Activity implements View.OnClickListener{

    private EditText etName,etColor,etSm1,etSm2,etSm3,etSm4,etSm5,etSm6,etSm7;
    private Button btnLink,btnPrint,btnAdd;
    private int id;
    private DatabaseHandler handler;
    private Intent intent;
    private Button btnShop;
    private ImageView ivplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car);

        initView();

        etName= (EditText) findViewById(R.id.car_name);
        etColor= (EditText) findViewById(R.id.car_color);
        etSm1=findViewById(R.id.car_sm1);
        etSm2=findViewById(R.id.car_sm2);
        etSm3=findViewById(R.id.car_sm3);
        etSm4=findViewById(R.id.car_sm4);
        etSm5=findViewById(R.id.car_sm5);
        etSm6=findViewById(R.id.car_sm6);
        etSm7=findViewById(R.id.car_sm7);
        btnLink= (Button) findViewById(R.id.btn_link);
        btnPrint= (Button) findViewById(R.id.btn_print);
        btnAdd= (Button) findViewById(R.id.btn_add_car);
        btnShop= findViewById(R.id.btn_shop);

        handler=new DatabaseHandler(this);
        //获取传递过来的intent
        intent=getIntent();

        //通过request判断，是通过那个Button点击进入的，之后隐藏或者显示相应的Button
        String request=intent.getStringExtra("request");
        switch (request){
            //点击添加按钮进入的，则只显示btnAdd
            case "Add":
                btnLink.setVisibility(View.GONE);
                btnPrint.setVisibility(View.GONE);
                btnShop.setVisibility(View.GONE);
                btnAdd.setVisibility(View.VISIBLE);
                break;
            //通过ListView Item进入的
            case "Look":
                id=intent.getExtras().getInt("id");
                etName.setText(intent.getStringExtra("name"));
                etColor.setText(intent.getStringExtra("color"));
                etSm1.setText(intent.getStringExtra("sm1"));
                etSm2.setText(intent.getStringExtra("sm2"));
                etSm3.setText(intent.getStringExtra("sm3"));
                etSm4.setText(intent.getStringExtra("sm4"));
                etSm5.setText(intent.getStringExtra("sm5"));
                etSm6.setText(intent.getStringExtra("sm6"));
                etSm7.setText(intent.getStringExtra("sm7"));
                break;
        }
        btnAdd.setOnClickListener(this);
        btnLink.setOnClickListener(this);
        btnShop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_car:
                Car newCar=new Car(id,etName.getText().toString(),etColor.getText().toString(),etSm1.getText().toString(),
                        etSm2.getText().toString(),
                        etSm3.getText().toString(),
                        etSm4.getText().toString(),etSm5.getText().toString(),etSm6.getText().toString(),
                        etSm7.getText().toString());
                handler.addCar(newCar);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btn_link:
                Toast.makeText(this,"请连接电子秤",Toast.LENGTH_SHORT).show();
                setResult(2,intent);
                finish();
                break;
            case R.id.btn_shop:
                Intent intent = new Intent(CarActivity.this,ShopActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
    /**
     * 初始化
     */
    private void initView() {
        ivplay = (ImageView) findViewById(R.id.ivPlay);
        btnPrint = (Button) findViewById(R.id.btn_print);
        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLink.setVisibility(View.GONE);
                btnPrint.setVisibility(View.GONE);
                btnShop.setVisibility(View.GONE);
                Bitmap bitmap = captureScreenWindow();
                ivplay.setImageBitmap(bitmap);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        ivplay.setVisibility(View.GONE); //view是要隐藏的控件
                    }
                }, 3000);  //3000毫秒后执行
            }
        });
    }


    /**
     * 截取全屏
     *
     * @return
     */
    public Bitmap captureScreenWindow() {
        getWindow().getDecorView().setDrawingCacheEnabled(true);
        Bitmap bmp = getWindow().getDecorView().getDrawingCache();
        return bmp;
    }

}