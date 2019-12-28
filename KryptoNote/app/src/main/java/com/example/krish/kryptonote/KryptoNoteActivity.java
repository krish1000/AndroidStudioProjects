package com.example.krish.kryptonote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class KryptoNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kryptonote_layout);
    }

    // declaring variables
    /*
    private String key;
    public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // final constant
    */

/*
    KryptoNoteActivity(String k)
    {
        this.key = k;

    }

*/

/*
    private String makePad(String note) {
        String pad = this.key;
        for (; pad.length() < note.length(); ) {
            pad += this.key;
        }
        return pad;
    }

    public String encrypt(String note) {
        String pad = makePad(note); // calls method makePad
        String result = ""; // intializes result
        for (int i = 0; i < note.length(); i++) // for loop
        {
            String c = note.substring(i, i + 1);
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i, i + 1));
            int newPosition = (position + shift) % ALPHABET.length();
            result = result + ALPHABET.substring(newPosition, newPosition + 1);
        }
        return result;
    }
    // decrypt would be the opposite

    public String decrypt(String note) {
        String pad = makePad(note); // calls method makePad
        String result = ""; // intializes result
        for (int i = 0; i < note.length(); i++) // for loop
        {
            String c = note.substring(i, i + 1); // changed
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i, i + 1)); // changed dis
            int newPosition = (position - shift) % ALPHABET.length();
            result = result + ALPHABET.substring(newPosition, newPosition + 1); // changed
        }
        return result;
    }
    */

    // intializing the 4 buttons in the UI
    public void onEncrypt(View v) {
        try {
        String keyView = ((EditText) findViewById(R.id.key)).getText().toString();
        //String encryptKey = keyView.getText().toString();

        String dataView = ((EditText) findViewById(R.id.data)).getText().toString();
        //String dataKey = dataView.getText().toString();

        Crypto c1 = new Crypto(keyView); // KryptoNoteActivity c1 = new KryptoNoteActivity(encryptKey);

        String encryptedKey = c1.encrypt(dataView);
       ((TextView) findViewById(R.id.data)).setText(encryptedKey);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }

    public void onDecrypt(View v) {
        try {
            String decryptView = ((EditText) findViewById(R.id.key)).getText().toString();
            //String decryptKey = decryptView.getText().toString();

            String dataView = ((EditText) findViewById(R.id.data)).getText().toString();
            //String dataKey = dataView.getText().toString();

            Crypto c2 = new Crypto(decryptView); // imported cipher

            String decryptedKey = c2.decrypt(dataView);
            ((TextView) findViewById(R.id.data)).setText(decryptedKey);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void onSave(View v) {
        try {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileWriter fw = new FileWriter(file);
            fw.write(((EditText) findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast.makeText(this,"Note Saved.", Toast.LENGTH_LONG).show(); // added show
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show(); // added show
        }

    }

    public void onLoad(View v) {
        // given a FIleReader instance named fr;:

        //FileReader  fr = new FileReader(); added dis
        try {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileReader fr = new FileReader(file); // used filereader instead of filewriter
            Toast.makeText(this, "Note Loaded", Toast.LENGTH_LONG).show();

            String show = "";
            for (int c = fr.read(); c != -1; c = fr.read()) {
                show += (char) c;
            }
            fr.close();
            ((EditText) findViewById(R.id.data)).setText(show);
        }
        catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public static void main(String[] args) {
        //Vig v =
    }

}