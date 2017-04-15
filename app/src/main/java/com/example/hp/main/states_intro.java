package com.example.hp.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hp.main.ui.stateActivity;

public class states_intro extends AppCompatActivity {

        String value,value1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states_intro);
        Button b= (Button) findViewById(R.id.tamil_nadu);
        Button b1=(Button) findViewById(R.id.new_delhi);
        value=b.getText().toString();
        value1=b1.getText().toString();
        if(b!=null) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), stateActivity.class);
                    intent.putExtra("title", value);
                    startActivity(intent);
                }
            });
        }
        if(b1!=null) {
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), stateActivity.class);
                    intent.putExtra("title", value1);
                    startActivity(intent);
                }
            });
        }

    }
}
