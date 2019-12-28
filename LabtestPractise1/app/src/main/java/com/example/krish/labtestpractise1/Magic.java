package com.example.krish.labtestpractise1;

import ca.roumani.i2c.Stock;

import static ca.roumani.i2c.Utility.getBMI;
import static ca.roumani.i2c.Utility.m2FtInch;

public class Magic
{
/*
    public static void main(String[] args)
    {
        final String MSG = "York University Toronto";
        Stock stock = new Stock("HR.S");
        double price = stock.getPrice();
        int cent = (int) Math.rint(price);
        System.out.println(MSG.substring(cent, cent+2).toUpperCase());

    }
*/
    /*
    public static void main(String[] args) {

        int x = 2;
        int y = 4;
        //public static double geo(int x, int y)
        //{
            int sum = x + y;
            double answer = Math.sqrt(sum);
            //return answer;
            System.out.println(answer);
        //}
    }
    */

    public static String convert(double distance)
    {
        return m2FtInch(distance);
    }



    public static void main(String[] args) {
        double distance1 = 123.0;
        System.out.println(convert(distance1));
    }


}
