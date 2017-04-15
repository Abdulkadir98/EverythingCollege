package com.example.hp.main.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hp.main.R;
import com.example.hp.main.adapters.SimpleFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity  {
    private static final String COLLEGE_WEBSITE_URL = "https://data.gov.in/api/datastore/resource.json?resource_id=44bea382-c525-4740-8a07-04bd20a99b52";
    private static final String EARTHQUAKE_URL  = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-12-01&minmagnitude=8";
    private static final String TAG = MainActivity.class.getSimpleName();
//

    public static final String API_URL_STRING = "https://cskcecback.herokuapp.com";
    public static final String API_NAME="name";
    public static final String API_KEY1="everythingcollegeadmin97";
    public static final String API_TOP25FILE = "top25rankings.php";
    
    // So the API url for top 25 will look like this - https://cskcecback.herokuapp.com/top25rankings.php?name=everythingcollegeadmin97
    
    public static final String API_OBTAIN_TOP25 = "https://cskcecback.herokuapp.com/top25rankings.php?name=everythingcollegeadmin97";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(this, MyIntentService.class);
//        startActivity(intent);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SimpleFragmentPagerAdapter Adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(Adapter);
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
//        tabLayout.setupWithViewPager(viewPager);
//        topHundredAsyncTask task = new topHundredAsyncTask();
//        task.execute(COLLEGE_WEBSITE_URL + "&api-key=" + API_KEY);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.everythingcollege_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_refresh:
                //Do nothing for now
                break;
        }
        return true;
    }



}





