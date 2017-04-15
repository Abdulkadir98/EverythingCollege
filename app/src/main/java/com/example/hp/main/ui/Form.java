package com.example.hp.main.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hp.main.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Form extends AppCompatActivity {

    @BindView(R.id.contact_form_title)
    TextView contactFormTitle;
    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.user_email)
    EditText userEmail;
    @BindView(R.id.user_phone_number)
    EditText userPhoneNumber;
    @BindView(R.id.user_button)
    Button userButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
    }
}
