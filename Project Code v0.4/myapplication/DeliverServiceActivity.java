package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.obj.Availability;
import com.example.myapplication.obj.Deliverer;
import com.example.myapplication.obj.Locatio;
import com.example.myapplication.obj.Order;
import com.example.myapplication.obj.User;

import static com.example.myapplication.MainActivity.mc_vagos;
import static com.example.myapplication.MainActivity.orderList;
import  java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class DeliverServiceActivity extends AppCompatActivity {

    private Button deliverServButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver_service);

        deliverServButton = (Button) findViewById(R.id.deliverServiceButton);
        deliverServButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeDelSerInp();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void takeDelSerInp(){

        //Log.d("testtag", "doulepse");

        EditText edit = (EditText)findViewById(R.id.availDS);
        final String minStr = edit.getText().toString();

        edit = (EditText)findViewById(R.id.maxcostDS);
        final String costStr = edit.getText().toString();

        edit = (EditText)findViewById(R.id.radiusDS);
        final String radiusStr = edit.getText().toString();

        double x = 38.23 + Math.random()*0.009999;
        double y = 21.75 + Math.random()*0.009999;
        Locatio availLoc = new Locatio(x, y);

        MainActivity.mc_vagos.createAvailability(minStr, costStr, radiusStr, availLoc);

        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}