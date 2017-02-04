package com.example.hp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import static android.R.attr.start;
import static com.example.hp.main.R.drawable.state;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView topHundredImage = (ImageView)findViewById(R.id.top_hundred);
        ImageView searchImage = (ImageView)findViewById(R.id.search);
        ImageView examsImage = (ImageView)findViewById(R.id.entrance_exams);
        ImageView eligibilityImage = (ImageView)findViewById(R.id.eligibilty);
        ImageView scholarshipImage = (ImageView)findViewById(R.id.scholarship_exams);
        ImageView stateImage= (ImageView) findViewById(R.id.state_colleges); //new image view for state

        if(topHundredImage!=null){

            topHundredImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,topHundredActivity.class);
                    startActivity(intent);
                }
            });

        }
        if(stateImage!=null) //new listner for the same
        {
            stateImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(MainActivity.this,states_intro.class);
                    startActivity(intent);

                }




        });
        }

        if (searchImage!=null){
           searchImage.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent = new Intent(MainActivity.this, searchActivity.class);
                   startActivity(intent);
               }
           });
        }
        if (examsImage!=null){
            examsImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,examsActivity.class);
                    startActivity(intent);
                }
            });
        }
        if(eligibilityImage!=null){
            eligibilityImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,eligibilityActivity.class);
                    startActivity(intent);
                }
            });
        }
        if(scholarshipImage!=null){
            scholarshipImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,scholarshipActivity.class);
                    startActivity(intent);
                }
            });
        }


    }




}
