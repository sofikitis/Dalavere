package com.example.myapplication.obj;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    int owner_id;
    float balance;
    List<Transaction> transaction_history = new ArrayList<Transaction>();

    public Wallet(int owner_id){
        this.owner_id = owner_id;
        this.balance = 0;
    }

    void addTransaction(Transaction transaction_obj){
        transaction_history.add(transaction_obj);
    }
}


