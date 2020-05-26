package com.example.myapplication.obj;

import java.util.List;

public class Completed_Order extends Ongoing_Order {
    boolean completed;
    Transaction transaction_obj;



    public Completed_Order(Deliverer deliverer_obj, Receiver receiver_obj, List<String> items, Locatio address_obj, int estimated_cost, int minutes) {
        super(deliverer_obj, receiver_obj, items, address_obj, estimated_cost, minutes);
        super.status = "Ongoing";
    }

    public void assignTransaction(Transaction transaction_obj){
        this.transaction_obj = transaction_obj;
    }

    public boolean isCompleted() {
        return completed;
    }
}
