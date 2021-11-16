from collections import Counter
# leetcode Q532

# Input: nums = [3,1,4,1,5], k = 2
# Output: 2
# Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
# Although we have two 1s in the input, we should only return the number of unique pairs.

# Input: nums = [1,2,3,4,5], k = 1
# Output: 4
# Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

# Input: nums = [1,3,1,5,4], k = 0
# Output: 1
# Explanation: There is one 0-diff pair in the array, (1, 1).



def Vin_findPairs(nums, k):
    nums.sort()
    count = 0
    hashtable = {}
    for i in range(len(nums)):
        for j in nums[i+1:]:
            result = abs(nums[i] - j)
            if result > k:
                break
            elif result < k:
                continue
            elif result == k:
                if (nums[i],j) in hashtable or (j,nums[i]) in hashtable:
                    continue
                else:
                    hashtable[(nums[i],j)] = 1
                    hashtable[(j,nums[i])] = 1
                    count += 1 
                    continue
    return count

def Hashmap_findPairs(nums, k):
    result = 0
    counter = Counter(nums)
    for x in counter:
        # print(x)
        if k > 0 and x + k in counter:
            result += 1
        elif k == 0 and counter[x] > 1:
            result += 1
    return result

print(Vin_findPairs([1,2,4,4,3,3,0,9,2,3],3),2)
print(Hashmap_findPairs([1,2,4,4,3,3,0,9,2,3],3))
# counter: Counter({3: 3, 2: 2, 4: 2, 1: 1, 0: 1, 9: 1}), x: 1,2,4,3,0,9