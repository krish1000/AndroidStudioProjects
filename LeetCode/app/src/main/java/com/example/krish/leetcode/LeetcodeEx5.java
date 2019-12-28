package com.example.krish.leetcode;

public class LeetcodeEx5 {
    /*
    Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
     */
// WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS
    // learn recursive plssssssssssssssssssssssss
    public static int reverse(int x) {
        String sign = "";
        String new1 = String.valueOf(x);
        int reversal = 0;

        //learning appending
        StringBuilder asdf = new StringBuilder();
        if(x< Math.pow(2,31)-1 && x> Math.pow(-2,31)) {
            if (x < 0) {
                sign = "-";
                new1 = new1.substring(1);
            }

            for (int i = new1.length() - 1; i > -1; i--) {
                asdf.append(new1.charAt(i));
            }
            new1 = sign + asdf;
            // System.out.println("new1: " + new1);
            //incase reversal overflows
            try {
                reversal = Integer.parseInt(new1);
            }
            catch(Exception e){
                reversal =0;
            }
            // System.out.println(reversal);
        }
        return reversal;
    }

    public static void main(String[] args) {
        int x = 15342362;
        System.out.println(reverse(x));
    }
}
