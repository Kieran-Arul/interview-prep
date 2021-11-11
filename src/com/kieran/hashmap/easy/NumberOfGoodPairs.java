package com.kieran.hashmap.easy;

// Given an array of integers nums, return the number of good pairs.
//
//        A pair (i, j) is called good if nums[i] == nums[j] and i < j.
//
//        Input: nums = [1,2,3,1,1,3]
//        Output: 4
//        Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
//
//        Input: nums = [1,1,1,1]
//        Output: 6
//        Explanation: Each pair in the array are good.

import java.util.HashMap;

public class NumberOfGoodPairs {

    public static void main(String[] args) {

        int[] test = {1,2,3,1,1,3};
        int[] test2 = {1,1,1,1};
        int[] test3 = {6,5,1,5,7,7,9,1,5,7,1,6,10,9,7,4,1,8,7,1,1,8,6,4,7,4,10,5,
                        3,9,10,1,9,5,5,4,1,7,4,2,9,2,6,6,4,2,10,3,5,3,6,4,7,4,6,4,4,6,3,
                        4,10,1,10,6,10,4,9,6,6,4,8,6,9,5,4};

        System.out.println(numIdenticalPairs(test));
        System.out.println(numIdenticalPairs(test2));
        System.out.println(numIdenticalPairs(test3));

    }

    private static int numIdenticalPairs(int[] nums) {

        HashMap<Integer, Integer> numToFreqMap = new HashMap<>();

        int total = 0;

        for (int num : nums) {

            if (numToFreqMap.containsKey(num)) {

                numToFreqMap.put(num, numToFreqMap.get(num) + 1);

            } else {

                numToFreqMap.put(num, 1);

            }

        }


        for (int freq : numToFreqMap.values()) {

            total += combination(freq);

        }

        return total;

    }

    private static int factorial(int n) {

        if (n == 0 || n == 1) {

            return 1;

        }

        return (n * factorial(n - 1));

    }

    private static int combination(int n) {

        if (n < 2) {

            return 0;

        }

        return (n*(n-1))/(factorial(2));

    }

}
