package com.patterns.twopointers.easy.java;

// LeetCode #21
// Merge two sorted lists

// Example:
// Input: l1 = [1,2,4], l2 = [1,3,4]
// Output: [1,1,2,3,4,4]

import java.util.Arrays;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        int[] l1Test = {1, 3, 5};
        int[] l2Test = {2, 4, 6};

        System.out.println(Arrays.toString(mergeTwoSortedLists(l1Test, l2Test)));
    }

    private static int[] mergeTwoSortedLists(int[] l1, int[] l2) {

        int[] res = new int[l1.length + l2.length];
        int l1Ptr = 0;
        int l2Ptr = 0;
        int resPtr = 0;

        while ((l1Ptr < l1.length) && (l2Ptr < l2.length)) {

            int currL1 = l1[l1Ptr];
            int currL2 = l2[l2Ptr];

            if (currL1 < currL2) {

                res[resPtr] = currL1;
                l1Ptr++;
                resPtr++;

            } else if (currL2 < currL1) {

                res[resPtr] = currL2;
                l2Ptr++;
                resPtr++;

            } else {

                res[resPtr] = currL1;
                resPtr++;
                res[resPtr] = currL2;
                l1Ptr++;
                l2Ptr++;
                resPtr++;

            }

        }

        if (l1Ptr == l1.length) {

            for (int i = l2Ptr; i < l2.length; i++) {
                res[resPtr] = l2[i];
                resPtr++;
            }

        } else if (l2Ptr == l2.length) {

            for (int i = l1Ptr; i < l1.length; i++) {
                res[resPtr] = l1[i];
                resPtr++;
            }

        }

        return res;

    }

}
