package com.patterns.slidingWindow.easy.java;

/*

From Grokking the Coding Interview

Problem Statement:
Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose
sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.

Example 1:
Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].

Example 2:
Input: [2, 1, 5, 2, 8], S=7
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].

Example 3:
Input: [3, 4, 1, 1, 6], S=8
Output: 3
Explanation: Smallest sub-arrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].


SOLUTION BREAKDOWN:

- Idea is to expand the window continuously until the window sum hits or surpasses the target
- Once the target is hit, idea is to see how much we can shrink the window until we fall below the target
- We shrink the window by removing the left-most element in the window
- Repeat this until we have gone over the whole array, then we check whether what the size of the smallest window we
- could attain before falling below the target

*/

public class SmallestSubArrayWithGivenSum {

    public static void main(String[] args) {

        int[] test = {2, 1, 5, 2, 3, 2};
        int[] test2 = {2, 1, 5, 2, 8};
        int[] test3 = {3, 4, 1, 1, 6};
        int[] test4 = {3, 4, 1, 1, 6};

        System.out.println(smallestSubArrayWithGivenSum(test, 7));
        System.out.println(smallestSubArrayWithGivenSum(test2, 7));
        System.out.println(smallestSubArrayWithGivenSum(test3, 8));
        System.out.println(smallestSubArrayWithGivenSum(test4, 80));

    }

    private static int smallestSubArrayWithGivenSum(int[] nums, int s) {

        int windowSum = 0;
        int minSubArraySize = nums.length + 1;
        int windowStartIdx = 0;

        for (int windowEndIdx = 0; windowEndIdx < nums.length; windowEndIdx++) {

            windowSum += nums[windowEndIdx];

            while (windowSum >= s) {

                minSubArraySize = Math.min(minSubArraySize, windowEndIdx - windowStartIdx + 1);
                windowSum -= nums[windowStartIdx];
                windowStartIdx++;

            }

        }

        if (minSubArraySize == nums.length + 1) {
            return 0;
        }

        return minSubArraySize;

    }

}
