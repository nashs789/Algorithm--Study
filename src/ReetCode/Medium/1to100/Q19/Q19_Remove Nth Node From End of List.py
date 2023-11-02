"""
# Author    : Lee In Bok 
# Date      : 2023.10.31(Tue)
# Spend Time: 16m 29s
# Runtime   : 37 ms (Beats 77.38%)
# Memory    : 16.2 MB (Beats 44.62%)
# Algoritm  : Linked List
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        size = 0
        temp, prev = head, None
        
        while temp:
            temp = temp.next
            size += 1

        temp = head

        for _ in range(size - n):
            prev = temp
            temp = temp.next

        if prev:
            prev.next = temp.next
        elif size >= 2:
            return temp.next
        else:
            return 

        return head