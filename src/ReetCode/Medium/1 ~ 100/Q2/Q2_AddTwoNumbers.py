"""
# Author    : Lee In Bok 
# Spend Time: 22m 55s
# Runtime   : 64 ms (Beats 61.49%)
# Memory    : 16.2 MB (Beats 94.25%)
# Algoritm  : Linked List
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        sums = list(str(self.reverse(l1) + self.reverse(l2)))
        head = ListNode()
        temp = head

        for idx, num in enumerate(reversed(sums)):
            temp.val = num
            
            if idx != len(sums) - 1:
                temp.next = ListNode()
                temp = temp.next

        return head

    def reverse(self, linked: Optional[ListNode]) -> int:
        temp = ""

        while linked:
            temp += str(linked.val)
            linked = linked.next

        return int(temp[::-1])