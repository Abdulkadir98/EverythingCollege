package com.example.hp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.hp.main.ui.Form;
import com.example.hp.main.ui.Navigation;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;


public class Login extends AppCompatActivity {
    FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    final int RC_SIGN_IN = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()

                        .setIsSmartLockEnabled(true)
                        // .setIsSmartLockEnabled(!BuildConfig.DEBUG)
                        .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build()))

                        .build(),
                RC_SIGN_IN);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            // Successfully signed in
            if (resultCode == RESULT_OK) {
                startActivity(new Intent(getApplicationContext(), Form.class));
                finish();
                return;
            } else {
                // Sign in failed
                if (response == null) {
                    Snackbar.make(findViewById(android.R.id.content), "Sign in Cancelled", Snackbar.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), Form.class));
                    finish();
                    return;
                }

                if (response.getErrorCode() == ErrorCodes.NO_NETWORK) {
                    Snackbar snackbar = Snackbar
                            .make(findViewById(android.R.id.content), "No internet connection", Snackbar.LENGTH_INDEFINITE)
                            .setAction("RETRY", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(getApplicationContext(), Form.class));
                                    finish();
                                }
                            });

                    snackbar.show();
                    return;
                }

                if (response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                    Snackbar.make(findViewById(android.R.id.content), "Unknown error", Snackbar.LENGTH_SHORT).show();
                    return;
                }
            }


            Snackbar.make(findViewById(android.R.id.content), "Unknown error", Snackbar.LENGTH_SHORT).show();
        }

        Toast.makeText(getApplicationContext(), "Unknown error",
                Toast.LENGTH_LONG).show();

    }
}












