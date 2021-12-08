package com.patterns.dynamicprogramming.easy.java;

// Leetcode Q70
// One can either take 1 step or two steps at a time
// How many ways can one climb the stairs?

// Input: n = 3
// Output: 3

// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

// Input: n = 4
// Output: 5

// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step + 1 step
// 2. 1 step + 1 step + 2 steps
// 3. 1 step + 2 steps + 1 step
// 4. 2 steps + 1 step + 1 step
// 5. 2 steps + 2 steps

/*

SOLUTION BREAKDOWN:

- Best way to think of this is like a binary tree
- The root node is n
- At every node, one can make two possible decisions - either you take one step or two steps
- So really, what we are trying to do is count how many leaves the resulting tree has
- One way we can do this is to count how many leaves the left subtree and right subtree has
- That can be done recursively

*/

import java.util.HashMap;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbingStairsDriver(3));
        System.out.println(climbingStairsDriver(4));
    }

    private static int climbingStairsDriver(int n) {

        HashMap<Integer, Integer> cache = new HashMap<>();

        return climbingStairs(n, cache);

    }

    private static int climbingStairs(int n, HashMap<Integer, Integer> cache) {

        if (n < 0) {
            return -1;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        cache.put(n, climbingStairs(n-1, cache) + climbingStairs(n-2, cache));

        return cache.get(n);

    }

}
