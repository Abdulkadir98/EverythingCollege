package com.example.hp.main;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class topHundredFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<topHundred>>{
    private topHundreduniversitiesAdapter mAdapter;
private ArrayList<topHundred> top25;
private TextView emptyView;
    private AVLoadingIndicatorView mProgressBar;
    ListView listView;

    public topHundredFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.list_view, container, false);
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

        top25 = new ArrayList<>();
        mAdapter = new topHundreduniversitiesAdapter(getActivity(),new ArrayList<topHundred>());
        mProgressBar = (AVLoadingIndicatorView) rootView.findViewById(R.id.loader_indicator);
        startAnim();

         listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(mAdapter);
         emptyView = (TextView)rootView.findViewById(R.id.no_internet_connection);
        listView.setEmptyView(emptyView);
       //TODO Initialise the Loader here

        getLoaderManager().initLoader(0, null, this).forceLoad();
        setHasOptionsMenu(true);
        return rootView;
    }

    @Override
    public Loader<ArrayList<topHundred>> onCreateLoader(int id, Bundle args) {
        return new TopCollegesLoader(getActivity().getApplicationContext());
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<topHundred>> loader, final ArrayList<topHundred> data) {
        emptyView.setText("No Internet Connection");

        mAdapter.setColleges(data);
        stopAnim();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                topHundred topHundred = data.get(i);
                Uri uri = topHundred.getUrl();
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onLoaderReset(Loader<ArrayList<topHundred>> loader) {
     mAdapter.setColleges(new ArrayList<topHundred>());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.everythingcollege_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== R.menu.everythingcollege_menu){
            getLoaderManager().restartLoader(0, null, this).forceLoad();

        }return true;
    }
    void startAnim(){
        mProgressBar.show();
        // or avi.smoothToShow();
    }

    void stopAnim(){
        mProgressBar.hide();
        // or avi.smoothToHide();
    }
}
