package com.example.myapplication.obj;

import android.util.Log;

import com.example.myapplication.MapActivity;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


import com.example.myapplication.MapActivity;

public class Order {
    public double estimated_cost;
    //id
    public User userObj;
    public List<String> items;
    public Locatio address_obj;
    public int minutes;
    public String status;

    public Order(User userObj, List<String> items, Locatio address_obj, double estimated_cost, int minutes){
        //this.receiver_obj = receiver_obj;
        this.userObj = userObj;
        this.items = items;
        this.address_obj = address_obj;
        this.estimated_cost = estimated_cost;
        this.minutes = minutes;
        this.status = "Active";
        Log.d("qwerty", "4sd57rfugiiu787");
        //showOnMap();
    }


}
