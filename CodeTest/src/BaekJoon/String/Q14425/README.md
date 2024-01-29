# **[ 정보 ]**
1. 소요 시간: 6분
2. 날짜: 2023.02.24(금)
3. 저자: 이 인복
4. 난이도: 실버 3
5. 분류: 문자열
6. 문제: 문자열 집합

# **[ 문제 설명 ]**

<img width="1147" alt="스크린샷 2023-02-24 오전 12 32 15" src="https://user-images.githubusercontent.com/59809278/220954417-dd6bc460-e201-4a3d-aadf-d99497f0b20c.png">

총 N개의 문자열로 이루어진 집합 S가 주어진다.

입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.

# **[ 입력 ]**
첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.   
다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.   
다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.   
입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다.  
집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.

# **[ 출력 ]**
첫째 줄에 M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력한다.

# **[ 예제 입력 #1 ]**
    5 11
    baekjoononlinejudge
    startlink
    codeplus
    sundaycoding
    codingsh
    baekjoon
    codeplus
    codeminus
    startlink
    starlink
    sundaycoding
    codingsh
    codinghs
    sondaycoding
    startrink
    icerink

# **[ 예제 출력 #1 ]**
    4 

# **[ 접근 순서 ]**
- 해시 이용

# **[ 문제점 ]**

# **[ 새로 알게된 사실 ]**

# **[ 결과 ]**
<img width="1147" alt="스크린샷 2023-02-24 오전 12 32 24" src="https://user-images.githubusercontent.com/59809278/220954451-934b57b6-5b52-4a9d-99fb-d1cfbe6bed68.png">
