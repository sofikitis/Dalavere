package com.example.myapplication.obj;

public class Availability {
    String location;
    int radius;
    int max_cost;
    int minutes;

    public Availability(String location, int radius, int max_cost, int minutes){
        this.location = location;
        this.radius = radius;
        this.max_cost = max_cost;
        this.minutes = minutes;

    }
}
