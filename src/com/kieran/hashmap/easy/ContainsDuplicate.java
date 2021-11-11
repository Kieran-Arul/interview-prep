package com.kieran.hashmap.easy;

// Given an integer array nums, return true if any value appears at least twice in the array,
// and return false if every element is distinct.

// Input: nums = [1,2,3,1]
// Output: true

// Input: nums = [1,2,3,4]
// Output: false

import java.util.HashMap;

public class ContainsDuplicate {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate(nums2));

    }

    private static boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {

            if (map.containsKey(num)) {
                return true;
            }

            map.put(num, 0);

        }

        return false;

    }

}
