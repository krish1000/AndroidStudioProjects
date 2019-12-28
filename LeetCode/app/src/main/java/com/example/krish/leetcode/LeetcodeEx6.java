package com.example.krish.leetcode;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */

public class LeetcodeEx6 {
    public static String longestCommonPrefix(String[] strs) {
        //String x = "";
        //String x2 = "";

        StringBuffer finalString = new StringBuffer();

        if(strs.length>0) {
            int small = strs[0].length();
            String smallestword = strs[0];
            //check first letter of all, then 2nd of all then 3rd etc

            //find smallest word
            for (int i = 0; i < strs.length; i++) {
                if (small > strs[i].length()) {
                    small = strs[i].length();
                    smallestword = strs[i];
                }
            }
            //System.out.println(smallestword);
            //System.out.println("num " + small);
            for (int k = 0; k < small; k++) {
                char xchar = smallestword.charAt(k);

                for (int i = 0; i < strs.length; i++) {

                    if (xchar == strs[i].charAt(k)) {
                    } else {
                        return finalString + ""; // asdf improperrrrrrrrrrrrrrrrrr
                    }
                }
                finalString.append(xchar);
            }
        }
        ////////////////////////////////////
        /*
        for(int k = 0; k< strs.length-1; k++)
        {
            x = strs[0];

            char xchar = x.charAt(k);
            for(int i = 0; i< strs.length-1; i++)
            {

                x2 = strs[i];
                if(x == x2)
                {

                }
            }
            //if all 3 were eqal then add to string buffer.
        }
*/
        return finalString+""; // improperrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
    }

    public static void main(String[] args) {
        String[] asdf = {"aa","a"};

        System.out.println(longestCommonPrefix(asdf));
    }


}
