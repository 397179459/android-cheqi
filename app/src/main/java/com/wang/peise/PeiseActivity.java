package com.wang.peise;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PeiseActivity extends Activity implements View.OnClickListener {

    private ListView cars;
    private CarAdapter adapter;
    private Button btnAdd,btnSearch;
    private DatabaseHandler dbHandler;
    private List<Car> carList;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peise);

        cars= (ListView) findViewById(R.id.car_list);
        btnAdd= (Button) findViewById(R.id.btn_add);
        btnSearch= (Button) findViewById(R.id.btn_search);


        btnSearch.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

        dbHandler=new DatabaseHandler(this);

        //获取全部车信息
        carList=dbHandler.getALLCar();
        adapter=new CarAdapter(this,carList);
        cars.setAdapter(adapter);

        //点击ListView item跳转到详细界面
        cars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(PeiseActivity.this,CarActivity.class);

                //注意这里的request是为了区分是通过什么跳转到详细界面的
                intent.putExtra("request","Look");
                intent.putExtra("id",carList.get(i).getId());
                intent.putExtra("name",carList.get(i).getName());
                intent.putExtra("color",carList.get(i).getColor());
                intent.putExtra("sm1",carList.get(i).getSm1());
                intent.putExtra("sm2",carList.get(i).getSm2());
                intent.putExtra("sm3",carList.get(i).getSm3());
                intent.putExtra("sm4",carList.get(i).getSm4());
                intent.putExtra("sm5",carList.get(i).getSm5());
                intent.putExtra("sm6",carList.get(i).getSm6());
                intent.putExtra("sm7",carList.get(i).getSm7());
                startActivityForResult(intent, 0);
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                Intent i=new Intent(PeiseActivity.this,CarActivity.class);

                i.putExtra("request","Add");
                startActivityForResult(i, 1);
                break;
            case R.id.btn_search:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);

                //自定义View的Dialog
                final LinearLayout searchView= (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_search,null);
                builder.setView(searchView);
                final AlertDialog dialog=builder.create();
                dialog.show();

                //为自定义View的Dialog的控件添加事件监听。
                final EditText searchName= (EditText) searchView.findViewById(R.id.search_name);
                Button btnDialogSearch= (Button) searchView.findViewById(R.id.btn_search_dialog);
                btnDialogSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        searchName.setVisibility(View.GONE);
                        ListView list = (ListView) searchView.findViewById(R.id.search_result);
                        List<Car> resultList = new ArrayList<Car>();
                        final Car searchCar = dbHandler.getCar(searchName.getText().toString());
                        if (searchCar != null) {
                            resultList.add(searchCar);
                            CarAdapter resultAdapter = new CarAdapter(getApplicationContext(), resultList);
                            list.setAdapter(resultAdapter);
                            list.setVisibility(View.VISIBLE);
                            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    dialog.dismiss();
                                    Intent intent = new Intent(PeiseActivity.this, CarActivity.class);
                                    intent.putExtra("request", "Look");
                                    intent.putExtra("id", searchCar.getId());
                                    intent.putExtra("name", searchCar.getName());
                                    intent.putExtra("color", searchCar.getColor());
                                    intent.putExtra("sm1", searchCar.getSm1());
                                    intent.putExtra("sm2", searchCar.getSm2());
                                    intent.putExtra("sm3", searchCar.getSm3());
                                    intent.putExtra("sm4", searchCar.getSm4());
                                    intent.putExtra("sm5", searchCar.getSm5());
                                    intent.putExtra("sm6", searchCar.getSm6());
                                    intent.putExtra("sm7", searchCar.getSm7());
                                    startActivityForResult(intent, 0);
                                }
                            });
                        } else {
                            //关闭Dialog
                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(), "无此车", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //根据返回的resultCode判断是通过哪种操作返回的，并提示相关信息；
        switch (requestCode){
            case 0:
                if (resultCode==2)
                    Toast.makeText(this,"发送成功",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                if (resultCode==RESULT_OK)
                    Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
                break;
        }
        /**
         * 如果这里仅仅使用adapter.notifyDataSetChanged()是不会刷新界面ListView的，
         * 因为此时adapter中传入的carList并没有给刷新，即adapter也没有被刷新，所以你可以
         * 重新获取carList后再改变adapter，我这里通过调用onCreate()重新刷新了整个界面
         */

        //        carList=dbHandler.getALllCar();
        //        adapter=new CarAdapter(this,carList);
        //        cars.setAdapter(adapter);
        onCreate(null);
    }
}
