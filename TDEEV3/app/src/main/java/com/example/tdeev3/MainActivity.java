package com.example.tdeev3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    //added auth for firebase (bit confused on how to use it tho)
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    //for signin
    private EditText emailField;
    private EditText passwordField;

    //declaring signin and signup
    private Button signInButton;
    private TextView signUpText;

    //trying out dialog cuz it looks cool
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //above came with setup

        //declared Firebase Authenticator - for login api
        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);

        //declaring email, pass, signin button & fields.
        emailField = findViewById(R.id.tvEmail);
        passwordField = findViewById(R.id.tvPassword);
        signInButton = findViewById(R.id.btnSignIn);
        signUpText = findViewById(R.id.tvSignUp);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignin();
            }
        });

        //sending user from mainactivity to register activity (once clicked)
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                //sending user from mainactivity to register activity
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() != null){
                    startActivity(new Intent(MainActivity.this, AccountActivity.class));
                }

            }
        };

    }

    /**
     * during startup mAuth adds listener to check if user is already signed in (in OnCreate())
     */
    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);
    }

    /**
     * Starts signing in process when the button is clicked via onclicklistener in onCreate()
     */
    private void startSignin() {
        String email = emailField.getText().toString();   // dont forget .getText().toString()
        String passW = passwordField.getText().toString();

        progressDialog.setMessage("Logging in...Please Wait! :D"); //puts a cool dialog, kinda like a toast
        progressDialog.show();
        //if email or pass is empty, then let the user know to fill in
        if ((TextUtils.isEmpty(email) || TextUtils.isEmpty(passW))) {
            Toast.makeText(MainActivity.this, "Field(s) are empty!", Toast.LENGTH_LONG).show();
            progressDialog.dismiss(); //makes it go away
        } else {
            mAuth.signInWithEmailAndPassword(email, passW).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        // Sign in was not successful
                        Toast.makeText(MainActivity.this, "Sign in Problem", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss(); //makes it go away
                    } else {
                        /*
                         * dont need this else statement tbh, but for future reference:
                         * if user was able to sign in, u can add other stuff here (during first signin)
                         * so maybe adding a tutorial of the app etc. could be nice
                         */
                        progressDialog.dismiss(); //makes it go away
                    }
                }
            });
        }
        //progressDialog.dismiss(); //makes it go away
    }
}

/* Was testing out firebase login api  ***/
//   mAuth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//        @Override
//        public void onComplete(@NonNull Task<AuthResult> task) {
//            if (task.isSuccessful()) {
//                // Sign in success, update UI with the signed-in user's information
//                Log.d(TAG, "signInWithEmail:success");
//                FirebaseUser user = mAuth.getCurrentUser();
//                updateUI(user);
//            } else {
//                // If sign in fails, display a message to the user.
//                Log.w(TAG, "signInWithEmail:failure", task.getException());
//                Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                        Toast.LENGTH_SHORT).show();
//                updateUI(null);
//            }
//
//            // ...
//        }
//    });
