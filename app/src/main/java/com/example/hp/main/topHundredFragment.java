package com.example.hp.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class topHundredFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<topHundred>>{
    private topHundreduniversitiesAdapter mAdapter;



    public topHundredFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        final ArrayList<topHundred> top100 = new ArrayList<topHundred>();
//        top100.add(new topHundred(1, "IIT Kanpur","Kanpur", Uri.parse("http://iitk.ac.in/")));
//        top100.add(new topHundred(2,"Indian Institute of Science","Bangalore",Uri.parse("http://www.iisc.ac.in/")));
//        top100.add(new topHundred(3,"Jawaharlal Nehru University","Delhi",Uri.parse("www.jnu.ac.in/")));
//        top100.add(new topHundred(4,"University of Hyderabad","Hyderabad",Uri.parse("www.uohyd.ac.in/")));
//        top100.add(new topHundred(5,"Delhi University","Delhi",Uri.parse("www.du.ac.in/")));
//        top100.add(new topHundred(6,"Anna University","Tamil Nadu",Uri.parse("https://www.annauniv.edu/")));
//        top100.add(new topHundred(7,"Indian institue of Technology","Hyderabad"));
//        top100.add(new topHundred(8,"Indian institue of Technology","Gandhinagar"));
//        top100.add(new topHundred(9,"Indian institue of Technology","Ropar"));
//        top100.add(new topHundred(10,"Indian institue of Technology","Patna"));
//        top100.add(new topHundred(11,"National Institute of Technology","Trichy"));
//        top100.add(new topHundred(12,"SRM University","Chennai"));
//        top100.add(new topHundred(13,"VIT","Vellore"));
//        top100.add(new topHundred(14,"Indian institute of Technology","Varanasi"));
//        top100.add(new topHundred(15,"Sardar Vallabhai Patel National Institue of Technology ","Surat"));
//        top100.add(new topHundred(16,"PSG college of Technology","Coimbatore"));
//        top100.add(new topHundred(17,"National institue of Technology","Karnataka"));
//        top100.add(new topHundred(18,"Birla institute of Technology","Palani"));
//        top100.add(new topHundred(19,"Birla institute of Technology","Ranchi"));
//        top100.add(new topHundred(20,"National Institute of Technology  ","Calicut"));
//        top100.add(new topHundred(21,"R.E college of Engineering","Bangalore"));
//        top100.add(new topHundred(22,"Motilal Nehru Institute of Technology","Allahabad"));
//        top100.add(new topHundred(23,"Delhi University","Delhi"));
//        top100.add(new topHundred(24,"Manipal University","Manipal"));
//        top100.add(new topHundred(25,"Amrita University","Coimbatore"));

        topHundreduniversitiesAdapter Adapter = new topHundreduniversitiesAdapter(getActivity(),top100);

        ListView listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(Adapter);
       //TODO Initialise the Loader here
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long Id) {
//                topHundred top = top100.get(position);
//                Uri uri = top.getUrl();
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
//            }
//        });

        return rootView;
    }

    @Override
    public Loader<ArrayList<topHundred>> onCreateLoader(int id, Bundle args) {
        return new TopCollegesLoader(getActivity().getApplicationContext());
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<topHundred>> loader, ArrayList<topHundred> data) {
mAdapter.setColleges(data);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<topHundred>> loader) {
     mAdapter.setColleges(new ArrayList<topHundred>());
    }
}
