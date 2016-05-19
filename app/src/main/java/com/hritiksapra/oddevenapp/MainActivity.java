package com.hritiksapra.oddevenapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.editText);
    }
    public void uber(View view)
    {
        if(editText.getText().toString().equals(""))
        {
            Toast.makeText(MainActivity.this, "Please Enter Your Car Number", Toast.LENGTH_SHORT).show();
        }
        else {
            SharedPreferences sharedPreferences = getSharedPreferences("CarNumber", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("carnum", editText.getText().toString());
            editor.commit();
            Intent intent4 = new Intent(MainActivity.this, CarData.class);
            startActivity(intent4);
        }
    }
    public void autofunction(View v)
    {
        Intent intent1=new Intent(this, Choose.class);
        startActivity(intent1);
    }
    public void taxiFunction(View v)
    {
        Intent intent1=new Intent(this, Taxi.class);
        startActivity(intent1);
    }
    public void carbase(View view)
    {
        Intent intent=new Intent(this, CarDatabase.class);
        startActivity(intent);
    }
}
