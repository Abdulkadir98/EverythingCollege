package com.example.hp.main;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.hp.main.R.drawable.top100;

public class searchActivity extends AppCompatActivity {

public Uri url;
    public Spinner city,college;
    public List<String> citylist,colllist;
    int position;
    Button b;
    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
         city= (Spinner) findViewById(R.id.spinnercity);
        college=(Spinner) findViewById(R.id.spinnercollege);
         citylist= new ArrayList<String>();
         colllist=new ArrayList<String>();
        citylist.add("Chennai");
        citylist.add("New Delhi");
        b= (Button) findViewById(R.id.button2);



        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, citylist);

        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        city.setAdapter(cityAdapter);

        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
            parent.getItemAtPosition(pos);
                if(pos==0||pos==-1)
                {
                    colllist.clear();
                    colllist.add("S R M University");
                    colllist.add("I I T Madras");
                    colllist.add("V I T Chennai");

                    ArrayAdapter<String> collAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spin_item, colllist);
                    collAdapter.notifyDataSetChanged();
                    collAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    college.setAdapter(collAdapter);



                }

                else
                {
                    colllist.clear();
                    colllist.add("Delhi University");
                    colllist.add("I I T Delhi");
                    colllist.add("S R M University NCR");

                    ArrayAdapter<String> collAdapter1 = new ArrayAdapter<String>(getApplicationContext(), R.layout.spin_item, colllist);
                    collAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    collAdapter1.notifyDataSetChanged();
                    college.setAdapter(collAdapter1);
                    college.setSelection(position);

                }



            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String text = college.getSelectedItem().toString();
        if (text.equals("S R M University"))
            uri = Uri.parse("http://www.srmuniv.ac.in/");
        else if (text.equals("I I T Madras"))
            uri = Uri.parse("http://www.iitm.ac.in/");
        else if (text.equals("V I T Chennai"))
            uri = Uri.parse("http://chennai.vit.ac.in/");
        else if (text.equals("Delhi University"))
            uri = Uri.parse("http://www.iitd.ac.in/");
        else if (text.equals("I I T Delhi"))
            uri = Uri.parse("http://www.iitd.ac.in/");
        else
            uri = Uri.parse("http://www.srmuniv.ac.in/ncr/");
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);

    }
});

    }

}

