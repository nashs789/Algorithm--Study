class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        pre = strs[0]
        strs = sorted(strs, key=lambda x : len(x))

        for word in strs:
            while not word[0:len(pre)] == pre:
                pre = pre[:-1]

        return pre


s = Solution()
answer = s.longestCommonPrefix(["flower","flow","flight", "fly"])

print(answer)