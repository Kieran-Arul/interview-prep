package com.patterns.dynamicprogramming.medium.java;

// LeetCode Q1143
// Given two strings text1 and text2, return the length of their longest common subsequence.
// If there is no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters
// (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

// Example 1:
// Input: text1 = "abcde", text2 = "ace"
// Output: 3
// Explanation: The longest common subsequence is "ace" and its length is 3.

// Example 2:
// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc" and its length is 3.

// Example 3:
// Input: text1 = "abc", text2 = "def"
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.

import java.util.HashMap;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        System.out.println(lcsDriver("abcde", "ace"));
        System.out.println(lcsDriver("abc", "abc"));
        System.out.println(lcsDriver("abc", "def"));
        System.out.println(lcsDriver("dhskierandsiad", "vbjklilelrlalnl"));

    }

    private static int lcsDriver(String s1, String s2) {

        HashMap<LcsCacheKey, Integer> cache = new HashMap<>();

        return lcs(s1, s2, cache);

    }

    private static int lcs(String s1, String s2, HashMap<LcsCacheKey, Integer> cache) {

        LcsCacheKey key = new LcsCacheKey(s1.length(), s2.length());

        if (key.getS1Length() == 0 || key.getS2Length() == 0) {
            return 0;
        }

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {

            cache.put(
                    key,
                    1 + lcs(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1), cache)
            );

            return cache.get(key);
        }

        LcsCacheKey key1 = new LcsCacheKey(s1.length() - 1, s2.length());
        LcsCacheKey key2 = new LcsCacheKey(s1.length(), s2.length() - 1);

        cache.put(
                key1,
                lcs(s1.substring(0, s1.length() - 1), s2, cache)
        );

        cache.put(
                key2,
                lcs(s1, s2.substring(0, s2.length() - 1), cache)
        );

        return Math.max(cache.get(key1), cache.get(key2));

    }

}
