package com.wang.peise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wang on 2018/5/3.
 */

public class CarAdapter extends BaseAdapter {
    private List<Car> cars;
    private Context context;

    public CarAdapter(Context context, List<Car> cars) {
        super();
        this.cars = cars;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int i) {
        return cars.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        }
        TextView tvName = (TextView) view.findViewById(R.id.name);
        TextView tvColor = (TextView) view.findViewById(R.id.color);
        TextView tvSm1 = view.findViewById(R.id.sm1);
        TextView tvSm2 = view.findViewById(R.id.sm2);
        TextView tvSm3 = view.findViewById(R.id.sm3);
        TextView tvSm4 = view.findViewById(R.id.sm4);
        TextView tvSm5 = view.findViewById(R.id.sm5);
        TextView tvSm6 = view.findViewById(R.id.sm6);
        TextView tvSm7 = view.findViewById(R.id.sm7);
        tvName.setText(" "+cars.get(i).getName());
        tvColor.setText(" "+cars.get(i).getColor());
        tvSm1.setText(" "+cars.get(i).getSm1());
        tvSm2.setText(" "+cars.get(i).getSm2());
        tvSm3.setText(" "+cars.get(i).getSm3());
        tvSm4.setText(" "+cars.get(i).getSm4());
        tvSm5.setText(" "+cars.get(i).getSm5());
        tvSm6.setText(" "+cars.get(i).getSm6());
        tvSm7.setText(" "+cars.get(i).getSm7());
        return view;
    }
}