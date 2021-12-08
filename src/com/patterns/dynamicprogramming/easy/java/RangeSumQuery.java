package com.patterns.dynamicprogramming.easy.java;

// LeetCode Q303
// Given an integer array nums, handle multiple queries of the following type:
// Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

// Implement the RangeSumQuery class:
// RangeSumQuery(int[] nums) Initializes the object with the integer array nums.
// int sumRange(int left, int right)
// Returns the sum of the elements of nums between indices left and right inclusive
// (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

// Example 1:

// Input
// ["NumArray", "sumRange", "sumRange", "sumRange"]
// [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]

// Output
// [null, 1, -1, -3]

// Explanation
// NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
// numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
// numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
// numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

import java.util.HashMap;

public class RangeSumQuery {

    public static void main(String[] args) {

        int[] testArr = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery numArray = new RangeSumQuery(testArr);

        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));

    }

    private final int[] nums;
    private final HashMap<RangeSumKey, Integer> cache;

    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        this.cache = new HashMap<>();
    }

    private int sumRange(int start, int end) throws NumberFormatException {

        if (start > end || start < 0 || end >= nums.length) {
            throw new NumberFormatException("Start index must be <= end index");
        }

        if (start == end) {
            return nums[start];
        }

        RangeSumKey key = new RangeSumKey(start, end);

        if (this.cache.containsKey(key)) {
            return this.cache.get(key);
        }

        this.cache.put(
                key,
                this.sumRange(start, end - 1) + this.nums[end]
        );

        return this.cache.get(key);

    }

}
