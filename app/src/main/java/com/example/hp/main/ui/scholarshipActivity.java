package com.example.hp.main.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hp.main.R;
import com.example.hp.main.fragments.scholarshipsFragment;
import com.github.florent37.materialviewpager.MaterialViewPager;

public class scholarshipActivity extends AppCompatActivity {
    private MaterialViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new scholarshipsFragment())
                .commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//
    }
}
