package com.example.krish.caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {

    private CountryDB db;


    public Game()
    {
        this.db = new CountryDB();
    }

    /* Psuedocode for qa
    Get a reference to the database's capital city list
    Determin the size of this list. Call it n.
    Generate a random number in [0,n). Call it index
    Invoke get(index) on the list to get a random capital city. Call it c.
    Get a reference to the database's data map.
    Invoke get(c) on the map to get a reference to a country. Call it ref.
     */

    public String qa()
    {
        //Game reference = new Game();
        CountryDB db = new CountryDB();
        List<String> capitals = db.getCapitals();
        int n = capitals.size();

        int index = (int)(Math.random()*n);

        String c = capitals.get(index);

        Map<String, Country> data = db.getData();
        Country ref = data.get(c);

        /*
        if (Math.random() < 0.5) {

            String question1 = "What is the capital of" + ref + "\n" + c;
            String result = question1;
            return result;

            return ref;
        } else {

            String question2 = c + "is the capital of?" + "\n" + ref;
            String result = question2;

            return ref;
        }
        */

        return "" + ref;
    }




}
