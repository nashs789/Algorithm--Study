# ** [ 08월 06일 (일) 기록 ] **
- 인원: 2명
- 장소: 구로역 할리스
- 시간: 10:00 - 13:00

# ** [ To - DO ] **

- 다음주 세미발표: (스터디원들과 공유)
    - 발표자: 홍희표님
    - 발표내용: 이분탐색
    - 8/13 게더타운

- 과제: 그리디 알고리즘 (Greedy Algorithm)
    - URL: 
      1. [Q16953  - A → B (Silver 2)](https://www.acmicpc.net/problem/16953)
      2. [Q1339  - 단어 수학 (Gold 4)](https://www.acmicpc.net/problem/1339)
      3. [Q1449  - 수리공 항승 (Silver 3)](https://www.acmicpc.net/problem/1449)
      4. [Q3109  - 빵집 (Gold 2)](https://www.acmicpc.net/problem/3109)

# ** [ 발표 내용 ] **

# 누적합 알고리즘 (Prefix Sum Algorithm)
--------------------------------------------------
## 누적합

- 누적합 알고리즘은 배열의 특정 부분에 대한 총합을 빠르게 계산하는데 사용된다.
- 미리 구간 합을 계산해 놓는 방식으로 여러 쿼리에서의 효율적인 계산을 가능하게 한다.

*Q) 여러 쿼리에서 효율적인 계산을 가능하게 한다는것은?*

A) 배열의 여러 부분들에 대한 합을 여러번 계산해야 하는 경우에 유용

기본적인 예시

```java
public int[] prefixSum(int[] arr) {
    int[] prefixSumArr = new int[arr.length + 1];
    for (int i = 1; i <= arr.length; i++) {
        prefixSumArr[i] = prefixSumArr[i - 1] + arr[i - 1];
    }
    return prefixSumArr;
}

```

## 누적합 알고리즘 간단 예시

![누적합 알고리즘 간단 예시](https://blog.kakaocdn.net/dn/mCKCQ/btrCY7aFHFh/gAepc15LCncEJeGKmxkVL1/img.png)

- 누적 합 이란 수열 An에 대해서 각 인덱스까지의 구간의 합을 구하는 것을 누적 합이라고 합니다.
- 시작점은 항상 첫번째 원소이며, R번째 원소까지의 합을 앞에서부터 쭉 더해오는 패턴입니다.
- 모든 구간에 대해서 처음부터 계산하여 단순 반복하는 것이 아니라 이전 인덱스까지의 누적합에 현재 자기 자신 값을 더하여 구현하는 것이 효과적인 방법입니다.

그렇다면 어떠한 경우에 효과적으로 누적합 알고리즘을 적용시킬 수 있을까요?

**=> 배열의 [ A ~ B ] 범위의 구간 합을 구하고자 할 때, 누적합 배열을 구한 후 B 까지의 누적합에서 A-1까지의 누적합을 빼주면 [ A ~ B] 범위의 구간의 합을 구할 수 있습니다.**

## 누적합 알고리즘 과정

---

1. `index`의 값은 `0`부터 시작합니다.
2. 배열 `array`의 `i`번째 값은 `array[i - 1]`입니다.
3. 누적합 배열 preSum은 기본 배열 `arr`보다 크기가 `1` 큰 배열입니다.

---

![누적합 알고리즘 과정](https://velog.velcdn.com/images/pnlkc/post/53a88d86-2ab7-4df2-bf1e-31ab6d587bbb/image.png)

**만약 위와 같은 기본 배열 `arr`이 있다면 누적합 배열은 다음과 같은 과정을 통해 만들어집니다.**

**1. `기본 배열 사이즈 + 1`의 누적합 배열 `preSum`을 생성합니다.**

![누적합 알고리즘 과정 2](https://velog.velcdn.com/images/pnlkc/post/c5a5f630-e159-4b6a-a48f-8ae893b269d2/image.png)

**2. `arr` 배열을 순서대로 실행하면서, `preSum[i + 1]`를 `preSum[i] + arr[i]`로 변경합니다.**

![누적합 알고리즘 과정 3](https://velog.velcdn.com/images/pnlkc/post/259eb588-91a3-48bc-8520-ea2e18308a45/image.png)

**3. `arr`의 `a`번째 요소부터 `b`번째 요소의 구간합은 `preSum[b] - preSum[a - 1]`의 값이 됩니다.**

**예를 들어**, `arr`의 `4`번째 요소부터 `6`번째 요소까지의 합은 `preSum[6] - presum[3]`인 `15`가 됩니다.

![누적합 알고리즘 과정 4](https://velog.velcdn.com/images/pnlkc/post/faf48539-ff4d-4280-b62a-bd59a387b967/image.png)

![누적합 알고리즘 과정 5](https://velog.velcdn.com/images/pnlkc/post/f4969653-0491-4058-b14e-75cdabb0febe/image.png)

---

---

## 구간합

- 구간합은 누적합 구간간의 차이만 빼면 된다.
- 이를 위해 구간 합을 계산하기 위한 미리 계산된 값들을 사용한다.

![누적합 구간합](https://blog.kakaocdn.net/dn/ChoXz/btrQD88uIkC/6in1BSQw27hu0jEie9zVh0/img.png)

누적합 알고리즘은 배열의 특정 부분에 대한 총합을 빠르게 계산하는 데 사용된다. 

이를 통해 여러 쿼리에서 효율적인 계산이 가능해지며, 배열의 여러 부분들에 대한 합을 여러 번 계산해야 하는 경우에 유용하다.

구간합의 공식은 x, y(x < y) 라고 가정할 때 prefix_sum[y] - prefix_sum[x-1] 이 된다. 0번째 부터 N 까지 구하면 인덱스 초과가 날수 있기 때문에 맨 앞에 0을 추가하면 좋다.

![누적합 구간합2](https://blog.kakaocdn.net/dn/LXhHv/btrQDO3tAUm/kuv5PKYD3K1KalFAykdeuK/img.png)

예시) arr배열의 원소들 중 index 3부터 6까지의 합을 구하고 싶다면 원래의 구하는 방식은 다음과 같다.

arr[3] + arr[4] + arr[5] + arr[6]

다만, prefix sum이라는 누적합 배열이 있을 경우,

prefix_sum[6] - prefix_sum[3] 을 통해 O(1)의 시간복잡도로 계산할 수 있다.

index n부터 m까지의 합을 구하고 싶은데, n부터 m이 너무 큰 수일 경우, 누적합 알고리즘의 효용이 가장 커지게 된다.

---

---

## 2차원 누적합

- 2차원 누적합은 1차원 누적합을 확장한 개념으로, 행렬에서 특정 영역의 합을 빠르게 계산하는 데 사용된다.
- 이 알고리즘은 2차원 배열의 각 위치에서 그 위치까지의 누적합을 계산하여 새로운 2차원 배열을 생성한다.
- 이때 누적합은 (0,0)에서 현재 위치까지의 모든 원소들의 합을 의미한다.

2차원 누적합 알고리즘은 다음과 같은 상황에서 사용합니다 :

- 2차원 배열에서 반복적으로 영역 합을 계산해야 할 경우
- 영상처리에서 특정 영역의 픽셀 값 합을 빠르게 구해야 하는 경우
- 2차원 데이터에 대한 빠른 업데이트와 쿼리가 필요한 경우

기본적인 예시)

```java
public int[][] prefixSum2D(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] prefixSumMatrix = new int[rows + 1][cols + 1];

		for (int i = 1; i <= rows; i++) {
		    for (int j = 1; j <= cols; j++) {
		        prefixSumMatrix[i][j] = matrix[i - 1][j - 1]
		            + prefixSumMatrix[i - 1][j]
		            + prefixSumMatrix[i][j - 1]
		            - prefixSumMatrix[i - 1][j - 1];
		    }
		}
		return prefixSumMatrix;
}

```

*Q) 왜 matrix[i - 1][j - 1]을 해주는거죠?*

A)

2차원 누적합 배열에서는 원본 배열보다 한 칸 더 크게 배열을 설정하는 경우가 많습니다. 즉, 원본 배열이 n x m 크기라면 누적합 배열을 (n+1) x (m+1) 크기로 설정합니다. 이렇게 하는 이유는 누적합을 구하면서 경계 체크를 할 필요가 없게 되므로 코드를 간결하게 만들 수 있습니다.

그래서 **`matrix[i-1][j-1]`**로 더해주는 것은 누적합 배열에서 **`(i, j)`** 위치의 원래 값을 가져오는 것이고, 이를 누적합 배열의 **`(i, j)`** 위치에 더해주는 것입니다. 또한 누적합 배열의 **`(i, j)`**는 원본 배열의 **`(i-1, j-1)`** 위치까지의 누적합을 가지고 있습니다.

## **예시 문제 풀어보기**

![2차원 누적합](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8c126f59-d783-43a7-9775-796ccf98dd27/Untitled.png)

### 1. 이차원 배열의 (1,1)부터 (i,j)까지의 누적합 구하기

PS[i][j] = PS[i-1][j] + PS[i][j-1] - PS[i-1][j-1] + arr[i - 1][j - 1]

ex) i = 3, j = 4인 경우

PS[3][4] = PS[2][4] + PS[3][3] - PS[2][3] + arr[2][3]

### 2. (i,j)부터 (x,y)까지의 부분합 구하기

PS[x][y] = PS[x][j-1] - PS[i-1][y] + PS[i-1][j-1]

ex) i = 2, j = 2, x = 5, y = 3인 경우

i = 2, j = 2, x = 5, y = 3  → PS[5][3] - PS[5][1] - PS[1][3] + PS[1][1]

PS[5][3] - PS[5][1] - PS[1][3] + PS[1][1] 

PS[x][y] - PS[x][j - 1] - PS[i -1][y] + PS[i -1][j -1]

*정답* 

![2차원 누적합 2](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6ff85b9c-6639-4b50-af05-969f2abc4349/Untitled.png)

예시 문제)

누적합 문제임을 바로 알 수 있는 문제 → https://www.acmicpc.net/problem/11660

누적합 문제임을 바로 알 수 없는 문제 → https://www.acmicpc.net/problem/25682
