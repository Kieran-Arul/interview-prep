package com.patterns.slidingWindow.easy.java;

// From Grokking the Coding Interview

// Problem Statement:
// Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray size ‘k’.

// Example 1:
// Input: [2, 1, 5, 1, 3, 2], k=3
//  Output: 9
// Explanation: Subarray with maximum sum is [5, 1, 3].

// Example 2:
// Input: [2, 3, 4, 1, 5], k=2
// Output: 7
// Explanation: Subarray with maximum sum is [3, 4].

/*

SOLUTION BREAKDOWN:

- Fundamental idea here is that we want to form a "window" of size k
- Then we want to get the sum of the numbers in that window and compare it to the current max sum
- Then we want to slide the window down by 1 place and get the window sum there and compare it to the current max sum
- We want to keep sliding the window down by one until we reach the end of the array

- We initialise the window_sum, max_sum and window_start to 0
- window_sum will contain the sum of elements in the current window
- max_sum will contain the maximum window sum at any point in time
- We need a reference to the start of the window so when the window slides forward, we know which to element to remove
from the window sum

- We then constantly add new elements to the window
- Once the window has reached size k, we then compare the max sum to the current window sum
- We then slide the window forward by one, which has the effect of removing the left-most element in the window
and making the new window start be the new left-most element

*/

public class MaximumSumSubarray {

    public static void main(String[] args) {

        int[] test = {2, 1, 5, 1, 3, 2};
        int[] test2 = {2, 3, 4, 1, 5};
        System.out.println(maxSubarrayOfSizeK(test, 3));
        System.out.println(maxSubarrayOfSizeK(test2, 2));

    }

    private static int maxSubarrayOfSizeK(int[] nums, int k) {

        int windowSum = 0;
        int maxSum = 0;
        int windowStartIdx = 0;

        for (int windowEndIdx = 0; windowEndIdx < nums.length; windowEndIdx++) {

            windowSum += nums[windowEndIdx];

            if (windowEndIdx >= k - 1) {

                maxSum = Math.max(windowSum, maxSum);
                windowSum -= nums[windowStartIdx];
                windowStartIdx++;

            }

        }

        return maxSum;

    }

}
