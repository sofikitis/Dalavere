
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.obj.User;

import static com.example.myapplication.MainActivity.mc_vagos;

public class DetailsActivity extends AppCompatActivity {

    private Button AcceptButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        AcceptButton = (Button) findViewById(R.id.acceptButton);   //MapActivity button paei sto xarti
        AcceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mc_vagos.sendRequestToReciever();
            }
        });

    }


}
