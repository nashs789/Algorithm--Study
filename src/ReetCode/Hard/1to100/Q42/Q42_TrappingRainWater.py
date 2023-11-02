# class Solution:
#     def trap(self, heights: list[int]) -> int:
#         stack = []
#         traped, start, area = 0, 0, 0
        
#         for height in heights:
#             if start == 0:
#                 start = height
#             elif start <= height:
#                 traped += len(stack) * start - area + (-1 if start == 1 else 0)  # start가 1이면 계산이 미스나서 넣었음
#                 start = height
#                 stack = []
#                 area = 0

#             area += height
#             stack.append(height)
        
#         if len(stack) > 1:
#             start = stack[0]

#             for height in stack:
#                 if height == start:
#                     del stack[0]
#                 else:
#                     break

#         return traped

# s = Solution()
# result = s.trap([0,1,0,2,1,0,1,3,2,1,2,1])

# print(result)

class Solution:
    def trap(self, height: list[int]) -> int:
        ans, left, right = 0, 0, len(height) - 1
        left_max, right_max = height[left], height[right]
        
        while left < right:
            if left_max <= right_max:
                left += 1
                left_max = max(left_max, height[left])
                ans += left_max - height[left]
            else:
                right -= 1
                right_max = max(right_max, height[right])
                ans += right_max - height[right]
                
        return ans

s = Solution()
result = s.trap([0,1,0,2,1,0,1,3,2,1,2,1])

print(result)