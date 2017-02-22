package com.example.hp.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class topHundredActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setTitle("Top 25");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new topHundredFragment())
                .commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
