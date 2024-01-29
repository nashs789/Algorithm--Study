from typing import Optional
import sys

Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def closestNodes(self, root: Optional[TreeNode], queries: list[int]) -> list[list[int]]:
        arr, ans = [], []

        self.pre_order(root, arr)
        print(arr)

        for key in queries:
            ans.append(self.binary_search(arr, key))

        print(ans)
        return ans
            
    def binary_search(self, arr, key):
        leng = len(arr)
        left, mid_val, right = 0, 0, leng - 1

        while left <= right:
            mid = (left + right) // 2
            mid_val = arr[mid]

            if mid_val == key:
                return [mid_val, mid_val]

            if mid_val > key:
                right = mid - 1
            else:
                left = mid + 1

        if mid_val > key:
            if mid - 1 >= 0:
                return [arr[mid - 1], mid_val]
            else:
                return [-1, mid_val]
        else:
            if mid + 1 < leng:
                return [mid_val, arr[mid + 1]]
            else:
                return [mid_val, -1]


    def pre_order(self, root, arr) -> list[int]:
        if not root:
            return

        self.pre_order(root.left, arr)
        arr.append(root.val)
        self.pre_order(root.right, arr)