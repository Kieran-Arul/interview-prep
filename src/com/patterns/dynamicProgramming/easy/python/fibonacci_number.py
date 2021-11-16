# Leetcode Q509
# Input: n = 2
# Output: 1
# Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

def dynamic_fib(n):

    cache = {}

    def fib(x):

        if x in cache:
            pass

        if x < 2:
            cache[x] = x

        else:
            cache[x] = fib(x - 1) + fib(x - 2)

        return cache[x]

    return fib(n)


print(dynamic_fib(13))
