package com.example.myapplication.obj;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    int owner_id;
    public static double balance;
    List<Transaction> transaction_history = new ArrayList<Transaction>();

    public Wallet(int owner_id){
        this.owner_id = owner_id;
        this.balance = 20.1234560;
    }



    void addTransaction(Transaction transaction_obj){
        transaction_history.add(transaction_obj);
    }
    
     public void chargeWallet(){
        // get card info
        // request transaction

        /*
        if (status.equals("Successful")){
            update balance
        }else{
            show card denied message
        }
        */
    }

    public void unChargeWallet(){
        // get card info
        // request transaction

        /*
        if (status.equals("Successful")){
            update balance
        }else{
            show error message
        }
        */
    }

    public void completeOrderTransaction(Transaction trans){
        // transfer trans.final_cost from trans.receiver_obj to trans.deliverer_obj
    }

    public void createTranscaction(Ongoing_Order ord, double f_cost){

        Transaction trans = new Transaction(ord.receiver_obj, ord.deliverer_obj, f_cost);

    }
}


