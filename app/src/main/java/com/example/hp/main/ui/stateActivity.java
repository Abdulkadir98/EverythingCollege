package com.example.hp.main.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.hp.main.R;
import com.example.hp.main.adapters.topHundreduniversitiesAdapter;
import com.example.hp.main.models.College;
import com.example.hp.main.models.topHundred;

import java.util.ArrayList;

public class stateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        String title= getIntent().getStringExtra("title");
        setTitle("Top colleges in "+ title);
        Log.v("Myactivity",title);
        final ArrayList<College> top = new ArrayList<College>();
        if(title.equals("Tamil Nadu"))
        {
//            top.add(new topHundred(1,"IIT Madras","Chennai"));
//            top.add(new topHundred(2,"NIT Trichy","Trichy"));
//            top.add(new topHundred(3,"VIT University","Vellore"));
//            top.add(new topHundred(4,"Thiagarajar College of Engineering","Madurai"));
//            top.add(new topHundred(5,"SRM University","Chennai"));
//            top.add(new topHundred(6,"SASTRA University","Tanjore"));
//            top.add(new topHundred(7,"PSG College of Technology","Coimbatore"));
//            top.add(new topHundred(8,"Anna University","Chennai"));
//            top.add(new topHundred(9,"Amrita College of Engineering","Coimbatore"));
//            top.add(new topHundred(10,"SSN College of Engineering","Chennai"));
            topHundreduniversitiesAdapter Adapter = new topHundreduniversitiesAdapter(this,top);

            ListView listView = (ListView)findViewById(R.id.list);
            listView.setAdapter(Adapter);


//
        }
        else if(title.equals("New Delhi"))

        {
//            top.add(new topHundred(1,"IIT Delhi","New Delhi"));
//            top.add(new topHundred(2,"Delhi Technological University","Delhi"));
//            top.add(new topHundred(3,"Netaji Subhas Institute of Technology","Delhi"));
//            top.add(new topHundred(4,"Indraprasta Institute of Information Technology","Delhi"));
//            top.add(new topHundred(5,"Guru Gobind Singh Indraprastha University","Delhi"));
//            top.add(new topHundred(6,"Maharaja Agrasen Institute of Technology","Delhi"));
//            top.add(new topHundred(7,"Jamia Millia Islamia University","Delhi"));
//            top.add(new topHundred(8,"National Power Training Institute","Delhi"));
//            top.add(new topHundred(9,"Maharaja Surajmal Institute of Technology","Delhi"));
//            top.add(new topHundred(10,"Amity School of Engineering and Technology","Delhi"));
            topHundreduniversitiesAdapter Adapter = new topHundreduniversitiesAdapter(this,top);

            ListView listView = (ListView)findViewById(R.id.list);
            listView.setAdapter(Adapter);

        }

    }
}
