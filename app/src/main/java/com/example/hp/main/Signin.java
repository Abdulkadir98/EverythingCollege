package com.example.hp.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import static android.R.id.button3;
import static com.facebook.FacebookSdk.getApplicationContext;

public class Signin extends AppCompatActivity implements View.OnClickListener {
private static final int RC_SIGN_IN=0;
    public FirebaseAuth auth;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
         auth= FirebaseAuth.getInstance();
        if(auth.getCurrentUser()!=null)
        {

            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        else {
            startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setProviders(
                            AuthUI.GOOGLE_PROVIDER,
                            AuthUI.EMAIL_PROVIDER)
                    .build(), RC_SIGN_IN);
            Intent intent= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
         findViewById(R.id.button3).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button3) {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                               @Override
                                               public void onComplete(@NonNull Task<Void> task) {
                                                   finish();
                                                   Intent intent= new Intent(getApplicationContext(),Signin.class);
                                                   startActivity(intent);

                                               }
                                           }
                    );


        }
    }
    }

