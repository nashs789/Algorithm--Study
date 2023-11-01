"""
# Author    : Lee In Bok 
# Date      : 2023.11.01(Wed)
# Spend Time: 04m 40s
# Runtime   : 50 ms (Beats 80.77%)
# Memory    : 16.9 MB (Beats 89.35%)
# Algoritm  : Array
"""

from typing import List

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        for idx in range(len(nums)):
            if nums[idx] == target or target < nums[idx]:
                return idx
            elif idx == len(nums) - 1:
                return len(nums)

s = Solution()
result = s.searchInsert([1,3,5,6], 7)

print(result)