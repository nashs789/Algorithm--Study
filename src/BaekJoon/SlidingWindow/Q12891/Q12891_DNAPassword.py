import sys
input = sys.stdin.readline

class Solution:
    def sol(self, s: int, p: int, dna: list[str], check: dict) -> int:
        ans, srt, end = 0, 0, p - 1

        while end < s:
            check[dna[end]] += 1

            if A <= check['A'] and C <= check['C'] and G <= check['G'] and T <= check['T']:
                ans +=1

            check[dna[srt]] -= 1
            srt += 1
            end += 1

        return ans

s, p = map(int, input().split())
dna = list(str(input()).strip())
A, C, G, T = map(int, input().split())
check = {'A': 0, 'C': 0, 'G': 0, 'T': 0}

for idx in range(p - 1):    # p - 1: 위에서 로직 동작할 때 end index 글자를 추가해줌 여기서 빼는게 편함
    check[dna[idx]] += 1

Sol = Solution()
result = Sol.sol(s, p, dna, check)

print(result)