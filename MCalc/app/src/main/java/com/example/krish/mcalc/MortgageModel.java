package com.example.krish.mcalc;

public class MortgageModel {

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
}

