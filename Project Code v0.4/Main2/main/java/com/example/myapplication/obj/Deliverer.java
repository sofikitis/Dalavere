package com.example.myapplication.obj;

public class Deliverer extends User {
    String status;
    public Availability avail;


    public Deliverer(Availability availability_obj, String username, String password){
        super(username, password);
        status = "Available";
        this.avail = availability_obj;
    }
}
