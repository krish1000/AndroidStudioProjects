package com.example.krish.MCalcPro;

import android.app.Activity;
import android.widget.TextView;

import ca.roumani.i2c.MPro;

public class MortgageModel {


    /****************
     * OLD STUFFFFFFFFFFFFFFFFFF
     * @param
     */
    /*
    private double principle;
    private double amortization;
    private double interest;


    public MortgageModel (String p, String a, String i)
    {
        this.principle = Double.parseDouble(p);
        this.amortization = Double.parseDouble(a);
        this.interest = Double.parseDouble(i);
    }

    public String computePayment ()
    {
        double r = (this.interest/100)/12;
        double n = this.amortization*12;

        double index = (r*this.principle)/(1-Math.pow(1+r,-n));
        String result = String.format("$%,.2f", index);
        return result;
    }

    public static void main(String[] args) {
        MortgageModel myModel = new MortgageModel("700000", "25", "2.75");
        System.out.println(myModel.computePayment());

        myModel = new MortgageModel("300000", "20", "4.5");
        System.out.println(myModel.computePayment());
    }
    */



    public static void main(String[] args) {

        MPro mp = new MPro();
        // test ting
        mp.setPrinciple("400000"); // inside put ((EditText) findViewById(R.id.pBox)).getText().toString()
        mp.setAmortization("20");
        mp.setInterest("5");

        System.out.println(mp.computePayment("%,.2f"));
        System.out.println(mp.outstandingAfter(2,"%,16.0f"));

        String s = "Monthly Payment =" + mp.computePayment("%.2f");
        s += "\n\n";        // escape sequence ting
        s += "By making this payments monthly for";

        s += String.format("%8d", 0) + mp.outstandingAfter(0, "%,16.0f");
        s += "\n\n";
        s += String.format("%8d", 1) + mp.outstandingAfter(1, "%,16.0f");

        //((TextView) findViewById(R.id.output)).setText(s);

        System.out.println(s);
    }


}
