# leetcode Q509
# Input: n = 2
# Output: 1
# Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

def dynamicFib(n):
    arr = [0,1]
    if n == 1:
        return 0
    elif n == 2:
        return 1
    else:
        while(len(arr)<n):
            arr.append(0)
        if(n == 0 or n == 1):
            return 1
        else:
            arr[0]=0
            arr[1]=1
            for i in range(2,n):
                arr[i]=arr[i-1]+arr[i-2]
            return arr[-1]


def recurFib(n):
    if n <= 1:
        return n
    return recurFib(n - 1) + recurFib(n - 2)


print(recurFib(13), 233)
print(recurFib(13), 233)
