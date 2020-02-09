package com.example.tdeev3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class AccountActivity extends AppCompatActivity {

    private Button logOutButton;

    //get instance of firebase
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        progressDialog = new ProgressDialog(this);

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
    }

    //DURING READING WEEK, TRY SEETING UP A MENU ON THE TOP RIGHT CORNER, FOR LOGOUT, makes it look sleek
    public void calculate1 (View v){
    //public void calculate1(){

        //**************NOTE TO SELF LOOK OVER READING WEEK*****************************//
        //for some reason not working in this activity, but was working on mainactivity
        progressDialog.setMessage("Calculating..."); //puts a cool dialog, kinda like a toast
        progressDialog.show();

        EditText heightView = (EditText) findViewById(R.id.height1);
        String height = heightView.getText().toString();
        EditText weightView = (EditText) findViewById(R.id.weight1);
        String weight = weightView.getText().toString();
        EditText ageView = (EditText) findViewById(R.id.age1);
        String age = ageView.getText().toString();


        //check if any of the fields are empty
        if(TextUtils.isEmpty(height) || TextUtils.isEmpty(weight) || TextUtils.isEmpty(age)){
            Toast.makeText(AccountActivity.this, "Field(s) are empty!", Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        } else {

            RadioGroup radio_group = (RadioGroup) findViewById(R.id.gender);
            //get selected radio button(male or female) from the radiogroup(gender)
            int selectedID = radio_group.getCheckedRadioButtonId();

            //finds the radiobutton that was clicked (by the id)
            //RadioButton radio_button = (RadioButton) findViewById(selectedID);

            Boolean gender_boolean = false; //false means female
            if (selectedID == R.id.male1) {
                gender_boolean = true;
            }
            MainCalculation calc = new MainCalculation(weight, height, age, gender_boolean);

            //gets BMI and BMR and puts it as a String
            String bMI1 = calc.getBMI(); //calculates bmi from MainCalculation
            String bMR1 = calc.getBMR(); //calculates bmr

            ((TextView) findViewById(R.id.output1)).setText("BMI: " + bMI1 + "\nBMR: " + bMR1);
            progressDialog.dismiss(); //dismisses dialog
        }
    }
}
