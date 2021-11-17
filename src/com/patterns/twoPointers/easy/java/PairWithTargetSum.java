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

/*

SOLUTION BREAKDOWN:

- Fundamentally we want to go through the sorted array and pair off numbers, checking if their sum == target sum

- We initialise two pointers, one at the start of the array, the other at the end

- We have a while condition to ensure the pointers do not cross because then we would be repeating pairs

- Then with every pair, we check if they meet the target sum

- If the target is met, we return the two pairs

- If we are under the target sum, then we know we need to increase the current sum, thus we increment the left pointer
because we know the array is sorted and doing so will give us an equal/greater number

- If we are over the target sum, then we know we need to decrease the current sum, thus we decrement the left pointer
because we know the array is sorted and doing so will give us an equal/smaller number

*/

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
