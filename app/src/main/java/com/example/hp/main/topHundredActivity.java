package com.example.hp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class topHundredActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_hundred);

         final ArrayList<topHundred> top100 = new ArrayList<topHundred>();
        top100.add(new topHundred(1, "IIT Kanpur","Kanpur"));
        top100.add(new topHundred(2,"Indian Institute of Science","Bangalore"));
        top100.add(new topHundred(3,"Jawaharlal Nehru University","New Delhi"));
        top100.add(new topHundred(4,"University of Hyderabad","Hyderabad"));
        top100.add(new topHundred(5,"Delhi University","Delhi"));
        top100.add(new topHundred(6,"Anna University","Tamil Nadu"));

        topHundreduniversitiesAdapter Adapter = new topHundreduniversitiesAdapter(this,top100);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(Adapter);
    }
}
