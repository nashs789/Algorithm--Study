"""
# Author    : Lee In Bok 
# Date      : 2023.10.31(Tue)
# Spend Time: 13m 34s
# Runtime   : 37 ms (Beats 67.73%)
# Memory    : 16.2 MB (Beats 62.40%)
# Algoritm  : Backtracking
"""

from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

        button = {
            '2': ['a', 'b', 'c'],
            '3': ['d', 'e', 'f'],
            '4': ['g', 'h', 'i'],
            '5': ['j', 'k', 'l'],
            '6': ['m', 'n', 'o'],
            '7': ['p', 'q', 'r', 's'],
            '8': ['t', 'u', 'v'],
            '9': ['w', 'x', 'y', 'z']
        }
        ans = []

        def backtracking(combIdx:int, comb: str):
            if len(digits) == len(comb):
                ans.append(comb)
                return

            for letter in button[digits[combIdx]]:
                backtracking(combIdx + 1, comb + letter)

        backtracking(0, "")

        return ans

s = Solution()
result = s.letterCombinations("23")

print(result)