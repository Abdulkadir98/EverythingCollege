package com.example.hp.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hp.main.R;


public class SplashScreen extends AppCompatActivity {
    private static final int SPLASH_TIME = 3000;
    static int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread th= new Thread(){

            @Override
            public void run() {


                try {
                    sleep(1000);
                    Intent intent= new Intent(getApplicationContext(),Navigation.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        th.start();
    }
}
