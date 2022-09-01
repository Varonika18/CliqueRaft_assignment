package com.example.myassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText inputtext;
    PopupWindow popupWindow;
    LinearLayout linearLayout1;
     Button buttona,buttonb,buttonc,buttond,closePopupBtn;
     TextView textView;

    Dialog nDialog;
     String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputtext=findViewById(R.id.inputtext);
        buttona=findViewById(R.id.buttona);
        buttonb=findViewById(R.id.buttonb);
        buttonc=findViewById(R.id.buttonc);
        buttond=findViewById(R.id.buttond);
        textView=findViewById(R.id.text_view);
        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        st= inputtext.getText().toString();

        nDialog=new Dialog(this);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(inputtext.getText().toString()))
                {
                    Toast.makeText(MainActivity.this,
                            "Empty field not allowed!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,
                            inputtext.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(inputtext.getText().toString()))
                {
                    Toast.makeText(MainActivity.this,
                            "Empty field not allowed!",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,"My Notification");
                    builder.setContentTitle(inputtext.getText().toString());
                    builder.setContentText("This is my assignment");
                    builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
                    builder.setAutoCancel(true);
                    NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
                    managerCompat.notify(1,builder.build());
                    buttonb.setVisibility(View.INVISIBLE);
                }

            }
        });
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(inputtext.getText().toString()))
                {
                    Toast.makeText(MainActivity.this,
                            "Empty field not allowed!",
                            Toast.LENGTH_SHORT).show();
                }
                else {


                    LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View customView = layoutInflater.inflate(R.layout.popup,null);


                    closePopupBtn = (Button) customView.findViewById(R.id.closePopupBtn);


                    //instantiate popup window
                    popupWindow = new PopupWindow(customView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);

                    //display the popup window
                    popupWindow.showAtLocation(linearLayout1, Gravity.CENTER, 0, 0);

                    //close the popup window on button click
                    closePopupBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            popupWindow.dismiss();
                        }
                    });





                }
            }


        });

        buttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(inputtext.getText().toString()))
                {
                    Toast.makeText(MainActivity.this,
                            "Empty field not allowed!",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                inputtext.setText("COMPLETED");}
            }
        });
    }
}