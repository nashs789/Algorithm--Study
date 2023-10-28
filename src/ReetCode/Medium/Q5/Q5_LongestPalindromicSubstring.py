class Solution:
    def longestPalindrome(self, s: str) -> str:
        ans = ""

        for i in range(len(s)):
            for j in range(i + 1, len(s)):
                temp = s[i:j+1]
                
                if len(ans) < j - i + 1 and temp == temp[::-1]:
                    ans = temp
        
        if ans == "" and len(s) > 1:
            ans = s[0]

        return ans if len(s) != 1 else s

s = Solution()
result = s.longestPalindrome("bb")

print(result)