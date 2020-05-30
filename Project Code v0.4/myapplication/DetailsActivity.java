
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

public class DetailsActivity extends AppCompatActivity {

    private Button AcceptButton;
    public int selectedOrder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //gia dynamikh emfanisi thw paraggeliaw sthn othoni details
        Bundle extras = getIntent().getExtras();
        selectedOrder = Integer.parseInt(extras.getString("ORDER"));
        Log.d("SELECTEDORDER", String.valueOf(selectedOrder));
        //ord = getOrderByID(selectedOrder);
        TextView textView1 = (TextView) findViewById(R.id.reqTime);
        textView1.setText(String.valueOf(orderList.get(selectedOrder).minutes));
        TextView textView2 = (TextView) findViewById(R.id.userRating);
        textView2.setText(String.valueOf(orderList.get(selectedOrder).userObj.rating));
        TextView textView3 = (TextView) findViewById(R.id.priceSer);
        textView3.setText(Double.toString(orderList.get(selectedOrder).estimated_cost));
        TextView textView4 = (TextView) findViewById(R.id.serFee);
        textView4.setText(Double.toString(orderList.get(selectedOrder).estimated_cost * 0.1));
        /*TextView textView5 = (TextView) findViewById(R.id.dist);
        textView5.setText(orderList.get(selectedOrder).d);*/
        TextView textView6 = (TextView) findViewById(R.id.itemsList);
        textView6.setText(String.valueOf(orderList.get(selectedOrder).items));

        //Button gia apodoxi h apostolh tropopoihsevn
        AcceptButton = (Button) findViewById(R.id.acceptButton);
        AcceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mc_vagos.sendRequestToReciever();
            }
        });

    }

}