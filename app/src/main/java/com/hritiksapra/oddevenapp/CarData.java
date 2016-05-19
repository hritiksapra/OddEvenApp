package com.hritiksapra.oddevenapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class CarData extends AppCompatActivity {
     String Default=null;
    Uri note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_data);
        SharedPreferences sharedPreferences=getSharedPreferences("CarNumber", Context.MODE_PRIVATE);
        String carnum=sharedPreferences.getString("carnum", Default );
        TextView textView=(TextView) findViewById(R.id.textView2);
        textView.setText(carnum);
        Calendar cd=Calendar.getInstance();
        int date=cd.get(Calendar.DATE);
        int num=Integer.parseInt(carnum.substring(carnum.length()-2));
        note= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        if(date%2==0)
        {

            if(num%2!=0)
            {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(CarData.this);
                builder.setContentTitle("Devenod");
                builder.setContentText("Today is an Even Day but you have an Odd car");
                builder.setTicker("Choose a Taxi or An Auto");
                builder.setSmallIcon(R.mipmap.devenod);
                builder.setAutoCancel(true);
                builder.setSound(note);
                Intent intent=new Intent(this, Taxi.class);
                android.support.v4.app.TaskStackBuilder stackBuilder= android.support.v4.app.TaskStackBuilder.create(this);
                stackBuilder.addParentStack(Taxi.class);
                stackBuilder.addNextIntent(intent);
                PendingIntent pendingIntent=stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                Notification notification=builder.build();
                NotificationManager manager=(NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
                manager.notify(1234, notification);
            }
            else
            {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(CarData.this);
                builder.setContentTitle("Devenod");
                builder.setContentText("Drive Safely :)");
                builder.setSmallIcon(R.mipmap.devenod);
                builder.setTicker("Happy Driving");
                builder.setAutoCancel(true);
                builder.setSound(note);
                Notification notification=builder.build();
                NotificationManager manager=(NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
                manager.notify(2341, notification);
            }
        }
        else
        {
            if(num%2!=0)
            {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(CarData.this);
                builder.setContentTitle("Devenod");
                builder.setSmallIcon(R.mipmap.devenod);
                builder.setContentText("Drive Safely :)");
                builder.setTicker("Happy Driving");
                builder.setAutoCancel(true);
                builder.setSound(note);
                Notification notification=builder.build();
                NotificationManager manager=(NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
                manager.notify(1234, notification);
            }
            else
            {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(CarData.this);
                builder.setContentTitle("Devenod");
                builder.setContentText("Today is an Odd Day but you have an Even car");
                builder.setSmallIcon(R.mipmap.devenod);
                builder.setTicker("Choose a Taxi");
                builder.setSound(note);
                builder.setAutoCancel(true);
                Intent intent=new Intent(this, Taxi.class);
                android.support.v4.app.TaskStackBuilder stackBuilder= android.support.v4.app.TaskStackBuilder.create(this);
                stackBuilder.addParentStack(Taxi.class);
                stackBuilder.addNextIntent(intent);
                PendingIntent pendingIntent=stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                Notification notification=builder.build();
                NotificationManager manager=(NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
                manager.notify(123, notification);
            }
        }
    }
    public void auto(View view)
    {
        Intent intent=new Intent(this, Choose.class);
        startActivity(intent);
    }
    public void taxi(View view)
    {
        Intent intent=new Intent(this, Taxi.class);
        startActivity(intent);
    }

}
