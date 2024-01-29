"""
# Author    : Lee In Bok 
# Date      : 2023.11.02(Thu)
# Spend Time: 08m 13s
# Runtime   : 30 ms (Beats 97.37%)
# Memory    : 16.2 MB (Beats 38.4%)
# Algoritm  : String
"""

from typing import List

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        num = (int) (''.join(str(e) for e in digits)) + 1

        return list(map(int, str(num)))

s = Solution()
result = s.plusOne([1,2,3])

print(result)