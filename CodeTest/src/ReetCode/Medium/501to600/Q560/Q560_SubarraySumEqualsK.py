# class Solution:
#     def subarraySum(self, nums: list[int], k: int) -> int:
#         dic = {0:1}
#         res = 0
#         curr = 0
#         for i in range(len(nums)):
#             curr += nums[i]
#             res += dic.get(curr-k, 0)
#             dic[curr] = dic.get(curr, 0) +1
#         return res 

class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        dic = {0:1}
        ans, cur = 0, 0

        for idx in range(len(nums)):
            cur += nums[idx]
            ans += dic.get(cur - k, 0)
            dic[cur] = dic.get(cur, 0) + 1

        return ans
    
s = Solution()
result = s.subarraySum([1,1,1], 2)

print(result)