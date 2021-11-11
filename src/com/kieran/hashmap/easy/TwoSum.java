package com.kieran.hashmap.easy;

import java.util.Arrays;
import java.util.HashMap;

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Output: Because nums[0] + nums[1] == 9, we return [0, 1].

// Input: nums = [3, 3], target = 6
// Output: [0,1]

public class TwoSum {

    public static void main(String[] args) {

        int[] test = {3, 2, 4};
        int[] test2 = {2, 8, 6, 7, 12};

        System.out.println(Arrays.toString(twoSum(test, 6)));
        System.out.println(Arrays.toString(twoSum(test2, 9)));

    }

    private static int[] twoSum(int[] nums, int target){

        HashMap<Integer, Integer> elementToIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (elementToIndexMap.containsKey(complement)) {

                return new int[]{elementToIndexMap.get(complement), i};

            }

            elementToIndexMap.put(nums[i], i);

        }

        return null;

    }

}
