package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Map;

public class pref_ui extends AppCompatActivity {
     TextView textView, textView2, textView3, textView4;
     SeekBar seekBar, seekBar2, seekBar3, seekBar4;
     public int pref1, pref2, pref3, pref4; // times poy epilegi apo to scrollbar pref1=distance_paragkelion pref2=price_paragkelion pref3=distance_deliveradon pref4= price_deliveradon
     Button apply_button, cancel_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefe_ui);
        //
        textView = findViewById(R.id.bar_text);
        seekBar = findViewById(R.id.scroll_bar);
        textView2 = findViewById(R.id.bar_text2);
        seekBar2 = findViewById(R.id.scroll_bar2);
        textView3 = findViewById(R.id.bar_text3);
        seekBar3 = findViewById(R.id.scroll_bar3);
        textView4 = findViewById(R.id.bar_text4);
        seekBar4 = findViewById(R.id.scroll_bar4);

        //////////////////////////////////////////
        // scrollbar gia distance range gia paragkelies //
        /////////////////////////////////////////
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("" + progress + "m");
                pref1 = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        //////////////////////////////////////////
        // scrollbar gia price range gia paragkelies //
        /////////////////////////////////////////
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar2, int progress2, boolean fromUser2) {
                textView2.setText("" + progress2 + "$");
                pref2 = progress2;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar2) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {}
        });
        //////////////////////////////////////////
    // scrollbar gia distance range gia deliverades //
        /////////////////////////////////////////
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar3, int progress3, boolean fromUser3) {
                textView3.setText("" + progress3 + "m");
                pref3 = progress3;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar3) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar3) {}
        });
        //////////////////////////////////////////
        // scrollbar gia price range gia deliverades //
        /////////////////////////////////////////
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar4, int progress4, boolean fromUser4) {
                textView4.setText("" + progress4 + "$");
                pref4 = progress4;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar4) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar4) {}
        });

            apply_button = (Button) findViewById(R.id.apply_pref);           // apply allages koubi
            apply_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(pref_ui.this, "test: " + pref1 + " "+ pref2 + " "+ pref3+ " " + pref4, Toast.LENGTH_SHORT).show();
                }
            });
        cancel_button = (Button) findViewById(R.id.cancel_pref);           // se paei piso sto xarti xoris na apothikevei tis alages
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel_pref_button();
            }
        });

    }

    private void cancel_pref_button() {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

}
