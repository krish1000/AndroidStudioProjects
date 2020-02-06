package com.example.tdeev3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class AccountActivity extends AppCompatActivity {

    private Button logOutButton;

    //get instance of firebase
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //NOTE TO SELF, try out progressbar, it looks cool ;)
        firebaseAuth = FirebaseAuth.getInstance(); //get instance of the current account

        logOutButton = findViewById(R.id.logOutB);

        //once clicked the user gets signed out, and put back into mainactivity(signin page)
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut(); //signs out the user
                finish(); //closes activity i believe
                startActivity(new Intent(AccountActivity.this, MainActivity.class)); //sends back to main
            }
        });

        //DURING READING WEEK, TRY SEETING UP A MENU ON THE TOP RIGHT CORNER, FOR LOGOUT, makes it look sleek

    }
}
