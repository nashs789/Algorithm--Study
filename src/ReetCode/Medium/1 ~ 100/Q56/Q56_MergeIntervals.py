class Solution:
    def merge(self, intervals: list[list[int]]) -> list[list[int]]:
        intervals.sort(key=lambda x : x[0])
        merged = [intervals[0]]

        for srt, end in intervals:
            if merged[-1][1] >= srt:
                merged[-1][1] = max(merged[-1][1], end)
            else:
                merged.append([srt, end])
        
        print(merged) 
        # return merged
        
s = Solution()
result = s.merge([[1,4],[0,4]])