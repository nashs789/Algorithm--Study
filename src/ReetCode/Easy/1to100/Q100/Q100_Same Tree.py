"""
# Author    : Lee In Bok 
# Date      : 2023.11.14(Tue)
# Spend Time: 17m 32s
# Runtime   : 34 ms (Beats 81.70%)
# Memory    : 16.4 MB (Beats 20.68%)
# Algoritm  : Tree
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
#         self.ans = True

#         def order(p, q):
#             if not self.ans:
#                 return 

#             if p or q:
#                 try :
#                     if p.val != q.val:
#                         self.ans = False
#                         return

#                     if p.left or q.left:
#                         order(p.left, q.left)
#                     if p.right or q.right:
#                         order(p.right, q.right)
#                 except:
#                     self.ans = False

#         order(p, q)
#         return self.ans