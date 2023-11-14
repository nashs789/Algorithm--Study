"""
# Author    : Lee In Bok 
# Date      : 2023.11.12(Sun)
# Spend Time: 08m 09s
# Runtime   : 34 ms (Beats 81.21%)
# Memory    : 16.3 MB (Beats 08.46%)
# Algoritm  : Tree
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
#         ans = []

#         def inorder(node: Optional[TreeNode]):
#             #print(node.left, "    ", node.val)
#             if node:
#                 if node.left:
#                     inorder(node.left)
#                 ans.append(node.val)
#                 if node.right:
#                     inorder(node.right)

#         inorder(root)

# class Solution:
#     def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
#         def inorder(root):
#             return  inorder(root.left) + [root.val] + inorder(root.right) if root else []

#         return inorder(root)