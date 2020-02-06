package com.example.tdeev3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class RegisterActivity extends AppCompatActivity {

    //initializing attributes
    private EditText emailField;
    private EditText passwordField;

    private Button signUpButton;
    private TextView signInTV;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance(); //puts instance inside of firebaseAuth

        //declaring email, pass, signup button & fields.
        emailField = findViewById(R.id.tvEmail);
        passwordField = findViewById(R.id.tvPassword);
        signUpButton = findViewById(R.id.btnSignUp);
        signInTV = findViewById(R.id.tvLogin);
        //NOTE TO SELF: CRASHED activity_registerxml b/c i accidently had R.id.tvSignUp instead,
        //gave a bunch of weird errors including null pointer exception, i guess cuz it was technically = to null
        //********************************************************************** Remember this

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignUp();
            }
        }); //signs up button, starts up signup method
        signInTV.setOnClickListener(new View.OnClickListener() { // goes back to mainactivity
            @Override
            public void onClick(View v) {
                //finish();

                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });

    }

    private void startSignUp() {
        //placing the text fields into string variables
        String email = emailField.getText().toString().trim();   // dont forget .getText().toString()
        String passW = passwordField.getText().toString().trim(); //trim white spaces

        //if email or pass is empty, then let the user know to fill in
        if ((TextUtils.isEmpty(email) || TextUtils.isEmpty(passW))) {
            Toast.makeText(RegisterActivity.this, "Field(s) are empty!", Toast.LENGTH_LONG).show();
        } else {
            //if email exists, tell user to use another email
            firebaseAuth.createUserWithEmailAndPassword(email, passW).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) { //if it was successful, let the user know using toast
                        Toast.makeText(RegisterActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    } else { //let the user know some error happened
                        Toast.makeText(RegisterActivity.this, "Registration Failed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}
