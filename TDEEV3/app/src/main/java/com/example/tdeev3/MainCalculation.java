package com.example.tdeev3;

public class MainCalculation {
    /*
    Mifflin st Jeor Formula:
    men: 10xweight(kg) + 6.25 x height(cm) - 5 x age(years) +5
    women: 10xweight(kg) + 6.25 x height(cm) - 5 x age(years) -161
     */
    //private int gender;
    private double weight;
    private double height;
    private double age;
    private boolean gender;

    //public MainCalculation(String g, String w, String h, String a){
    //ignoring gender for now
    public MainCalculation(String w, String h, String a, boolean gender){
        //this.gender = Integer.parseInt();
        this.weight = Double.parseDouble(w); //kg
        this.height = Double.parseDouble(h); //m
        this.age = Double.parseDouble(a);    //years
        this.gender = gender;                    //if true then male
    }
    //calculates basal metabolic rate (in kilocalories)
    public String getBMR(){
        //then use if statment for gender to switch between equations
        double basic_formula = ((10.0 * this.weight) + (6.25 * this.height*100) - (5.0 * this.age));

        if(this.gender) { //if user is a male then add +5 to the formula
            basic_formula += 5;
        } else {         //if user is a female then subtract -161 to the formula
            basic_formula -= 161;
        }
        return String.format("%.0f", basic_formula);    //rounds it to 0 decimal value & returns BMR in kilocalories as a string

    }

    public String getBMI(){
        double index = this.weight / (this.height * this.height);
        return String.format("%.1f", index);

    }

    //testing in console
    public static void main(String[] args) {
        MainCalculation myModel = new MainCalculation("60", "1.50", "25", true); // true means male
        System.out.println(myModel.getBMR());
        System.out.println(myModel.getBMI());
    }
}
