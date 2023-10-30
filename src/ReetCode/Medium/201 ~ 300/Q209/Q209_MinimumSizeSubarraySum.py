import math

class Solution:
    def minSubArrayLen(self, target: int, nums: list[int]) -> int:
        srt, sums = 0, 0
        ans = math.inf

        for end, num in enumerate(nums):
            sums += num

            while sums >= target:
                ans = min(ans, end - srt + 1)
                sums -= nums[srt]
                srt += 1
            
        return ans if ans != math.inf else 0
                

s = Solution()
result = s.minSubArrayLen(7, [2,3,1,2,4,3])

print(result)