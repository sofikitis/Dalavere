package com.example.myapplication.obj;

import java.util.ArrayList;
import java.util.List;

public class Order {
    Receiver receiver_obj;
    List<String> items;
    Address address_obj;
    float estimated_cost;
    int minutes;
    String status;

    public Order(Receiver receiver_obj, List<String> items, Address address_obj, float estimated_cost, int minutes){
        this.receiver_obj = receiver_obj;
        this.items = items;
        this.address_obj = address_obj;
        this.estimated_cost = estimated_cost;
        this.minutes = minutes;
        this.status = "Active";
    }


    public void registerOrder(){}

    public void showOrderOnMap(){}

    public void showPopup(){}

    public void showOrederDetails(){}

    void checkOrderStatus(){}

    void updateOrder(){}

    void cancelOrder(){}





}
