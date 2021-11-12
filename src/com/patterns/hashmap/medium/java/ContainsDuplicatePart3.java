package com.patterns.hashmap.medium.java;

import java.util.HashMap;
import java.util.Map;

// Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in
// the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.

//        Input: nums = [1,2,3,1], k = 3, t = 0
//        Output: true

//        Input: nums = [1,0,1,1], k = 1, t = 2
//        Output: true

//        Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//        Output: false

public class ContainsDuplicatePart3 {

    public static void main(String[] args) {

        int[] test = {1, 2, 3, 1};
        int[] test2 = {1, 0, 1, 1};
        int[] test3 = {1, 5, 9, 1, 5, 9};
        int[] test4 = {2147483640, 2147483641};

        System.out.println(containsNearbyAlmostDuplicate(test, 3, 0));
        System.out.println(containsNearbyAlmostDuplicate(test2, 1, 2));
        System.out.println(containsNearbyAlmostDuplicate(test3, 2, 3));
        System.out.println(containsNearbyAlmostDuplicate(test4, 1, 100));

    }

    // My answer: works but is slow
    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // If another element in the array falls on or within these bounds, then we have satisfied the t-condition
            // Casting to long in case of integer overflow (e.g. integers inside the nums array are near the limit)
            long complementLowerBound = (long) nums[i] - t;
            long complementUpperBound = (long) nums[i] + t;

            for (long j = complementLowerBound; j <= complementUpperBound; j++) {

                if ((map.containsKey(j)) && (Math.abs(i - map.get(j)) <= k)) {

                    return true;

                }

            }

            map.put((long) nums[i], i);

        }

        return false;

    }

    // Model answer: still trying to understand the logic of how it works
    private static boolean containsNearbyAlmostDuplicateModelAnswer(int[] nums, int k, int t) {

        if (nums.length == 0) {
            return false;
        }

        // Only looking for exact duplicates
        if (t == 0) {
            return containsNearbyDuplicateModelAnswer(nums, k);
        }

        Map<Long, Long> buckets = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Anything in the same bucket must be in the range of t
            // Anything in the next/below bucket may or not be in the range of t
            // I'm guessing?
            // Imagine t=4 and num is 7 and 9, different buckets but within range
            long bucket = (long) nums[i] / t;

            // We know from above that something within range t will either be in the same bucket, or one bucket away
            // based on how we have defined a bucket (num[i]/t)
            // We also do not need to check for k here because we know from the part below that all buckets
            // (the numbers they map to) will be within k indices of each other
            if ((buckets.containsKey(bucket) && Math.abs(buckets.get(bucket) - nums[i]) <= t) ||
                    (buckets.containsKey(bucket - 1) && Math.abs(buckets.get(bucket - 1) - nums[i]) <= t) ||
                    (buckets.containsKey(bucket + 1) && Math.abs(buckets.get(bucket + 1) - nums[i]) <= t)) {

                return true;

            }

            buckets.put(bucket, (long) nums[i]);

            // Ensure every bucket/entry in the map is within the range of t
            if (buckets.size() > k) {

                // Removes bucket of the oldest entry since nothing within k indices of it was a match, and
                // now we have moved on too far
                Long last = (long) nums[i - k] / t;
                buckets.remove(last);

            }

        }

        return false;

    }

    // Runs if we are looking for exact duplicates at most k indices away from each other
    private static boolean containsNearbyDuplicateModelAnswer(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            Integer ele = map.get(nums[i]);

            if (ele == null) {

                map.put(nums[i], i);

            } else {

                if (i - ele <= k) {

                    return true;

                } else {

                    map.put(nums[i], i);

                }

            }

        }

        return false;

    }

}
