package com.example.hp.main.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hp.main.R;
import com.example.hp.main.models.College;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class searchFragment extends Fragment {
    public Uri url;
    public Spinner city,college;
    public List<String> citylist,colllist;
    int position;
    Button b;
    Uri uri;
private TextView mAboutUs, mAboutUsBody;
//
    public searchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_search, container, false);
        city= (Spinner) rootView.findViewById(R.id.spinnercity);
        college=(Spinner) rootView.findViewById(R.id.spinnercollege);
        citylist= new ArrayList<String>();
        colllist=new ArrayList<String>();
        citylist.add("Chennai");
        citylist.add("New Delhi");
        citylist.add("Bangalore");
        citylist.add("Hyderabad");
        b= (Button) rootView.findViewById(R.id.button2);
//        mAboutUs = (TextView)rootView.findViewById(R.id.about_us);
//        mAboutUsBody = (TextView)rootView.findViewById(R.id.about_us_body);




        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, citylist);

        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        city.setAdapter(cityAdapter);

        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                parent.getItemAtPosition(pos);
                DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
                ref.child("Colleges").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        College c= dataSnapshot.getValue(College.class);
                        String cityn= city.getSelectedItem().toString();
                        if(cityn.equals(c.getCity()))
                        {
                              colllist.clear();
                            colllist.add(c.getName()+"");
                            ArrayAdapter<String> collAdapter = new ArrayAdapter<String>(getActivity(),R.layout.spin_item, colllist);
                            collAdapter.notifyDataSetChanged();
                            collAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                            college.setAdapter(collAdapter);
                        }
                        else
                        {
                            colllist.clear();
                        }
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }


            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = college.getSelectedItem().toString();
                if (text.equals("SRM University"))
                    uri = Uri.parse("http://www.srmuniv.ac.in/");
                else if (text.equals("IIT Madras"))
                    uri = Uri.parse("http://www.iitm.ac.in/");
                else if (text.equals("VIT Chennai"))
                    uri = Uri.parse("http://chennai.vit.ac.in/");
                else if (text.equals("Anna University"))
                    uri = Uri.parse("https://www.annauniv.edu/");
                else if (text.equals("SSN College Of Engineering"))
                    uri = Uri.parse("http://www.ssn.edu.in");
                else if (text.equals("Madras Institute Of Technology"))
                    uri = Uri.parse("www.mitindia.edu/");
                else if (text.equals("Sathyabama University"))
                    uri = Uri.parse("http://www.sathyabamauniversity.ac.in/");
                else if (text.equals("Hindustan University"))
                    uri = Uri.parse("http://hindustanuniv.ac.in/");
                else if (text.equals("Sri Venkateshwara College Of Engineering"))
                    uri = Uri.parse("https://www.svce.ac.in/");
                else if (text.equals("Delhi University"))
                    uri = Uri.parse("http://www.du.ac.in/");
                else if (text.equals("IIT Delhi"))
                    uri = Uri.parse("http://iitd.ac.in/");
                else if (text.equals("NIT Delhi"))
                    uri = Uri.parse("http://www.nitdelhi.ac.in/");
                else if (text.equals("Netaji Subhas Institute of Technology"))
                    uri = Uri.parse("http://www.nsit.ac.in/");
                else if (text.equals("Guru Gobind Singh Indraprastha University"))
                    uri = Uri.parse("http://www.ipu.ac.in/");
                else if (text.equals("Amity School of Engineering and Technology"))
                    uri = Uri.parse("http://www.amity.edu/aset/");
                else if (text.equals("Delhi Technological University"))
                    uri = Uri.parse("http://www.dtu.ac.in/");
                else if (text.equals("Bharati Vidyapeeth's College of Engineering"))
                    uri = Uri.parse("http://www.bvcoend.ac.in/");



                else if (text.equals("SRM University NCR"))
                    uri = Uri.parse("http://www.srmuniv.ac.in/ncr/");
                else if (text.equals("R.V College Of Engineering"))
                    uri = Uri.parse("http://www.rvce.edu.in/");
                else if (text.equals("IIIT Bangalore"))
                    uri = Uri.parse("http://www.iiitb.ac.in/");
                else if (text.equals("BMS College Of Engineering"))
                    uri = Uri.parse("http://www.bmsce.in/");
                else if (text.equals("IIT Hyderabad"))
                    uri = Uri.parse("https://www.iiit.ac.in/");
                else if (text.equals("BITS Hyderabad"))
                    uri = Uri.parse("http://www.bits-pilani.ac.in/hyderabad/");
                else if (text.equals("Vardhaman College Of Engineering"))
                    uri = Uri.parse("http://www.vardhaman.org/");


                Intent intent= new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });
        return rootView;
    }

}
