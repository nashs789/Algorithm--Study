"""
# Author    : Lee In Bok 
# Date      : 2023.11.04(Sat)
# Spend Time: 06m 34s
# Runtime   : 42 ms (Beats 70.84%)
# Memory    : 16.3 MB (Beats 32.40%)
# Algoritm  : Binary Search
"""

# class Solution:
#     def mySqrt(self, x: int) -> int:
#         if not x:
#             return 0
        
#         if x < 4:
#             return 1

#         for num in range(x):
#             res = num * num

#             if res == x:
#                 return num
#             elif res > x:
#                 return num - 1
            
class Solution:
    def mySqrt(self, x: int) -> int:        
        ans, srt, end = 0, 0, x

        while srt <= end:
            mid = (srt + end) // 2
            res = mid * mid

            if res == x:
                return mid
            elif res > x:
                end = mid - 1
            else:
                srt = mid + 1
                ans = mid
        return ans
            

s = Solution()
result = s.mySqrt(0)

print(result)