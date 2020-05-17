package com.example.myapplication.obj;

public class Receiver extends User {
    //String status;
    Order order_obj;

    public Receiver(Order order_obj){
        //status = "Available";
        this.order_obj = order_obj;

    }

    order_obj.showOnMap();

    void acceptRequest(){}

    void declineRequest(){}
}