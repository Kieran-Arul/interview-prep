# leetcode Q445
# Input: l1 = [2,4,3], l2 = [5,6,4]
# Output: [7,0,8]
# Explanation: 342 + 465 = 807.


# Definition for singly-linked list.
class ListNode:
     def __init__(self, val=0, next=None):
            self.val = val
            self.next = next
class Solution:
    def addTwoNumbers(self, l1, l2):
        dummy = ListNode()
        current = dummy
        carry = 0
        # take two values.
        while l1 or l2 or carry:
            if l1:
                value1 = l1.val
            else:
                value1 = 0
            if l2:
                value2 = l2.val
            else:
                value2 = 0
            # take sum and carry
            sum_num = value1 + value2 + carry
            carry = sum_num // 10
            sum_num = sum_num % 10
            
            current.next = ListNode(sum_num)
            # update node
            current = current.next
            if l1:
                l1 = l1.next
            else:
                l1 = None
            if l2:
                l2 = l2.next
            else:
                l2 = None
        
        return dummy.next