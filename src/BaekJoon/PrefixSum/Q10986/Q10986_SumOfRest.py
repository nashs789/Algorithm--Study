import sys
input = sys.stdin.readline

if __name__ == "__main__":
    N, M = map(int, input().strip().split())
    nums = list(map(int, input().split()))
    prefix = [0] * N
    rest = [0] * M
    answer = 0

    prefix[0] = nums[0]

    for idx in range(1, N):
        prefix[idx] = prefix[idx - 1] + nums[idx]

    for num in prefix:
        temp = num % M

        if temp == 0:
            answer += 1
        rest[temp] += 1

    for idx in range(M):
        if rest[idx] != 0:
            answer += (rest[idx] * (rest[idx] - 1)) // 2
    
    print(answer)