package com.example.myapplication.obj;

import java.util.ArrayList;
import java.util.List;

public class Preferences {
    List<Locatio> addresses = new ArrayList<Locatio>();

    Preferences(){

    }
	
	public void addAddress(Locatio d){
		addresses.add(d);
	}
    public void configurateOrders(){
        // get.distance
        // get.price
        // show on map orders with <distance> <= get.distance
        // show on map orders with <price> <= get.price
    }

    public void configurateDeliverers(){
        // get.distance
        // get.price
        // show on map deliverers with <distance> <= get.distance
        // show on map deliverers with <price> <= get.price
    }

    public void orderPreferences(){
        // open order preferences form
        // save order preferences for quick order creation
    }

    public void delivererPreferences(){
        // open availability preferences form
        // save availability preferences for quick availability creation
    }

    public void saveChanges(){
        // INSERT INTO <TABLE> <CHANGES>
    }
}
