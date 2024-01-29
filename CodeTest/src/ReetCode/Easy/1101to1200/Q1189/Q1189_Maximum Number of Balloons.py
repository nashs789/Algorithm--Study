"""
# Author    : Lee In Bok 
# Date      : 2023.11.26(Sun)
# Spend Time: 07m 25s
# Runtime   : 35 ms (Beats 88.6%)
# Memory    : 16.4 MB (Beats 6.62%)
# Algoritm  : Dictionary
"""

from collections import Counter

class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        ans = 0
        target = ['b', 'a', 'l', 'l', 'o', 'o', 'n']
        dic = Counter(text)
        
        while True:
            for ch in target:
                if ch in dic and dic[ch] != 0:
                    dic[ch] -= 1
                else:
                    return ans
            ans += 1

s = Solution()
result = s.maxNumberOfBalloons("loonbalxballpoon")

print(result)