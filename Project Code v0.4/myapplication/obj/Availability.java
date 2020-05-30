package com.example.myapplication.obj;

public class Availability {
    public Locatio location;
    public int radius;
    public int max_cost;
    public int minutes;

    public Availability(Locatio location, int radius, int max_cost, int minutes){
        this.location = location;
        this.radius = radius;
        this.max_cost = max_cost;
        this.minutes = minutes;

    }
}
