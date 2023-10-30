from heapq import heappop, heappush

class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        heap = []

        for num in nums:
            heappush(heap, num)

            if len(heap) > k:
                heappop(heap)
        
        print(heappop(heap))

s = Solution()
result = s.findKthLargest([3,2,1,5,6,4], 2)

print(result)