package com.hritiksapra.oddevenapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Choose extends AppCompatActivity {
     EditText editText;
    double sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }
     public  void click(View view)

    {
        editText = (EditText) findViewById(R.id.editText2);
        CheckBox checkBox=(CheckBox) findViewById(R.id.time);
        CheckBox checkBox2=(CheckBox) findViewById(R.id.luggage);
        int d = Integer.parseInt(editText.getText().toString());
        if (d < 2) {
            sum = d * 12.5;
        }
        if (d == 2) {
            sum = 25;
        }
        if (d > 2) {
            sum = 25 + 8 * (d - 2);
        }
        if(checkBox.isChecked())
        {
            sum= sum*0.25;
        }
        if(checkBox2.isChecked())
        {
            sum= sum+ 7.50;
        }
        editText.setText("You have to pay Rs "+ sum);
    }

}
