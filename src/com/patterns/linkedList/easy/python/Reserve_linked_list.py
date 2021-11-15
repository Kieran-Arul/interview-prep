# LeetCode Q206
# Input: head = [1,2,3,4,5]
# Output: [5,4,3,2,1]

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:

    def reverse_list(self, head):
        # use two pointers.
        prev, curr = None, head
        # until the end of the list.
        while curr:
            # next list
            nxt = curr.next
            # use prev to replace.
            curr.next = prev
            # store current in prev
            prev = curr
            # update new value
            curr = nxt
        return prev
