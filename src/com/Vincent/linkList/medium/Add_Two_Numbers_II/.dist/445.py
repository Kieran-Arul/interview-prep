
# Input: l1 = [7,2,4,3], l2 = [5,6,4]
# Output: [7,8,0,7]

# Input: l1 = [2,4,3], l2 = [5,6,4]
# Output: [8,0,7]

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1, l2):
        # take num from each node
        num1, num2 = 0, 0
        while l1:
            num1 = num1*10 + l1.val
            l1 =l1.next
        while l2:
            num2 = num2*10 + l2.val
            l2 = l2.next
        # calculate the sum
        sum_ = num1 + num2
        # use link lise express sum
        dummyhead = ListNode(0)
        current = dummyhead
        if sum_ == 0:
            return dummyhead
        while sum_ > 0:
            dummyhead.next = ListNode(sum_ % 10,dummyhead.next)
            sum_ //= 10
        return current.next