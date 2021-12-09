package com.patterns.slidingwindow.medium.java;

// LeetCode Q904
// You are visiting a farm that has a single row of fruit trees arranged from left to right.
// The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
// You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

// 1. You only have two baskets, and each basket can only hold a single type of fruit.
// There is no limit on the amount of fruit each basket can hold.

// 2. Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
// while moving to the right. The picked fruits must fit in one of your baskets.

// 3. Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
// Given the integer array fruits, return the maximum number of fruits you can pick.

// Example 1:
// Input: fruits = [1,2,1]
// Output: 3
// Explanation: We can pick from all 3 trees.

// Example 2:
// Input: fruits = [0,1,2,2]
// Output: 3
// Explanation: We can pick from trees [1,2,2]. If we had started at the first tree, we would only pick from trees [0,1].

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FruitsIntoBaskets {

    public static void main(String[] args) {

        int[] test = {1, 2, 1};
        int[] test2 = {0, 1, 2, 2};
        int[] test3 = {0, 1, 6, 6, 4, 4, 6};

        System.out.println(totalFruit(test));
        System.out.println(totalFruit(test2));
        System.out.println(totalFruit(test3));

    }

    private static int totalFruit(int[] fruits) {

        List<Integer> collectionList = new ArrayList<>();
        HashMap<Integer, Integer> basket = new HashMap<>();

        int windowStart = 0;
        int windowEnd = 0;
        int fruitCollected = 0;
        
        while (windowEnd < fruits.length) {
            
            if (basket.size() < 2 || basket.containsKey(fruits[windowEnd])) {

                basket.put(fruits[windowEnd], 0);
                fruitCollected++;
                windowEnd++;

            } else {

                collectionList.add(fruitCollected);
                fruitCollected = 0;
                basket.clear();
                windowStart++;
                windowEnd = windowStart;

            }
            
        }

        collectionList.add(fruitCollected);

        return Collections.max(collectionList);

    }

}
