package com.example.hp.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hp.main.R;
import com.example.hp.main.fragments.topHundredFragment;

public class topHundredActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setTitle("Top 25");
        Intent intent=getIntent();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new topHundredFragment())
                .commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.everythingcollege_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.menu.everythingcollege_menu){
            //Do nothing for now
        }
        return true;

    }
}
