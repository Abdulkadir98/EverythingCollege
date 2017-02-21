package com.example.hp.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String API_URL_STRING = "https://cskcecback.herokuapp.com";
    public static final String API_NAME="name";
    public static final String API_KEY="everythingcollegeadmin97";
    public static final String API_TOP25FILE = "top25rankings.php";
    
    // So the API url for top 25 will look like this - https://cskcecback.herokuapp.com/top25rankings.php?name=everythingcollegeadmin97
    
    public static final String API_OBTAIN_TOP25 = "https://cskcecback.herokuapp.com/top25rankings.php?name=everythingcollegeadmin97";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        SimpleFragmentPagerAdapter Adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(Adapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


    }




}
