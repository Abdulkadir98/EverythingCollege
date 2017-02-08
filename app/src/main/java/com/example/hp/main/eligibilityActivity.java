package com.example.hp.main;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.edit;
import static android.os.Build.VERSION_CODES.N;

public class eligibilityActivity extends AppCompatActivity {
int cutoff;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility);
        Button b= (Button) findViewById(R.id.button);
        ed=(EditText) findViewById(R.id.editText);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cutoff=Integer.parseInt(ed.getText().toString());
                Intent intent= new Intent(getApplicationContext(),elgibilityAdapter.class);
                intent.putExtra("Number",cutoff);
                startActivity(intent);

            }
        });

    }
}
