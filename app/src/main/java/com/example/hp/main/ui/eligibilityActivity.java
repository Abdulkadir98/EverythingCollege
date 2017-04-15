package com.example.hp.main.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hp.main.R;
import com.example.hp.main.fragments.eligibilityFragment;


public class eligibilityActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new eligibilityFragment())
                .commit();

    }
}
