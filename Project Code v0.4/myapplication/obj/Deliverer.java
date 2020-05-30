package com.example.myapplication.obj;

public class Deliverer extends User {
    String status;
    public Availability avail;


    public Deliverer(Availability availability_obj, String username, String password){
        super(username, password);
        status = "Available";
        this.avail = availability_obj;
    }
    void RewuestReply() {


        /*
        show request popup
        get.answer
        if (answer.equals("Accept")) {
            return true;

        } else {
            return false;
        }
        */


    }
}
