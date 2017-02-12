package com.example.hp.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class searchActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new searchFragment())
                .commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

}

