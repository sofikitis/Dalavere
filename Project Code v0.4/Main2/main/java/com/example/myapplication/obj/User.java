package com.example.myapplication.obj;

import java.util.ArrayList;
import java.util.List;
import com.example.myapplication.obj.Wallet;

public class User {
    public int id;
    public static Wallet myWallet;
    String username;
    String password;
    Preferences myPreferences;
    public double rating;
    List<Completed_Order> history = new ArrayList<Completed_Order>();

    private int generateUniqueId(){
        return 1234567890; // Unique Generator Function
    }

    public User(String username, String password){
        id = generateUniqueId();
        this.username = username;
        this.password = password;
		createWallet(this.id);
		myPreferences = new Preferences();
		rating = 0;

    }

    public User(){
        id = generateUniqueId();
    }


    public void createWallet(int id){
        myWallet = new Wallet(id);
    }

    public void updateHistory(Completed_Order order_obj){
        history.add(order_obj);
    }

    public void sendRequestToReciever(){


    };

}
