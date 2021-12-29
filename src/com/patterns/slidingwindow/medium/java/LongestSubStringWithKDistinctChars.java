package com.patterns.slidingwindow.medium.java;

// Question from Grokking the Coding Interview

// Problem Statement
// Given a string, find the length of the longest substring in it with no more than K distinct characters.

// Example 1:
// Input: String="araaci", K=2
// Output: 4
// Explanation: The longest substring with no more than '2' distinct characters is "araa".

// Example 2:
// Input: String="araaci", K=1
// Output: 2
// Explanation: The longest substring with no more than '1' distinct characters is "aa".

// Example 3:
// Input: String="cbbebi", K=3
// Output: 5
// Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

import java.util.HashMap;

public class LongestSubStringWithKDistinctChars {

    public static void main(String[] args) {

        System.out.println(answer("araaci", 2));
        System.out.println(answer("araaci", 1));
        System.out.println(answer("cbbebi", 3));
        System.out.println(answer("gjkkkkiiierran", 3));

    }

    private static int answer(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        int windowEnd = 0;
        int nextWindowStart = 0;
        int maxLength = 0;

        while (windowEnd < s.length()) {

            if ((!map.containsKey(s.charAt(windowEnd))) && (map.size() == k - 1)) {

                nextWindowStart = windowEnd;

            }

            if ((map.containsKey(s.charAt(windowEnd))) || (map.size() < k)) {

                map.put(s.charAt(windowEnd), 0);
                windowEnd++;

            } else {

                maxLength = Math.max(maxLength, windowEnd - windowStart);
                map.clear();

                if (k > 1) {

                    windowEnd = nextWindowStart;
                    windowStart = nextWindowStart;

                } else {

                    windowStart = windowEnd;

                }

            }

        }

        return maxLength;

    }

}
