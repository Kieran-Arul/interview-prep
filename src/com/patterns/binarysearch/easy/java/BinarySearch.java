package com.patterns.binarysearch.easy.java;

public class BinarySearch {

    public static void main(String[] args) {

        int[] test = {-1,0,3,5,9,12};

        System.out.println(binarySearch(test, 9));
        System.out.println(binarySearch(test, 2));

    }

    private static int binarySearch(int[] nums, int target) {

        int leftPtr = 0;
        int rightPtr = nums.length - 1;

        int midpoint;

        while (leftPtr <= rightPtr) {

            // (rightPtr - leftPtr) / 2 obtains the offset of the midpoint in relation to where leftPtr is
            midpoint = leftPtr + ((rightPtr - leftPtr) / 2);

            if (nums[midpoint] == target) {
                return midpoint;
            }

            if (target > nums[midpoint]) {
                leftPtr = midpoint + 1;
            }

            else {
                rightPtr = midpoint - 1;
            }

        }

        return -1;

    }

}
