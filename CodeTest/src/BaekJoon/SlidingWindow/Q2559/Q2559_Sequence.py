"""
# Author    : Lee In Bok 
# Date      : 2023.11.03(Fri)
# Spend Time: 25m 09s
# Runtime   : 88 ms
# Memory    : 40156 KB
# Algoritm  : Prefix Sum
"""

import sys
input = sys.stdin.readline

# class Solution():
#     def sol(self):
#         ans = 0

#         for i in range(N - K + 1):
#             ans = max(sum(arr[i : i+K]), ans)
        
#         return ans
    
class Solution():
    def sol(self):
        ans = prefix[K - 1]
        
        for idx in range(K, N):
            ans = max(ans, prefix[idx] - prefix[idx - K])

        return ans
    
    def prefix(self):
        prefix = [0 for _ in range(N)]
        prefix[0] = arr[0]

        for idx in range(1, N):
            prefix[idx] = prefix[idx - 1] + arr[idx]

        return prefix

N, K = map(int, input().split())
arr = list(map(int, input().split()))

s = Solution()
prefix = s.prefix()
result = s.sol()

print(result)