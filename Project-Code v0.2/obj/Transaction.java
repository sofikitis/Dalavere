package com.example.myapplication.obj;

public class Transaction {
    Receiver receiver_obj;
    Deliverer deliverer_obj;
    float final_cost;

    public Transaction(Receiver receiver_obj, Deliverer deliverer_obj, float final_cost){
        this.receiver_obj = receiver_obj;
        this.deliverer_obj = deliverer_obj;
        this.final_cost = final_cost;
    }

    //public generateQR(){
    //  return QR
    //}


}
