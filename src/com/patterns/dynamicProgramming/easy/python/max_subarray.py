# Given an integer array nums, find the contiguous subarray (containing at least one number)
# which has the largest sum and return its sum.
# A subarray is a contiguous part of an array.

# Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
# Output: 6
# Explanation: [4,-1,2,1] has the largest sum = 6.

# LeetCode Q53
# Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
# Output: 6
# Explanation: [4,-1,2,1] has the largest sum = 6.


def max_sub_array(nums):

    for idx in range(1, len(nums)):

        nums[idx] = max(nums[idx], nums[idx] + nums[idx - 1])

    return max(nums)


arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
print(max_sub_array(arr))
