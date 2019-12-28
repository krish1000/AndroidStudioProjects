package com.example.krish.MCalcPro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import ca.roumani.i2c.MPro;

// CTRL + ALT + L FTW
public class EntryForm extends AppCompatActivity implements TextToSpeech.OnInitListener, SensorEventListener {

    // declaring variable
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.tts = new TextToSpeech(this, this); // added dis ting

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mortgage_layout);

        SensorManager yeetmanager = (SensorManager) getSystemService(SENSOR_SERVICE);
        yeetmanager.registerListener(this, yeetmanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onInit(int initStatus) {
        this.tts.setLanguage(Locale.US); //tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void onAccuracyChanged(Sensor arg0, int arg1) {
    }

    public void onSensorChanged(SensorEvent event) {
        double ax = event.values[0];
        double ay = event.values[1];
        double az = event.values[2];
        double a = Math.sqrt(ax * ax + ay * ay + az * az);

        String bigOOOF = "";

        if (a > 20) {//clear if more than 20
            ((EditText) findViewById(R.id.pBox)).setText("");
            ((EditText) findViewById(R.id.aBox)).setText("");
            ((EditText) findViewById(R.id.iBox)).setText("");
            ((TextView) findViewById(R.id.output)).setText("");

            tts.speak(bigOOOF, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public void buttonClicked(View v) {
        try {
            MPro mp = new MPro();
            // set
            mp.setPrinciple(((EditText) findViewById(R.id.pBox)).getText().toString());
            mp.setAmortization(((EditText) findViewById(R.id.aBox)).getText().toString());
            mp.setInterest(((EditText) findViewById(R.id.iBox)).getText().toString());

            /* TEST CODE YEEEEEEEEEEEEEET
            System.out.println(mp.computePayment("%,.2f"));
            System.out.println(mp.outstandingAfter(2,"%,16.0f"));
            */



            String s = "Monthly Payment = " + mp.computePayment("%.2f");

            s += "\n\n";        // escape sequence ting
            s += "By making this payments monthly for " + ((EditText) findViewById(R.id.aBox)).getText().toString();
            s += " years, the mortgage will be paid in full. But if you terminate the mortgage on its nth anniversary, the balance still owing depends on n as shown below: ";
            s += "\n\n";
            s += String.format("%8s", "n") + String.format("%16s", "Balance");
            s += "\n\n";
            s += String.format("%8d", 0) + mp.outstandingAfter(0, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 1) + mp.outstandingAfter(1, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 2) + mp.outstandingAfter(2, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 3) + mp.outstandingAfter(3, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 4) + mp.outstandingAfter(4, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 5) + mp.outstandingAfter(5, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 10) + mp.outstandingAfter(10, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 15) + mp.outstandingAfter(15, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 20) + mp.outstandingAfter(20, "%,16.0f");

            /*
            ((TextView) findViewById(R.id.output)).setText(s);

            tts.speak(s, TextToSpeech.QUEUE_FLUSH, null); // speech ting
            */

        } catch (Exception e) {
            //display e.getMessage()
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            label.show();
        }

    }
}
