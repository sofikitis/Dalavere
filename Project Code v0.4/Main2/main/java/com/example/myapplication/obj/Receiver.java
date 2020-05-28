package com.example.myapplication.obj;

public class Receiver extends User {

    Order order_obj;

    public Receiver(Order order_obj, String username, String password){
        super(username, password);
        this.order_obj = order_obj;

    }
}

