# import math

# class Solution:
#     def minimumCardPickup(self, cards: list[int]) -> int:
#         if len(cards) == 1:
#             return -1
        
#         if len(cards) == 2:
#             return -1 if cards[0] != cards[1] else 2

#         srt, end, ans = 0, 1, math.inf
#         check = {cards[srt] : 1, cards[end] : 1}
#         cnt, cur_pair = 2, -1

#         while end < len(cards):
#             if cur_pair != -1:
#                 ans = min(ans, cnt)

#                 if cards[srt] not in check:
#                     check[cards[srt]] = 1
#                 else:
#                     if check[cards[srt]] == 2:
#                         cur_pair = -1

#                     check[cards[srt]] -= 1
#                 srt += 1
#                 cnt -= 1
#             else:
#                 end += 1

#                 if end == len(cards):
#                     break

#                 if cards[end] not in check:
#                     check[cards[end]] = 1  
#                 else:
#                     check[cards[end]] += 1

#                     if check[cards[end]] == 2:
#                         cur_pair = cards[end]

#                 cnt += 1

#         return ans if ans != math.inf else -1

class Solution:
    def minimumCardPickup(self, cards: list[int]) -> int:
        nums_cnt = {}  

        small_cnt = float('inf') 

        for end in range(len(cards)):
            if cards[end] in nums_cnt:
                small_cnt = min(small_cnt, end - nums_cnt[cards[end]] + 1)
            nums_cnt[cards[end]] = end

        if small_cnt == float('inf') :
            small_cnt = -1

        return small_cnt 
    
s = Solution()
result = s.minimumCardPickup([3,4,2,3,4,7])

print(result)