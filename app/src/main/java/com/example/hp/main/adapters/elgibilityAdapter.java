package com.example.hp.main.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.main.R;
import com.example.hp.main.adapters.topHundreduniversitiesAdapter;
import com.example.hp.main.models.College;
import com.example.hp.main.ui.eligibilityActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

public class elgibilityAdapter extends AppCompatActivity {
    int cutoff1,k;
    AVLoadingIndicatorView progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        progressBar = (AVLoadingIndicatorView)findViewById(R.id.loader_indicator);
        progressBar.hide();


        cutoff1=getIntent().getIntExtra("Number", 0);
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference();

//        SQLiteDatabase mydatabase = openOrCreateDatabase("Colleges", MODE_PRIVATE, null);
//        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS ANNAUNIV(RANK NUMBER,NAME VARCHAR,CUTOFFG DECIMAL,CITY VARCHAR );");
//        mydatabase.execSQL("INSERT INTO ANNAUNIV VALUES(1,'Anna University',200,'Chennai');");
//        mydatabase.execSQL("INSERT INTO ANNAUNIV VALUES(2,'PSG College of Technology',199.5,'Coimbatore');");
//        mydatabase.execSQL("INSERT INTO ANNAUNIV VALUES(3,'Madras Institute of Technology',199,'Chennai');");
//        mydatabase.execSQL("INSERT INTO ANNAUNIV VALUES(4,'Coimbatore Institute of Technology',198,'Coimbatore');");
//        mydatabase.execSQL("INSERT INTO ANNAUNIV VALUES(5,'SSN College of Engineering',198,'Chennai');");
//        mydatabase.execSQL("INSERT INTO ANNAUNIV VALUES(6,'Sri Venkateswara College of Engineering',198,'Chennai');");
//        mydatabase.execSQL("INSERT INTO ANNAUNIV VALUES(7,'Chennai Institute of Technology',197,'Chennai');");
//        mydatabase.execSQL("INSERT INTO ANNAUNIV VALUES(8,'St Josephs College of Engineering',196,'Chennai');");
//        mydatabase.execSQL("INSERT INTO ANNAUNIV VALUES(9,'Rajalakshmi Engineering College',195,'Chennai');");
//        mydatabase.execSQL("INSERT INTO ANNAUNIV VALUES(10,'Sri Sai Ram Engineering College',194,'Chennai');");
//        mydatabase.execSQL("INSERT INTO ANNAUNIV VALUES(11,'Easwari College Of Engineering',190,'Chennai');");


        if(cutoff1<=200&&cutoff1>=190) {

//            Cursor resultset = mydatabase.rawQuery("SELECT RANK,NAME,CITY FROM ANNAUNIV WHERE CUTOFFG<=" + cutoff1, null);
//            resultset.moveToFirst();
//            k = resultset.getInt(resultset.getColumnIndex("RANK"));
//
//            final ArrayList<College> eli = new ArrayList<College>();
//
//            while (k <= 7) {
//               // eli.add(new topHundred(resultset.getInt(resultset.getColumnIndex("RANK")), resultset.getString(resultset.getColumnIndex("NAME")), resultset.getString(resultset.getColumnIndex("CITY"))));
//                Log.v("Myactivity", resultset.getString(resultset.getColumnIndex("NAME")));
//                k++;
//                resultset.moveToNext();
            final ArrayList<College> eli = new ArrayList<College>();
            final topHundreduniversitiesAdapter Adapter = new topHundreduniversitiesAdapter(this, eli);

            final ListView listView = (ListView) findViewById(R.id.list);


            ref.child("Colleges").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                      College c = dataSnapshot.getValue(College.class);
                    double cutfb= c.getCutoff();
                        if(cutoff1>=cutfb&&cutfb!=0) {


                            Adapter.add(c);
                            listView.setAdapter(Adapter);
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
//            }

        }
        else {
            Toast.makeText(getApplicationContext(),
                    "Value Should be between 190 to 200", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(elgibilityAdapter.this,eligibilityActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            this.finish();



        }
        //mydatabase.close();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}