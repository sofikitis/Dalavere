package com.example.myapplication.obj;

import android.util.Log;

import com.example.myapplication.MapActivity;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


import com.example.myapplication.MapActivity;

import static com.example.myapplication.MainActivity.orderList;

public class Order {
    public double estimated_cost;
    public int id;
    public User userObj;
    public List<String> items;
    public Locatio address_obj;
    public int minutes;
    public String status;
    static int k=0;////

    public Order(User userObj, List<String> items, Locatio address_obj, double estimated_cost, int minutes){
        this.id = k;
        this.userObj = userObj;
        this.items = items;
        this.address_obj = address_obj;
        this.estimated_cost = estimated_cost;
        this.minutes = minutes;
        this.status = "Active";
        Log.d("qwerty", "4sd57rfugiiu787");
        k++;
    }

    public Order getOrderByID(int cid){
        for (int j = 0; j<=orderList.size(); j++){
            if (orderList.get(j).id == cid){
                return orderList.get(j);
            }
        }
        return null;
    }
    public void registerOrder(){
        //INSERT INTO <ORDERS_DB_TABLE> <ORDER>
    }

    public void showOrderOnMap(){}

    public void showPopup(){}

    public void showOrederDetails(){}

    public boolean checkOrderStatus(){
        if (status.equals("Active")) {
            return true;
        }else return false;
    }

    void updateOrder(){
        if(checkOrderStatus()){
            // open order_update_form();
        }else{
            // show popup message ("Order can not be updated")
        }
    }

    void cancelOrder(){
        if(checkOrderStatus()){
            // open order_cancel_form();
        }else{
            // show popup message ("Order can not be canceled")
        }
    }

}
