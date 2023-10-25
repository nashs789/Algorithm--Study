class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        sub, count = "", 0

        for cha in s:
            print(sub)
            if cha not in sub:
                sub += cha
            else:
                sub = sub[sub.index(cha) + 1:] + cha

            count = max(len(sub), count)

        return count

s = Solution()
result = s.lengthOfLongestSubstring("aabaab!bb")

print(result)
