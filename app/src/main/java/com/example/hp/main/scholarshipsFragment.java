package com.example.hp.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class scholarshipsFragment extends Fragment {
    private ProgressBar mProgressBar;


    public scholarshipsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        mProgressBar = (ProgressBar)rootView.findViewById(R.id.loader_indicator);
        mProgressBar.setVisibility(View.GONE);

        final ArrayList<topHundred.Scholarship> scholarship = new ArrayList<topHundred.Scholarship>();
        scholarship.add(new topHundred.Scholarship("Engineering","Valeo Innovation Challenge 2017"));
        scholarship.add(new topHundred.Scholarship("Engineering", "IITM Summer fellowship"));
        scholarship.add(new topHundred.Scholarship("Commerce", "Oxford MBA scholarship"));
        scholarship.add(new topHundred.Scholarship("Engineering", "IET India scholarship 2017"));
        scholarship.add(new topHundred.Scholarship("MEdicine", "JBNSTS"));


        scholarshipsAdapter Adapter = new scholarshipsAdapter(getActivity(), scholarship);
        ListView listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(Adapter);
        return rootView;
    }

}
