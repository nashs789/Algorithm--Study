"""
# Author    : Lee In Bok 
# Date      : 2023.11.08(Wed)
# Spend Time: 18m 40s
# Runtime   : 46 ms (Beats 58.11%)
# Memory    : 16.3 MB (Beats 53.09%)
# Algoritm  : Linked List
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# class Solution:
#     def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
#         prev = None
#         temp = head

#         while temp:
#             if prev and prev.val == temp.val:
#                 prev.next = temp.next
#             else:
#                 prev = temp
            
#             temp = temp.next

#         return head