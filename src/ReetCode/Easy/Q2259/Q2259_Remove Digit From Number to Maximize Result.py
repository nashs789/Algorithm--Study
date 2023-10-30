class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        arr = []
        
        for idx, num in enumerate(number):
            if num == digit:
                arr.append(int(number[:idx] + number[idx + 1:]))

        return str(max(arr))
    
s = Solution()
result = s.removeDigit("123", "3")

print(result)