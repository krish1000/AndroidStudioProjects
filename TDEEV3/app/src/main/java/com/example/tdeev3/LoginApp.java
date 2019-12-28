package com.example.tdeev3;

import android.app.Application;

//added
//import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class LoginApp extends Application {

    private FirebaseAuth mAuth;


    @Override
    public void onCreate(){
        super.onCreate();

        mAuth = FirebaseAuth.getInstance();
        //FirebaseAuth.set
    }

}
