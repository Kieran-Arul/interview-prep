package com.patterns.hashmap.easy.java;

// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
// such that nums[i] == nums[j] and abs(i - j) <= k.

// Input: nums = [1,2,3,1], k = 3
// Output: true

// Input: nums = [1,0,1,1], k = 1
// Output: true

// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false

import java.util.HashMap;

public class ContainsDuplicatePart2 {

    public static void main(String[] args) {

        int[] test = {1,2,3,1};
        int[] test2 = {1,0,1,1};
        int[] test3 = {1,2,3,1,2,3};

        System.out.println(containsDuplicate(test, 3));
        System.out.println(containsDuplicate(test2, 1));
        System.out.println(containsDuplicate(test3, 2));

    }

    private static boolean containsDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if ((map.containsKey(nums[i])) && (Math.abs(map.get(nums[i]) - i) <= k)) {

                return true;

            }

            map.put(nums[i], i);

        }

        return false;

    }

}
