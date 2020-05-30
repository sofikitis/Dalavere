package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.obj.Locatio;
import com.example.myapplication.obj.Order;
import com.example.myapplication.obj.User;

import static com.example.myapplication.MainActivity.mc_vagos;
import static com.example.myapplication.MainActivity.orderList;
import  java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class CreateOrderActivity extends AppCompatActivity {

    private Button createOrd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.requestservice_activity);

        createOrd = (Button) findViewById(R.id.createOrderButton);
        createOrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeOrderInp();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void takeOrderInp(){

        Log.d("testtag", "doulepse");
        EditText edit = (EditText)findViewById(R.id.itemsCO);
        final List<String> items = new ArrayList<String>();
        items.add(edit.getText().toString());

        edit = (EditText)findViewById(R.id.commentCO);
        final String comments = edit.getText().toString();

        edit = (EditText)findViewById(R.id.costCO);
        final String costStr = edit.getText().toString();

        edit = (EditText)findViewById(R.id.timeCO);
        final String minStr = edit.getText().toString();

        double x = 38.23 + Math.random()*0.009999;
        double y = 21.75 + Math.random()*0.009999;
        Locatio orderLoc = new Locatio(x, y);

        mc_vagos.createOrder(items, comments, costStr, minStr, orderLoc);

        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
