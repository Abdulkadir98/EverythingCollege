package com.example.hp.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.github.florent37.materialviewpager.MaterialViewPager;

import java.util.ArrayList;

public class scholarshipActivity extends AppCompatActivity {
    private MaterialViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholarship);
        final ArrayList<topHundred.Scholarship> scholarship = new ArrayList<topHundred.Scholarship>();
        scholarship.add(new topHundred.Scholarship("Engineering","Valeo Innovation Challenge 2017"));
        scholarship.add(new topHundred.Scholarship("Engineering", "IITM Summer fellowship"));
        scholarship.add(new topHundred.Scholarship("Commerce", "Oxford MBA scholarship"));
        scholarship.add(new topHundred.Scholarship("Engineering", "IET India scholarship 2017"));
        scholarship.add(new topHundred.Scholarship("MEdicine", "JBNSTS"));


scholarshipsAdapter Adapter = new scholarshipsAdapter(this, scholarship);
        ListView listView = (ListView)findViewById(R.id.list_scholarship);
        listView.setAdapter(Adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
