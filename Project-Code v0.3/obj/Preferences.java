package com.example.myapplication.obj;

import java.util.ArrayList;
import java.util.List;

public class Preferences {
    List<Address> addresses = new ArrayList<Address>();

    Preferences(){

    }
	
	public void addAddress(Address d){
		addresses.add(d);
	}


    void configurateOrders(){}

    void configurateDeliverers(){}

    void orderPreferences(){}

    void delivererPreferences(){}

    void saveChanges(){}

}
