package com.example.hp.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.main.R;
import com.example.hp.main.fragments.PredicterFragment;
import com.example.hp.main.fragments.eligibilityFragment;
import com.example.hp.main.fragments.examsFragment;
import com.example.hp.main.fragments.scholarshipsFragment;
import com.example.hp.main.fragments.searchFragment;
import com.example.hp.main.fragments.topHundredFragment;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView mAboutUs , mAboutUsBody;
static int i=1;
    NavigationView n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, cardviewfragement.newInstance())
//                    .commit();
//        }
        n= (NavigationView)findViewById(R.id.nav_view);

        onNavigationItemSelected(n.getMenu().findItem(R.id.nav_list_item));
        onNavigationItemSelected(n.getMenu().getItem(0));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         Intent intent= getIntent();
//        mAboutUs = (TextView)findViewById(R.id.about_us);
//        mAboutUsBody = (TextView)findViewById(R.id.about_us_body);

//        mAboutUs.setText("About Us");
//        mAboutUs.setTypeface(EasyFonts.androidNationItalic(getApplicationContext()));
//
//        mAboutUsBody.setText("Placeholder Data.....\n...........\n..........\n");


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
        int id;

        id=item.getItemId();
         FragmentManager f= getSupportFragmentManager();
//        if(i==1)
//        {
//            getSupportFragmentManager()
//                    .beginTransaction().
//                    remove(getSupportFragmentManager().findFragmentById(R.id.container)).commit();
//        }
//        i--;
//if(i==1)
//{
//    mAboutUs.setText("");
//    mAboutUsBody.setText("");
//}
//        i--;
        f.beginTransaction().replace(R.id.content_frame, new topHundredFragment()).commit();
        if (id == R.id.nav_list_item) {

             f.beginTransaction().replace(R.id.content_frame, new topHundredFragment()).commit();

        } else if (id == R.id.nav_activity_search) {
            f.beginTransaction().replace(R.id.content_frame, new searchFragment()).commit();


        } else if (id == R.id.nav_activity_eligibility) {
            f.beginTransaction().replace(R.id.content_frame, new eligibilityFragment()).commit();


        } else if (id == R.id.nav_activity_entrance) {
            f.beginTransaction().replace(R.id.content_frame, new examsFragment()).commit();
//
        }
        else if (id== R.id.nav_list_item_s){
            f.beginTransaction().replace(R.id.content_frame, new scholarshipsFragment()).commit();
        }
        else if (id== R.id.nav_fragment_predicter){
            f.beginTransaction().replace(R.id.content_frame, new PredicterFragment()).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
