"""
# Author    : Lee In Bok 
# Date      : 2023.10.31(Tue)
# Spend Time: 36m 17s
# Runtime   : 642 ms (Beats 60.70%)
# Memory    : 16.3 MB (Beats 83.53%)
# Algoritm  : Two Pointer
"""

from typing import List
import math

class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        ans = math.inf
        nums.sort()

        for srt, num in enumerate(nums):
            mid, end = srt + 1, len(nums) - 1 
            
            while mid < end:
                sums = num + nums[mid] + nums[end]

                if sums == target:
                    return sums

                if abs(sums - target) < abs(ans - target):
                    ans = sums

                if sums < target:
                    mid += 1
                else:
                    end -= 1

        return ans

s = Solution()
result = s.threeSumClosest([1,1,1,0], 100)

print(result)