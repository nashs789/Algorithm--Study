"""
# Author    : Lee In Bok 
# Date      : 2023.11.17(Fri)
# Spend Time: overtime 30m
# Runtime   : 1286.09 ms (Longest time)
# Memory    : 89.2 MB (Most spacious)
# Algoritm  : Implementation
"""

# def solution(targets):
#     ans, bound = 0, 0
#     targets = sorted(targets, key=lambda x: x[0])

#     for x, y in targets:
#         if bound > x:
#             bound = min(bound, y)
#         else:
#             bound = y
#             ans += 1

#     return ans

def solution(targets):
    ans, bound = 0, 0
    
    for x, y in sorted(targets):
        if x >= bound:
            bound = y
            ans += 1

    return ans

# def solution(targets):
#     ans, bound = 0, 0
    
#     for x, y in sorted(targets):
#         print(x, '    ', y, '    ', bound)
#         if x >= bound:
#             bound = y
#             ans += 1
#         else:
#             bound = min(y, bound)

#     return ans

result = solution([[0,4],[5,10],[6,8],[8,9]])

print(result)