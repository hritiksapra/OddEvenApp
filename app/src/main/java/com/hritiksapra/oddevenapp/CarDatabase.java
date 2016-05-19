package com.hritiksapra.oddevenapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CarDatabase extends AppCompatActivity {
    String Default=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_database);
        SharedPreferences sharedPreferences=getSharedPreferences("CarNumber", Context.MODE_PRIVATE);
        String carnum=sharedPreferences.getString("carnum", Default );
        TextView textView=(TextView) findViewById(R.id.carData);
        textView.setText(carnum);
    }
}
