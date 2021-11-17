"""
From Grokking the Coding Interview

Problem Statement 
Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose 
sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.

Example 1:
Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].

Example 2:
Input: [2, 1, 5, 2, 8], S=7 
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].

Example 3:
Input: [3, 4, 1, 1, 6], S=8 
Output: 3
Explanation: Smallest sub-arrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
"""

# SOLUTION BREAKDOWN:

# Idea is to expand the window continuously until the window sum hits or surpasses the target
# Once the target is hit, idea is to see how much we can shrink the window until we fall below the target
# We shrink the window by removing the left-most element in the window
# Repeat this until we have gone over the whole array, then we check whether what the size of the smallest window we
# could attain before falling below the target

import math


def smallest_subarray_with_given_sum(arr, s):

    window_sum = 0
    window_start = 0
    min_sub_array_size = math.inf

    for window_end in range(len(arr)):

        window_sum += arr[window_end]

        # Once we have hit the target (or crossed it), see how much we can shrink the sub-array
        # until it no longer hits the target
        while window_sum >= s:

            min_sub_array_size = min(min_sub_array_size, window_end - window_start + 1)
            window_sum -= arr[window_start]
            window_start += 1

    # We went through the whole array and never hit the target (because its value never got updated from infinity)
    if min_sub_array_size == math.inf:
        return 0

    return min_sub_array_size


print(smallest_subarray_with_given_sum([2, 1, 5, 2, 3, 2], 7))
print(smallest_subarray_with_given_sum([2, 1, 5, 2, 8], 7))
print(smallest_subarray_with_given_sum([3, 4, 1, 1, 6], 8))
print(smallest_subarray_with_given_sum([3, 4, 1, 1, 6], 80))
