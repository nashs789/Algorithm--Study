# class Solution:
#     def unequalTriplets(self, nums: list[int]) -> int:
#         answer = []

#         for i in range(len(nums) - 2):
#             for j in range(i + 1, len(nums) - 1):
#                 if nums[i] == nums[j]:
#                     continue

#                 for k in range(j + 1, len(nums)):
#                     if nums[i] != nums[k] and nums[j] != nums[k]:
#                         answer.append([i, j, k])
        
#         return len(answer)
    
from collections import Counter

class Solution:
    def unequalTriplets(self, nums: list[int]) -> int:
        dic = Counter(nums)
        List = []
        answer = 0
        
        for key, val in dic.items():
            List.append(val)

        for i in range(len(List) - 2):
            for j in range(i + 1, len(List) - 1):
                for k in range(j + 1, len(List)):
                        answer += (List[i] * List[j] * List[k])

        return answer
        

s = Solution()
result = s.unequalTriplets([4,4,2,4,3,1])

print(result)