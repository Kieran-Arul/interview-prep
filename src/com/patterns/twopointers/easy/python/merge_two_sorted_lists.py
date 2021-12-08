# LeetCode #21
# Merge two sorted lists

# Example:
# Input: l1 = [1,2,4], l2 = [1,3,4]
# Output: [1,1,2,3,4,4]


def merge(l1, l2):

    res = []
    i = 0
    j = 0

    while (i < len(l1)) and (j < len(l2)):

        l1_curr_val = l1[i]
        l2_curr_val = l2[j]

        if l1_curr_val < l2_curr_val:
            res.append(l1_curr_val)
            i += 1

        elif l2_curr_val < l1_curr_val:
            res.append(l2_curr_val)
            j += 1

        else:
            res.append(l1_curr_val)
            i += 1
            res.append(l2_curr_val)
            j += 1

    res += l1[i:]
    res += l2[j:]

    return res


print(merge([1, 2, 4], [1, 3, 4]))
print(merge([1, 3, 5, 12], [2, 4, 6]))
