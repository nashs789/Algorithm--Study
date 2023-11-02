"""
# Author    : Lee In Bok 
# Date      : 2023.11.01(Wed)
# Spend Time: 17m 03s
# Runtime   : 40 ms (Beats 60.28%)
# Memory    : 16.2 MB (Beats 43.55%)
# Algoritm  : List
"""

from typing import List

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        cnt = nums.count(val)

        for _ in range(cnt):
            nums.remove(val)

s = Solution()
result = s.removeElement([3,2,2,3], 3)

print(result)