"""
# Author    : Lee In Bok 
# Date      : 2023.11.01(Wed)
# Spend Time: 04m 50s
# Runtime   : 36 ms (Beats 72.83%)
# Memory    : 16.2 MB (Beats 73.86%)
# Algoritm  : String
"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        h_len, n_len = len(haystack), len(needle)

        for idx in range(h_len - n_len + 1):
            if haystack[idx:idx+n_len] == needle:
                return idx
            
        return -1

# class Solution:
#     def strStr(self, haystack: str, needle: str) -> int:
#         h_len, n_len = len(haystack), len(needle)

#         for i in range(h_len - n_len + 1):
#             for j in range(n_len):
#                 if haystack[i + j] != needle[j]:
#                     break
#                 if j == n_len - 1:
#                     return i
            
#         return -1

# class Solution:
#     def strStr(self, haystack: str, needle: str) -> int:
#         return haystack.find(needle) if needle in haystack else -1

s = Solution()
result = s.strStr("sadbutsad", "sad")

print(result)