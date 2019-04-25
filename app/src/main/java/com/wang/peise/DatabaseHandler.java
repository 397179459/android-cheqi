package com.wang.peise;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 2018/5/3.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Test";
    private static final String TABLE_NAME = "car";
    private static final int VERSION = 1;
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_COLOR = "color";
    private static final String KEY_SM1 = "sm1";
    private static final String KEY_SM2 = "sm2";
    private static final String KEY_SM3 = "sm3";
    private static final String KEY_SM4 = "sm4";
    private static final String KEY_SM5 = "sm5";
    private static final String KEY_SM6 = "sm6";
    private static final String KEY_SM7 = "sm7";

    private static final String CREATE_TABLE="create table "+TABLE_NAME+"("
            +KEY_ID+ " integer primary key autoincrement,"
            +KEY_NAME+" text not null,"
            +KEY_COLOR+" text not null,"
            +KEY_SM1+" text not null,"
            +KEY_SM2+" text not null,"
            +KEY_SM3+" text not null,"
            +KEY_SM4+" text not null,"
            +KEY_SM5+" text not null,"
            +KEY_SM6+" text not null,"
            +KEY_SM7+" text not null);";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addCar(Car car) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, car.getName());
        values.put(KEY_COLOR, car.getColor());
        values.put(KEY_SM1, car.getSm1());
        values.put(KEY_SM2, car.getSm2());
        values.put(KEY_SM3, car.getSm3());
        values.put(KEY_SM4, car.getSm4());
        values.put(KEY_SM5, car.getSm5());
        values.put(KEY_SM6, car.getSm6());
        values.put(KEY_SM7, car.getSm7());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Car getCar(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID, KEY_NAME, KEY_COLOR, KEY_SM1, KEY_SM2, KEY_SM3, KEY_SM4, KEY_SM5,KEY_SM6, KEY_SM7},
                KEY_NAME + "=?", new String[]{name}, null, null, null, null);

        Car car = null;
        if (cursor.moveToFirst()) {
            car = new Car(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getString(7), cursor.getString(8),
                    cursor.getString(9));
        }
        return car;
    }

    public int getCarCounts() {
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public List<Car> getALLCar() {
        List<Car> carList = new ArrayList<Car>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Car car = new Car();
                car.setId(Integer.parseInt(cursor.getString(0)));
                car.setName(cursor.getString(1));
                car.setColor(cursor.getString(2));
                car.setSm1(cursor.getString(3));
                car.setSm2(cursor.getString(4));
                car.setSm3(cursor.getString(5));
                car.setSm4(cursor.getString(6));
                car.setSm5(cursor.getString(7));
                car.setSm6(cursor.getString(8));
                car.setSm7(cursor.getString(9));
                carList.add(car);
            } while (cursor.moveToNext());
        }
        return carList;
    }

    //更新car
    public int updateCar(Car car) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, car.getName());
        values.put(KEY_COLOR, car.getColor());
        values.put(KEY_SM1, car.getSm1());
        values.put(KEY_SM2, car.getSm2());
        values.put(KEY_SM3, car.getSm3());
        values.put(KEY_SM4, car.getSm4());
        values.put(KEY_SM5, car.getSm5());
        values.put(KEY_SM6, car.getSm6());
        values.put(KEY_SM7, car.getSm7());

        return db.update(TABLE_NAME, values, KEY_ID + "=?", new String[]{String.valueOf(car.getId())});
    }

    public void deleteCar(Car car) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + "=?", new String[]{String.valueOf(car.getId())});
        db.close();
    }
}