package com.example.krish.kryptonote;

import java.util.regex.*;
import java.util.*;

public class PractiseTest2 {


     // ANSWER IS "Z"
    public static int calc(String m)
    {
        final String KIT = "ABCDKLMXYZ"; // 10
        final String KAT = "2581470369";
        int result = KIT.length();  // equals 10
        //System.out.println(result);
        int n = KIT.indexOf(m.substring(0,1)); // start of number
        //System.out.println(m.substring(0,1));
        System.out.println(KIT.indexOf(m.substring(0,1)));
        if(n >= 0)
        {
            result = result + Integer.parseInt(KAT.substring(n,n+1));

        }
        return result;
    }
// returns 19


    // counts vowels of a string
    public static int vowel(String s)
    {
        final String VOWELS = "AEIOUaeiou";
        int length1 = s.length();
        int totalvowels = 0;

        //int n = VOWELS.indexOf(s.substring(0, 1));

        for (int i = 0; i < length1; i++)
        {
            //int n = VOWELS.indexOf(s.substring(i, i+1));
            int n = VOWELS.indexOf(s.charAt(i));
            if( n >= 0) {
                totalvowels++;
                //System.out.println("total vowels so far: " + totalvowels);
            } else {
                //n = VOWELS.indexOf(s.substring(i, i+1));
            }
           // System.out.println(n);
        }
        return totalvowels;
    }

          /*
        String x = String.valueOf(a);
        String y = String.valueOf(b);
        System.out.println(x);
        int length1 = x.length();
        */

    //for (int i = a; i < b; i++)
        /*
        {
            System.out.println(x.substring(i, i++));

        }
*/

    public static int sumDiv11(int a, int b)
    {

        int finalresult = -1;
        for (int i= a; i < b; i++)
        {
            String a1 = "" + a;
            int slength = a1.length();

            for (int j = 0; j< slength; j++)
            {
                char digit = a1.charAt(j);
                System.out.println(digit);
            }

            /*
            int sum = 0;
            int given = i;

            while(given > 0)
            {
                //int given = i;
                int n = given % 10;
                sum =+ n;
                given = given/10;
                //System.out.println(given);
            }
            while(sum % 11 == 0 && sum > 1){
                sum = sum/3;
                if (sum == 1){
                    finalresult = i;
                    return finalresult;
                }
            }
            */
        }
       return finalresult;
    }

    /*
    public static String[] splits(String x)
    {
        return x.split("\\s");
    }
*/

    public static double converts(String x)
    {
        String firstregex = "([+-]?[0-9]+)[c[C]]\\s+[t][o]\\s+[f[F]]";
        Pattern pattern = Pattern.compile(firstregex);
        Matcher matcher = pattern.matcher(x);

        double result = 0.0;
        //final double MULTI = double(9/5);
        //System.out.println(9/5);
        final double ADDTHING = 32;

        if (matcher.find())
        {
            int n1 = Integer.parseInt(matcher.group(1));

            double step1 = n1*9;
            double step2 = step1/5;
            double ans = step2 + ADDTHING;
            result = ans;
        } else
        {
            //throw new RuntimeException("Invalid content in string!");
        }
        return result;
    }



    public static void main(String[] args) {
       // System.out.println(converts("What is 32c to F"));


        //System.out.println(calc("Z"));
        //System.out.println(vowel("carhello"));
        //System.out.println(sumDiv11(1,1000));

        System.out.println(sumDiv11(1,5));

        /*
        String main = "this is a test in eecs1022";
        String[] elements = main.split("\\s");
        System.out.println(elements.length);
*/

        /*
        String strMain ="This is a test in EECS1022";
        String[] elements = strMain.split("\\s");
        //System.out.println(strMain.split("\\s"));
        for (int i=0; i < elements.length; i++){
            System.out.println(elements[i]);
        }
        */
    }




}
