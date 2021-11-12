# Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
# such that nums[i] == nums[j] and abs(i - j) <= k.

# Input: nums = [1,2,3,1], k = 3
# Output: true

# Input: nums = [1,0,1,1], k = 1
# Output: true

# Input: nums = [1,2,3,1,2,3], k = 2
# Output: false

def contains_duplicate_part_two(arr, k):
    d = {}

    for idx, num in enumerate(arr):

        if (num in d) and (abs(d[num] - idx) <= k):
            return True

        d[num] = idx

    return False


print(contains_duplicate_part_two([1, 2, 3, 1], 3))
print(contains_duplicate_part_two([1, 0, 1, 1], 1))
print(contains_duplicate_part_two([1, 2, 3, 1, 2, 3], 2))
