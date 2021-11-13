package com.patterns.twoPointers.easy.java;

//        Problem Statement:
//        Given an array of sorted numbers and a target sum, find a pair in the array
//        whose sum is equal to the given target.
//        Write a function to return the indices of the two numbers such that
//        they add up to the given target.

//        Example 1:
//        Input: [1, 2, 3, 4, 6], target=6
//        Output: [1, 3]
//        Explanation: The numbers at index 1 and 3 add up to 6

//        Example 2:
//        Input: [2, 5, 9, 11], target=11
//        Output: [0, 2]
//        Explanation: The numbers at index 0 and 2 add up to 11

import java.util.Arrays;

public class PairWithTargetSum {

    public static void main(String[] args) {

        int[] test = {1, 2, 3, 4, 6};
        int[] test2 = {2, 5, 9, 11};

        System.out.println(Arrays.toString(pairWithTargetSum(test, 6)));
        System.out.println(Arrays.toString(pairWithTargetSum(test2, 11)));

    }

    private static int[] pairWithTargetSum(int[] arr, int targetSum) {

        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        int currentSum;

        while (leftPointer < rightPointer) {

            currentSum = arr[leftPointer] + arr[rightPointer];

            if (currentSum == targetSum) {
                return new int[]{leftPointer, rightPointer};
            }

            else if (currentSum > targetSum) {
                rightPointer -= 1;
            }

            else {
                leftPointer += 1;
            }

        }

        return new int[]{-1, -1};

    }

}
