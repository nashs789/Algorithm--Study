"""
# Author    : Lee In Bok 
# Date      : 2023.10.31(Tue)
# Spend Time: 14m 57s
# Runtime   : 47 ms (Beats 80.83%)
# Memory    : 16.1 MB (Beats 90.5%)
# Algoritm  : ?. ?
"""

class Solution:
    def intToRoman(self, num: int) -> str:
        dic = {1: "I", 4: "IV", 5: "V", 9: "IX",  10: "X",   
               40: "XL", 50: "L", 90: "XC", 100: "C",  
               400: "CD", 500: "D", 900: "CM", 1000: "M"}
        ans = ""

        for n in reversed(dic.keys()):
            result = num // n
            ans += dic[n] * result
            num %= n

        return ans

s = Solution()
result = s.intToRoman(1994)

print(result)