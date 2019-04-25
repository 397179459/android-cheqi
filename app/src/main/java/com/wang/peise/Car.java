package com.wang.peise;

import java.io.Serializable;

/**
 * Created by wang on 2018/5/3.
 */

public class Car implements Serializable {
    private int id;
    private String name;
    private String color;
    private String sm1;
    private String sm2;
    private String sm3;
    private String sm4;
    private String sm5;
    private String sm6;
    private String sm7;

    public Car(){}
    public Car(int id, String name, String color, String sm1, String sm2, String sm3, String sm4,
               String sm5, String sm6, String sm7){
        this.id = id;
        this.name = name;
        this.color = color;
        this.sm1 = sm1;
        this.sm2 = sm2;
        this.sm3 = sm3;
        this.sm4 = sm4;
        this.sm5 = sm5;
        this.sm6 = sm6;
        this.sm7 = sm7;
    }

    public Car(String name, String color, String sm1, String sm2, String sm3, String sm4,
               String sm5, String sm6, String sm7){
        this.name = name;
        this.color = color;
        this.sm1 = sm1;
        this.sm2 = sm2;
        this.sm3 = sm3;
        this.sm4 = sm4;
        this.sm5 = sm5;
        this.sm6 = sm6;
        this.sm7 = sm7;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    public String getSm1(){
        return sm1;
    }
    public String getSm2(){
        return sm2;
    }
    public String getSm3(){
        return sm3;
    }
    public String getSm4(){
        return sm4;
    }
    public String getSm5(){
        return sm5;
    }
    public String getSm6(){
        return sm6;
    }
    public String getSm7(){
        return sm7;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setSm1(String sm1){
        this.sm1 = sm1;
    }
    public void setSm2(String sm2){
        this.sm2 = sm2;
    }
    public void setSm3(String sm3){
        this.sm3 = sm3;
    }
    public void setSm4(String sm4){
        this.sm4 = sm4;
    }
    public void setSm5(String sm5){
        this.sm5 = sm5;
    }
    public void setSm6(String sm6){
        this.sm6 = sm6;
    }
    public void setSm7(String sm7){
        this.sm7 = sm7;
    }
}