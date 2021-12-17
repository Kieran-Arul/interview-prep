package com.patterns.arrays.easy.java;

// LeetCode Q448
// Given an array nums of n integers where nums[i] is in the range [1, n],
// return an array of all the integers in the range [1, n] that do not appear in nums.

// Example 1:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]

// Example 2:
// Input: nums = [1,1]
// Output: [2]

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindDisappearedNumbers {

    public static void main(String[] args) {

        int[] test = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] test2 = {1, 1};

        System.out.println(findDisappearedNumbers(test));
        System.out.println(findDisappearedNumbers(test2));
        System.out.println(findDisappearedNumbersModelSolution(test));
        System.out.println(findDisappearedNumbersModelSolution(test2));

    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {

        HashSet<Integer> disappearedNums = new HashSet<>();
        HashMap<Integer, Integer> cache = new HashMap<>();

        for (int num : nums) {
            cache.put(num, 0);
        }

        for (int eachNum = 1; eachNum <= nums.length; eachNum++) {

            if (!cache.containsKey(eachNum)) {
                disappearedNums.add(eachNum);
            }

        }

        return new ArrayList<>(disappearedNums);

    }

    private static List<Integer> findDisappearedNumbersModelSolution(int[] nums) {

        HashSet<Integer> disappearedNums = new HashSet<>();
        HashSet<Integer> cache = new HashSet<>();

        int start = 1;

        for (int num : nums) {

            disappearedNums.add(num);
            cache.add(start++);

        }

        // Asymmetric Difference (i.e. cache - disappearedNums)
        cache.removeAll(disappearedNums);

        return new ArrayList<>(cache);

    }

}
