# class Solution:
#     def findDifference(self, nums1: list[int], nums2: list[int]) -> list[list[int]]:
#         Set1, Set2 = set(nums1), set(nums2)
#         ans1, ans2 = set(), set()

#         for num in nums1:
#             if num not in Set2:
#                 ans1.add(num)

#         for num in nums2:
#             if num not in Set1:
#                 ans2.add(num)

#         return [list(ans1), list(ans2)]
    
class Solution:
    def findDifference(self, nums1: list[int], nums2: list[int]) -> list[list[int]]:
        a, b = set(nums1), set(nums2)
        
        return [list(a - b), list(b - a)]

s = Solution()
result = s.findDifference([1,2,3],[2,4,6])

print(result)