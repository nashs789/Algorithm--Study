# **[ 정보 ]**
1. 소요 시간: 
2. 날짜: 2023.05.25(목)
3. 저자: 이 인복
4. 난이도: BaekJoon (Gold 5)
5. 분류: BFS
6. 문제: 숨바꼭질3

# **[ 문제 설명 ]**

<img width="1153" alt="스크린샷 2023-05-25 오후 11 42 04" src="https://github.com/nashs789/CodeTest/assets/59809278/764207e2-746a-4fe6-979a-06e6445aa7da">

수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.   
수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.   
순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

# **[ 입력 ]**
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

# **[ 출력 ]**
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

# **[ 예제 입력 #1 ]**
    5 17

# **[ 예제 출력 #1 ]**
    2

# **[ 접근 순서 ]**
1. 일반적인 BFS 알고리즘과 다르게 접근 했음
   - 0 ~ 100000 이라는 조건이 주어졌기 때문에 현재 위치에서 각 좌표로 이동할 수 있는 최소 거리를 배열에 저장
   - 저장한 배열에서 주어긴 동생의 위치 K 방에 있는 정수 값이 정답
   - visited 체크를 하지 않고, 배열의 인덱스를 벗어 나거나, 이미 저장된 거리 값보다 큰 경우 패스

# **[ 문제점 & 주의점 ]**

# **[ 새로 알게된 사실 ]**

# **[ 결과 ]**
<img width="1153" alt="스크린샷 2023-05-25 오후 11 42 12" src="https://github.com/nashs789/CodeTest/assets/59809278/3c2e845d-3aa3-4262-a639-3521b3f3e95a">