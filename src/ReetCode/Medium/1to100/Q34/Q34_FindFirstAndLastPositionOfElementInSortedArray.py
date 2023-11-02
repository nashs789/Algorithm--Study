class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        left, right = 0, len(nums) - 1
        standard = -1
        srt, end = 0, 0

        while left <= right:
            mid = (left + right) // 2

            if nums[mid] == target:
                standard = mid
                break
            
            if nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        
        if standard == -1:
            return [-1, -1]

        for idx in range(standard, len(nums)):
            if nums[idx] == target:
                end = idx
            else:
                break

        for idx in range(standard, -1, -1):
            if nums[idx] == target:
                srt = idx
            else:
                break
        
        return [srt, end]

s = Solution()
result = s.searchRange([2,2], 2)

print(result)