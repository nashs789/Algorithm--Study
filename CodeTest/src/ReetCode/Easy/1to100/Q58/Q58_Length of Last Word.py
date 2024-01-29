"""
# Author    : Lee In Bok 
# Date      : 2023.11.02(Thu)
# Spend Time: 02m 04s
# Runtime   : 40 ms (Beats 42.79%)
# Memory    : 16.3 MB (Beats 61.42%)
# Algoritm  : Array
"""

class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        return len(s.strip().split(" ")[-1])

s = Solution()
result = s.lengthOfLastWord("   fly me   to   the moon  ")

print(result)