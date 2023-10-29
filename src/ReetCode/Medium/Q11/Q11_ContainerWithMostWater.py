# class Solution:
#     def maxArea(self, height: list[int]) -> int:
#         Len, ans = len(height), 0
        
#         for i in range(Len):
#             for j in range(i + 1, Len):
#                 min_height = min(height[i], height[j])
#                 ans = max(ans, min_height * (j - i))

#         return ans

class Solution:
    def maxArea(self, height: list[int]) -> int:
        ans, left, right = 0, 0, len(height) - 1

        while left < right:
            ans = max(ans, min(height[left], height[right]) * (right - left))

            if height[left] > height[right]:
                right -= 1
            else:
                left += 1

        return ans

s = Solution()
result = s.maxArea([1,8,6,2,5,4,8,3,7])

print(result)