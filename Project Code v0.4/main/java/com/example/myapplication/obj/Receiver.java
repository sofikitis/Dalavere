package com.example.myapplication.obj;

public class Receiver extends User {
    //String status;
    Order order_obj;

    Receiver(Order order_obj, String username, String password){
        //status = "Available";
        super(username, password);
        this.order_obj = order_obj;

    }
}

