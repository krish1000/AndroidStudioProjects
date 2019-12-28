package com.example.krish.leetcode;

import java.util.ArrayList;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

// WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS // WORKS SHORTEN IT PLSsssssssssssss
public class LeetcodeEx3 {

    private static int romanToInt(String s) {
        //declaring dem variables & main letters
        int I = 1;
        int V = 5;
        int X = 10;
        int L = 50;
        int C = 100;
        int D = 500;
        int M = 1000;
        int total = 0;
        char x = '0';

        int length1 = s.length();
        //String array1[] = {};
       // ArrayList<Character> array1 = new ArrayList<Character>();
        for (int i = 0; i < length1; i++) {
            x = s.charAt(i);
            //array1.add(x);
            //if last value is I, then +1, if last value is anything else, then + that value - intial
            //  System.out.println(array1.get(array1.size()-1));

            if (i + 1 < length1) {
                if (x == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                    total--;
                } else if (x == 'X' && ( s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C' )) {
                    total -= X;
                } else if (x == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    total -= C;
                } else {
                    total += convert1(x);
                }
            }
        }
        //int num1 = 0 + x;
        total += convert1(x);
        //System.out.println("char" + x);

        //System.out.println(array1);
        //System.out.println(array1.get(array1.size()-1));
        return total;
    }

    private static int convert1(char x)
    {
        int I = 1;
        int V = 5;
        int X = 10;
        int L = 50;
        int C = 100;
        int D = 500;
        int M = 1000;

        int total = 0;
        if(x == 'X')
        {
            total += X;
        } else if(x == 'I')
        {
            total += I;
        } else if(x == 'V')
        {
            total += V;
        } else if(x == 'L')
        {
            total += L;
        } else if(x == 'C')
        {
            total += C;
        } else if(x == 'D')
        {
            total += D;
        } else if(x == 'M')
        {
            total += M;
        }
        return total;
    }


    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

}

/*
  if (array1.get(array1.size() - 1) == 'I') {
                total += I;
            }
            else if(array1.get(array1.size() - 1) == 'V'){
                total += V;
            }
            else if(array1.get(array1.size() - 1) == 'X'){
                total += X;
            }
            else if(array1.get(array1.size() - 1) == 'L'){
                total += L;
            }
            else if(array1.get(array1.size() - 1) == 'C'){
                total += C;
            }
            else if(array1.get(array1.size() - 1) == 'D'){
                total += D;
            }
            else if(array1.get(array1.size() - 1) == 'M'){
                total += M;
                }
 */