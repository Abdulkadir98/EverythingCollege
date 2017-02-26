package com.example.hp.main;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class examsFragment extends Fragment {
    String srmUrl , vitUrl, iitUrl;
    private ProgressBar mProgressBar;
    private TextView mAboutUs, mAboutUsBody;


    public examsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_view, container, false);
        vitUrl = "www.vit.ac.in/admissions/viteee/";
        srmUrl = "www.srmuniv.ac.in/";
        iitUrl = "jeemain.nic.in/";

        mProgressBar = (ProgressBar)rootView.findViewById(R.id.loader_indicator);
        mProgressBar.setVisibility(View.GONE);
        mAboutUs = (TextView)rootView.findViewById(R.id.about_us);
        mAboutUsBody = (TextView)rootView.findViewById(R.id.about_us_body);


        final ArrayList<topHundred.Exams> exams = new ArrayList<>();
        exams.add(new topHundred.Exams("SRMJEE", Uri.parse("http://www.srmuniv.ac.in/")));
        exams.add(new topHundred.Exams("VITEEE", Uri.parse("http://www.vit.ac.in/admissions/viteee/")));
        exams.add(new topHundred.Exams("JEE Mains", Uri.parse("http://jeemain.nic.in/")));

        examsAdapter Adapter = new examsAdapter(getActivity(), exams);
        ListView listView = (ListView)rootView.findViewById(R.id.list);
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
        return rootView;
    }

}
