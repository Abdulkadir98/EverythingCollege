package com.example.hp.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class examsActivity extends AppCompatActivity {

    String srmUrl , vitUrl, iitUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);
        vitUrl = "www.vit.ac.in/admissions/viteee/";
        srmUrl = "www.srmuniv.ac.in/";
        iitUrl = "jeemain.nic.in/";

        final ArrayList<topHundred.Exams> exams = new ArrayList<>();
        exams.add(new topHundred.Exams("SRMJEE", Uri.parse("http://www.srmuniv.ac.in/")));
        exams.add(new topHundred.Exams("VITEEE", Uri.parse("http://www.vit.ac.in/admissions/viteee/")));
        exams.add(new topHundred.Exams("JEE Mains", Uri.parse("http://jeemain.nic.in/")));

        examsAdapter Adapter = new examsAdapter(this, exams);
        ListView listView = (ListView)findViewById(R.id.list_exam);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                topHundred.Exams exam = exams.get(position);
                Uri uri = exam.getUrl();

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
