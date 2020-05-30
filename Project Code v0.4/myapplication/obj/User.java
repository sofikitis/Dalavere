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
//__RECIEVER
    public void createOrder(List<String> items, String commnents, String costStr, String minStr, Locatio ordLoc){

        double cost = Double.parseDouble(costStr);
        int min = Integer.parseInt(minStr);
        Order newOrder = new Order(this, items, ordLoc, cost, min);
        MainActivity.orderList.add(newOrder);

    }
    void sendRequestToDeliverer(Deliverer delObj){

    /*
        boolean answer;
        show Request_to_deliverer_form();
        if(order.estimated_cost > delObj.avail.max_cost){
            //display Failure Message to user
        }else {
            send request to delObj
            get answer
            if(answer){
                create ongoing order(...);
            }else{
                show failure_message();
            }
        }
     */


    }
    //___DELIVERER
    //____Deliverer
    public void sendRequestToReciever(Order ord){
        boolean answer;
        if(ord.estimated_cost > this.myWallet.balance){
            //display Failure Message to user
        }else {
            //send request to ord.userObj
            //get answer
            answer = true; //estw
            if(answer){
                //create ongoing order(...);
            }else{
                //show failure_message();
            }
        }
    };

    public void createAvailability(String minStr, String costStr, String radiusStr, Locatio loc){

        int min = Integer.parseInt(minStr);
        int cost = Integer.parseInt(costStr);
        int radius = Integer.parseInt(radiusStr);

        Availability avail = new Availability(loc, radius, cost, min);
        Deliverer newDel = new Deliverer(avail, this.username, this.password);
        MainActivity.delivererList.add(newDel);
    }
    public void createEvaluation(Completed_Order c_ord){
        if (this.id == c_ord.deliverer_obj.id){
            // show eval_form(c_ord.receiver_obj);
            // get eval_form(c_ord.receiver_obj);
        }else {
            // show eval_form(c_ord.deliverer_obj);
            // get eval_form(c_ord.deliverer_obj);
        }
        registerEvaluation(c_ord);
    }
    public void registerEvaluation(Completed_Order c_ord){
        // ISERT INTO <EVALUATION_TABLE> <USER_EVALUATION>
    }
    public void createReport(Completed_Order c_ord){
        if (this.id == c_ord.deliverer_obj.id){
            // show report_form(c_ord.receiver_obj);
            // get report_form(c_ord.receiver_obj);
        }else {
            // show report_form(c_ord.deliverer_obj);
            // get report_form(c_ord.deliverer_obj);
        }
        registerReport(c_ord);
    }

    public void registerReport(Completed_Order c_ord){
        // ISERT INTO <REPORT_TABLE> <ORDER_REPORT>
    }

}