package com.example.krish.caps;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class CapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caps_layout);

        // SHOULD ASK QUESTION ONCREATE

        this.game = new Game();
        ask();
    }


    private Game game;
    private String question;
    private String canswer = "";
    private int score = 0;
    private int qNum = 1;

    // keeps old log info from prev questions

    private String logOutput = ""; // old log outputs
    private String logQuestion = ""; // old question
    private String logWritenAnswer = "";


    private void ask() {

        if (qNum > 9)
        {
            Game myModel = new Game();
            String question1 = myModel.qa();
            // implement using GAME.java
            // regex String[]

            ((TextView) findViewById(R.id.qNum)).setText("GAME OVER!");
            ((TextView) findViewById(R.id.question)).setText("");
            //((TextView) findViewById(R.id.score)).setText("asdfadsfasf");

            Button btn = (Button) findViewById(R.id.done);
            btn.setEnabled(false); // to turn it off completly

            this.logOutput = "Q# " + (qNum - 1) + ": " + logQuestion + "\n" + "Your answer: " + logWritenAnswer + "\n" + canswer + "\n" + "\n" + logOutput;
            ((TextView) findViewById(R.id.log)).setText(logOutput);

        } else //questions before 9
        {
            String answerView = ((EditText) findViewById(R.id.answer)).getText().toString();
            this.logWritenAnswer = (answerView.toUpperCase());

            if (qNum > 1)
            {
                //this.logOutput = "Q# " + (qNum - 1) + ": " + logQuestion + "\n" + "Your answer: " + logWritenAnswer +
                if ((this.logWritenAnswer.toUpperCase()).equals(this.canswer.toUpperCase()))
                {
                    score++;

                    // clears text
                    ((EditText) findViewById(R.id.answer)).setText("");
                } else {
                    // clears text
                    ((EditText) findViewById(R.id.answer)).setText("");
                }
            }

            //outputs to scrollwheel
            if (qNum > 1)
            {
                this.logOutput = "Q# " + (qNum - 1) + ": " + logQuestion + "\n" + "Your answer: " + logWritenAnswer + "\n" + "Correct answer: " + canswer + "\n" + "\n" + logOutput;
            }

            //Initialize game from qa stuff
            Game myModel = new Game();
            String newQuestion = myModel.qa(); // ref from  qa

            //splits
            String[] newParts = newQuestion.split("'");
            String countryRef = newParts[1];
            String capitalRef = newParts[3];


        if (Math.random() < 0.5) {
            ((TextView) findViewById(R.id.question)).setText(capitalRef + " is the capital of?");
            this.logQuestion = capitalRef + " is the capital of";
            this.canswer = countryRef;

        } else {
            ((TextView) findViewById(R.id.question)).setText("What is the capital of " + countryRef + " ?");
            this.logQuestion = "What is the capital of " + countryRef + " ?";
            this.canswer = capitalRef;

        }
            //sets Qnumber and Score
            ((TextView) findViewById(R.id.qNum)).setText("Question # " + qNum);
            ((TextView) findViewById(R.id.score)).setText("Score: " + score);

        }
        qNum++;
    }


    public void onDone(View v)
    {
        //String decryptView = ((EditText) findViewById(R.id.key)).getText().toString();
        //String answerView = ((EditText) findViewById(R.id.answer)).getText().toString();
        ask();

    }


    public static void main(String[] args) {

        CountryDB db = new CountryDB();
        List<String> capitals = db.getCapitals();
        System.out.println(capitals.size());
        String c = capitals.get(107);
        System.out.println(c);

        Map<String, Country> data = db.getData();
        System.out.println(data.size());
        Country ref = data.get(c);
        System.out.println(ref.toString());

    }




}
