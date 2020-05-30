package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.myapplication.obj.Wallet;

import static com.example.myapplication.obj.Wallet.balance;


public class wallet_ui extends AppCompatActivity {
   Button charge_wallet;
   Button uncharge_wallet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_ui);

        TextView amount_text = (TextView)findViewById(R.id.amount);       /////// pernei to ipolipo toy wallet ///////
        amount_text.setText("Balance on wallet : \t" + balance + "euro");          /////// apo to Wallet.java          ///////

        charge_wallet = (Button) findViewById(R.id.charge_wallet);   //onclick event gia charge button
        charge_wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                balance++;
                Toast.makeText(wallet_ui.this, "wallet charged", Toast.LENGTH_SHORT).show();
            }
        });

        uncharge_wallet = (Button) findViewById(R.id.uncharge_wallet);
        uncharge_wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                balance--;
                Toast.makeText(wallet_ui.this, "wallet uncharged", Toast.LENGTH_SHORT).show();
            }
        });
        


    }
    @Override
    public void finish() {      //Back button animation
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
