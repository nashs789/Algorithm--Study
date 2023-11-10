"""
# Author    : Lee In Bok 
# Date      : 2023.11.11(Sat)
# Spend Time: 11m 41s
# Runtime   : 35 ms (Beats 94.57%)
# Memory    : 16.5 MB (Beats 22.99%)
# Algoritm  : Array
"""

from typing import List

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        for idx in range(m, m + n):
            nums1[idx] = nums2[idx - m]

        nums1.sort()

s = Solution()
s.merge([1,2,3,0,0,0], 3, [2,5,6], 3)