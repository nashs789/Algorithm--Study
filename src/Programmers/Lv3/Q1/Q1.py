"""
# Author    : Lee In Bok 
# Date      : 2023.12.29(Fri)
# Spend Time: 17m 53s
# Runtime   : 3681.42 ms (Longest Time)
# Memory    : 10.3MB (Most Spacious)
# Algoritm  : Palindrome
"""

def solution(s):
  ans = 1    
  
  for i in range(len(s)):
    for j in range(i + 2, len(s) + 1):
      if s[i:j] == s[i:j][::-1]:
        ans = max(ans, len(s[i:j]))

  return ans

res = solution("abcdcba")
print(res)