package com.patterns.dynamicprogramming.easy.java;

// LeetCode Q53
// Given an integer array nums, find the contiguous subarray (containing at least one number)
// which has the largest sum and return its sum.
// A subarray is a contiguous part of an array.
//
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

public class MaxSubArray {

    public static void main(String[] args) {

        int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(test));

    }

    private static int maxSubArray(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            arr[i] = Math.max(arr[i], arr[i] + arr[i - 1]);

        }

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }

        }

        return max;

    }

}
