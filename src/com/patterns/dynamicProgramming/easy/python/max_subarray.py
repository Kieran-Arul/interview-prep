# leetcode Q53
# Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
# Output: 6
# Explanation: [4,-1,2,1] has the largest sum = 6.


nums = [-2,1,-3,4,-1,2,1,-5,4]
def maxSubArray(nums):
    # record the max as the first
    max_total = nums[0]
    # count the total
    total = 0
    # for each num, find the total and compare it
    for each in nums:
        # if its smaller than 0, then repalce it to 0.
        if total < 0:
            total = 0
        total = total + each
        # comapre it.
        max_total = max(total,max_total)
    return max_total
    
print(maxSubArray(nums),6)
