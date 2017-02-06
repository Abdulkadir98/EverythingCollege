package com.example.hp.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class searchActivity extends AppCompatActivity {
    private EditText enterCollegeName;
    private String mcollgeName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Button EnterBt =(Button)findViewById(R.id.Enter);
        enterCollegeName = (EditText)findViewById(R.id.College);
        if(EnterBt!= null){
            EnterBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mcollgeName = enterCollegeName.getText().toString();

                    Intent intent = new Intent(searchActivity.this, SearchResult.class);

                    intent.putExtra("name", mcollgeName);
                    startActivity(intent);
                }
            });
        }

        //TODO INCLUDE PLACEHOLDER DATA.

    }
}
