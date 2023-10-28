class Solution:
    def lengthOfLIS(self, nums: list[int]) -> int:   
        Len = len(nums)
        dp = [1] * Len
        
        for i in range(Len):
            for j in range(i):
                if nums[i] > nums[j]:
                    print(nums[i], "    ", nums[j])
                    dp[i] = max(dp[j] + 1, dp[i])
                    
        return max(dp)

s = Solution()
result = s.lengthOfLIS([10,9,2,5,3,7,101,18])

print(result)