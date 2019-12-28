package com.example.krish.leetcode;

/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class LeetcodeEx2 {

    /*
    public static boolean isPalindrome(int x) {
        String convert1 = Integer.toString(x);
        int length1 = convert1.length();
        boolean x = false;

        // checks first, then checks if copy,
        // if not then goes to next number, if not etc. till length of number.
        Map<Integer, String> map1 = new TreeMap<Integer, String>();

        for(int i = 0; i<length1; i++)
        {
            map1.put(i, ""+convert1.charAt(i)); //how 2 cast char to string zzzzzzzzz
        }

        for(int k = 0; k<length1-1; k++)
        {
            String letter1 = map1.get(k);
            for(int j = 0; j<length1; j++)
            {
                if(letter1 == ""+convert1.charAt(j) && k != j)
                {
                    x = true;
                } else
                {
                    x = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        int x = 121;

    }
    */
}
