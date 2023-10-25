class Solution:
    def isValid(self, s: str) -> bool:
        result = []

        for word in s:
            if len(result) != 0:
                if (word == ")" and result[-1] == "(") or (word == "]" and result[-1] == "[") or (word == "}" and result[-1] == "{"):
                    del result[-1]
                    continue
            
            result.append(word)

        return len(result) == 0

s = Solution()
result = s.isValid("([{()}])}")