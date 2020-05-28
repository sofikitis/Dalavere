package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.obj.Order;
import com.example.myapplication.obj.User;
import com.example.myapplication.obj.Locatio;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Order> orderList = new ArrayList<>();
    TextView txt;
    private Button button;
    private Button login_button;
    public static User mc_vagos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_button = (Button) findViewById(R.id.login_button);   //MapActivity button paei sto xarti
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });


        button = (Button) findViewById(R.id.signup_button);       //signup button gia register
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openregister();

            }
        });

        txt = (TextView) findViewById(R.id.forgot_password);    // forgot password text retrieve password
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openforgot();
            }
        });


    }

   public void openlogin(){      //Go to MapActivity activty (xarti ktl)
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); //animation

        mc_vagos = new User("Vagos", "1234567890");
       //Log.d("Vagos ID:", String.valueOf(mc_vagos.id));
        Log.d("Wallet", String.valueOf(mc_vagos.myWallet.balance));
        Locatio adr1 = new Locatio(38.230462, 21.753150);
        Locatio adr2 = new Locatio(38.235782, 21.753590);

        List<String> items = new ArrayList<String>();
        items.add("1 Bud 500ml");
        items.add("2 Coca Cola 330ml");

        Order order1 = new Order(mc_vagos, items, adr1, 20.00001, 20);
        Order order2 = new Order(mc_vagos, null, adr2, 20.34, 30);
        orderList.add(order1);
        orderList.add(order2);

        //Log.d("Order", String.valueOf(orderList.get(0).estimated_cost));

   }


    public void openregister() {   //paei sto sign-up page
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); //animation

    }

    public void openforgot(){   //paei sto forgetpassword page
        Intent intent = new Intent(this, forgotpassword.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); //animation

    }


    @Override
    public void onBackPressed() {       //Back button kleinei to app otan einai sto MainActivity activity
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
