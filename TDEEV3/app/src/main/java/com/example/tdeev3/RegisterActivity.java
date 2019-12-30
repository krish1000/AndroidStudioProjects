package com.example.tdeev3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailField;
    private EditText passwordField;

    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //declaring email, pass, signup button & fields.
        emailField = findViewById(R.id.tvEmail);
        passwordField = findViewById(R.id.tvPassword);
        signUpButton = findViewById(R.id.btnSignUp);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignUp();
            }
        });

    }

    private void startSignUp() {
        String email = emailField.getText().toString();   // dont forget .getText().toString()
        String passW = passwordField.getText().toString();

        //if email or pass is empty, then let the user know to fill in
        if ((TextUtils.isEmpty(email) || TextUtils.isEmpty(passW))) {
            Toast.makeText(RegisterActivity.this, "Field(s) are empty!", Toast.LENGTH_LONG).show();
        } else {

        }
    }
}
