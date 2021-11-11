"""
Problem Statement #
Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray size ‘k’.
Example 1:
Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
Example 2:
Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
"""


# Idea here is that we want to form a "window" of size k on the first k elements
# Then we want to get the sum of the numbers in that window and compare it to the current max sum
# Then we want to slide the window down by 1 place and get the window sum there and compare it to the current max sum
# We want to keep sliding the window down by one until we reach the end of the array
def max_subarray_of_size_k(arr, k):

    window_sum = 0
    max_sum = 0
    window_start = 0

    for window_end in range(len(arr)):

        window_sum += arr[window_end]

        # Once the window has reached a size of k
        if window_end >= k - 1:

            max_sum = max(window_sum, max_sum)
            window_sum -= arr[window_start]
            window_start += 1

    return max_sum
