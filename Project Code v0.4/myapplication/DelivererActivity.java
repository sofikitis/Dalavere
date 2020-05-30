package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.obj.Order;
import com.example.myapplication.obj.User;

import static com.example.myapplication.MainActivity.mc_vagos;
import static com.example.myapplication.MainActivity.orderList;
import  java.lang.Math;

public class DelivererActivity extends AppCompatActivity {

    private Button SendExisting;
    private Button SendNew;
    //public int selectedOrder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deliverer_details);

    }
}
