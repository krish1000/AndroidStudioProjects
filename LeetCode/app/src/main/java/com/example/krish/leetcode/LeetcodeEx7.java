package com.example.krish.leetcode;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */


public class LeetcodeEx7 {
    public static int maxSubArray(int[] nums) {
        // intialize ze sum and max
        int sum = nums[0]; // puts the start sum as the first number in the array
        int max1 = sum; // maxsum is also equal to the first number in the array

        for(int i = 0; i < nums.length; i++)
        {
            /*
            int x = nums[i];
            for(int k = 0; k < nums.length -1; k++)
            {
                int x2 = nums[x + k];
            }
            */
            // ez way of doing it
            sum = Math.max(nums[i], (sum + nums[i])); // compares which is greater for temporary sum
            max1 = Math.max(sum, max1); // compares which is greater again between the max sum and the temporary sum
        }
        return max1; // returns greatest sum
    }

    public static void main(String[] args) {
        int[] asdf = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(asdf));
    }
}
