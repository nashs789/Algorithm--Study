"""
# Author    : Lee In Bok 
# Date      : 2023.12.01(Fri)
# Spend Time: 04m 26s
# Runtime   : 35 ms (Beats 97.39%)
# Memory    : 18.9 MB (Beats 6.48%)
# Algoritm  : Tree
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        max_depth = 0

        if not root:
            return 0

        def order(depth, root):
            nonlocal max_depth
            max_depth = max(depth, max_depth)
            if root:
                if root.left:
                    order(depth + 1, root.left)
                if root.right:
                    order(depth + 1, root.right)
        
        order(1, root)
        return max_depth
        