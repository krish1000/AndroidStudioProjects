package com.example.krish.MCalcPro;

import static ca.roumani.i2c.Utility.m2FtInch;

public class ExampleCode {

    public static String convert(double distance)
    {
        return m2FtInch(distance);
    }

    public static void main(String[] args)
    {
        double x = 123.23; //random number
        System.out.println(convert(x)); //outputs the number into feet and inch
    }

}
