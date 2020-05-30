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
}
