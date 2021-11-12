# Input: n = 2
# Output: 1
# Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

def fib(n):
    if n <= 1:
        return n;
    return fib(n-1) + fib(n-2)

print(fib(13),233)