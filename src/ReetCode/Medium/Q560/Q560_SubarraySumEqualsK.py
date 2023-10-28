from collections import Counter

class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        dic = Counter(nums)
        dic[0] = 1
        sums, answer = 0, 0

        for num in nums:
            sums += num
            answer += dic[sums - k]
            dic[sums] += 1

        print(answer)

s = Solution()
result = s.subarraySum([-1,-1,1], 0)

print(result)