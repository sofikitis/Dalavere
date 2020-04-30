package com.example.myapplication.obj;

import java.util.List;

public class Ongoing_Order extends Order {
    Deliverer deliverer_obj;


    Ongoing_Order(Deliverer deliverer_obj, Receiver receiver_obj, List<String> items, Address address_obj, float estimated_cost, int minutes) {
        super(receiver_obj, items, address_obj, estimated_cost, minutes);
        super.status = "Ongoing";
    }

    public void assignDeliverer(Deliverer deliverer_obj){
        this.deliverer_obj = deliverer_obj;
    }


}
