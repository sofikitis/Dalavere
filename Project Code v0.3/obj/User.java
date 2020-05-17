package com.example.myapplication.obj;

import java.util.ArrayList;
import java.util.List;
import com.example.myapplication.obj.Wallet;

public class User {
    int id;
    String username;
    String password;
    Wallet myWallet;
    Preferences myPreferences;
    float rating;
    List<Completed_Order> history = new ArrayList<Completed_Order>();

    private int generateUniqueId(){
        return 5; // Unique Generator Function
    }

    public User(String username, String password){
        id = generateUniqueId();
        this.username = username;
        this.password = password;
		createWallet(this.id);
		myPreferences = new Preferences();
		rating = 0;

    }

    User(){}

//____Genika
    public void createWallet(int id){
        myWallet = new Wallet(id);
    }

    public void updateHistory(Completed_Order order_obj){
        history.add(order_obj);
    }


    void createEvaluation(){}

    void registerEvaluation(){}

    void createReport(){}

    void registerReport(){}



//____Reciever
    void crateOrder(){}

    void sendRequestToDeliverer(){}


//____Deliverer

    void sendRequestToReciever(){}


}
