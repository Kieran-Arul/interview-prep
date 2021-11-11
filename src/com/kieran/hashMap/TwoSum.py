# Given an array of integers nums and an integer target, return indices of the two numbers such that they add
# up to target.
# You may assume that each input would have exactly one solution, and you may not use the same element twice.
# You can return the answer in any order.

# Input: nums = [2,7,11,15], target = 9
# Output: [0,1]
# Output: Because nums[0] + nums[1] == 9, we return [0, 1].

# Input: nums = [3, 3], target = 6
# Output: [0,1]


def two_sum(arr, target):

    d = {}

    for idx, num in enumerate(arr):

        complement = target - num

        if complement in d:

            return [d[complement], idx]

        d[num] = idx

    return None


print(two_sum([3, 3], 6))
print(two_sum([2, 7, 11, 15], 9))
print(two_sum([3, 12, 14, 25, 7, 13], 27))
