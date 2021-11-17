package com.patterns.twoPointers.medium.java;

import java.util.*;

// ThreeSum -> LeetCode Q15
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
// i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

/*

SOLUTION BREAKDOWN:

- Fundamentally, we are trying to look for triplets that sum up to 0

- We sort the array so that when we iterate over the input array, we can be sure that for our current element, its
fellow 2 elements that make up the triplet will be to its right

- The logic behind doing this is ensuring that our duplicate arrays will always be in the same order, allowing our set to filter them out

- We then initialise two pointers.

- The first element will be the current element in our for loop.

- The first pointer points at the element to the right of the current element

- The second pointer points at the last element in the array

- We then compare this triplet to see if it sums up to 0

- If the sum > 0, we know we need to decrease the size of the triplet, thus we decrement the second pointer since
the array is sorted

- If the sum < 0, we know we need to increase the size of the triplet, thus we increment the first pointer since the
array is sorted

- When we find a triplet that adds up to 0, we add it to our result set and also increment/decrement our two pointers
to find other possible triplets based on our current element

*/

public class ThreeSum {

    public static void main(String[] args) {

        int[] test = {-1,0,1,2,-1,-4};
        int[] test2 = {3,0,-2,-1,1,2};
        System.out.println(threeSum(test));
        System.out.println(threeSum(test2));

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        // Ensures the limit of nums[i] is the third last element in the array since we are looking for triplets
        for (int i = 0; i < nums.length - 2; i++) {

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                } else if (sum > 0) {

                    k--;

                } else {

                    j++;

                }

            }

        }

        return new ArrayList<>(result);

    }

}
