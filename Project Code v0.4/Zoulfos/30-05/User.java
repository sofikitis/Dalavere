package com.example.myapplication.obj;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.MainActivity;
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

    public void createOrder(List<String> items, String commnents, String costStr, String minStr, Locatio ordLoc){

        double cost = Double.parseDouble(costStr);
        int min = Integer.parseInt(minStr);
        Order newOrder = new Order(this, items, ordLoc, cost, min);
        MainActivity.orderList.add(newOrder);

    }

    public void createAvailability(String minStr, String costStr, String radiusStr, Locatio loc){

        int min = Integer.parseInt(minStr);
        int cost = Integer.parseInt(costStr);
        int radius = Integer.parseInt(radiusStr);

        Availability avail = new Availability(loc, radius, cost, min);
        Deliverer newDel = new Deliverer(avail, this.username, this.password);
        MainActivity.delivererList.add(newDel);
    }

}
