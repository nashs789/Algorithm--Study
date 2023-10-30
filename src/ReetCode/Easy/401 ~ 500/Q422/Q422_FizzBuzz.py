class Solution:
    def fizzBuzz(self, n: int) -> list[str]:
        answer = []
        
        for idx in range(1, n + 1):
            div_five = idx % 5
            div_three = idx % 3

            if div_three == 0 and div_five == 0:
                answer.append("FizzBuzz")
            elif div_three == 0:
                answer.append("Fizz")
            elif div_five == 0:
                answer.append("Buzz")
            else:
                answer.append(str(idx))

        return answer


s = Solution()
print(s.fizzBuzz(15))
