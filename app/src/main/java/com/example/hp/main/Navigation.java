package com.example.hp.main;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentManager;
import android.widget.ImageView;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    boolean FragmentTransaction=false;
    static int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        if(savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, cardviewfragement.newInstance())
                    .commit();

        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         Intent intent= getIntent();

        ImageView imageView=(ImageView) findViewById(R.id.imageView);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        setTitle("EverythingCollege");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent intent;
         FragmentManager f= getSupportFragmentManager();
        if(i==1)
        {
            getSupportFragmentManager()
                    .beginTransaction().
                    remove(getSupportFragmentManager().findFragmentById(R.id.container)).commit();
        }
          i--;
        if (id == R.id.nav_list_item) {

            f.beginTransaction().replace(R.id.content_frame, new topHundredFragment()).commit();

        } else if (id == R.id.nav_activity_search) {

            f.beginTransaction().replace(R.id.content_frame, new searchFragment()).commit();


        } else if (id == R.id.nav_activity_eligibility) {

            f.beginTransaction().replace(R.id.content_frame, new eligibilityFragment()).commit();


        } else if (id == R.id.nav_activity_entrance) {

            f.beginTransaction().replace(R.id.content_frame, new examsFragment()).commit();

        } else if (id == R.id.nav_list_item_scholarship) {
            f.beginTransaction().replace(R.id.content_frame, new scholarshipsFragment()).commit();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }
}
