package com.example.myapplication.obj;

public class Locatio{
    String address;
    int postcode;
    int floor;
    String bell_name;
    public double lat;
    public double lon;

    public Locatio(/*String address, int postcode, int floor, String bell_name*/double x, double y){
        /*this.address = address;
        this.postcode = postcode;
        this.floor = floor;
        this.bell_name = bell_name;*/
        lat = x;
        lon = y;

    }
}
