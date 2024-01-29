# **[ 정보 ]**
1. 소요 시간: 45분
2. 날짜: 2023.04.07(금)
3. 저자: 이 인복
4. 난이도: BaekJoon (Silver 4)
5. 분류: Brute Force
6. 문제: 체스판 다시 칠하기

# **[ 문제 설명 ]**
<img width="1148" alt="스크린샷 2023-04-07 오전 1 22 49" src="https://user-images.githubusercontent.com/59809278/230439112-1dcb6ac3-72b3-4490-bcbd-c89d5567b2b1.png">

지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.  
어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.  
지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.

체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.   
구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.  
따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다.  
하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.

보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.   
당연히 8*8 크기는 아무데서나 골라도 된다.  
지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

# **[ 입력 ]**
첫째 줄에 N과 M이 주어진다.   
N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다.   
둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다.   
B는 검은색이며, W는 흰색이다.

# **[ 출력 ]**
첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.

# **[ 예제 입력 #1 ]**
    8 8
    WBWBWBWB
    BWBWBWBW
    WBWBWBWB
    BWBBBWBW
    WBWBWBWB
    BWBWBWBW
    WBWBWBWB
    BWBWBWBW

# **[ 예제 출력 #1 ]**
    1 

# **[ 예제 입력 #2 ]**
    10 13
    BBBBBBBBWBWBW
    BBBBBBBBBWBWB
    BBBBBBBBWBWBW
    BBBBBBBBBWBWB
    BBBBBBBBWBWBW
    BBBBBBBBBWBWB
    BBBBBBBBWBWBW
    BBBBBBBBBWBWB
    WWWWWWWWWWBWB
    WWWWWWWWWWBWB

# **[ 예제 출력 #2 ]**
    12

# **[ 예제 입력 #3 ]**
    8 8
    BWBWBWBW
    WBWBWBWB
    BWBWBWBW
    WBWBWBWB
    BWBWBWBW
    WBWBWBWB
    BWBWBWBW
    WBWBWBWB

# **[ 예제 출력 #3 ]**
    0

# **[ 예제 입력 #4 ]**
    9 23
    BBBBBBBBBBBBBBBBBBBBBBB
    BBBBBBBBBBBBBBBBBBBBBBB
    BBBBBBBBBBBBBBBBBBBBBBB
    BBBBBBBBBBBBBBBBBBBBBBB
    BBBBBBBBBBBBBBBBBBBBBBB
    BBBBBBBBBBBBBBBBBBBBBBB
    BBBBBBBBBBBBBBBBBBBBBBB
    BBBBBBBBBBBBBBBBBBBBBBB
    BBBBBBBBBBBBBBBBBBBBBBW

# **[ 예제 출력 #4 ]**
    31

# **[ 예제 입력 #5 ]**
    10 10
    BBBBBBBBBB
    BBWBWBWBWB
    BWBWBWBWBB
    BBWBWBWBWB
    BWBWBWBWBB
    BBWBWBWBWB
    BWBWBWBWBB
    BBWBWBWBWB
    BWBWBWBWBB
    BBBBBBBBBB

# **[ 예제 출력 #5 ]**
    0

# **[ 예제 입력 #6 ]**
    8 8
    WBWBWBWB
    BWBWBWBW
    WBWBWBWB
    BWBBBWBW
    WBWBWBWB
    BWBWBWBW
    WBWBWWWB
    BWBWBWBW

# **[ 예제 출력 #6 ]**
    2 

# **[ 예제 입력 #7 ]**
    11 12
    BWWBWWBWWBWW
    BWWBWBBWWBWW
    WBWWBWBBWWBW
    BWWBWBBWWBWW
    WBWWBWBBWWBW
    BWWBWBBWWBWW
    WBWWBWBBWWBW
    BWWBWBWWWBWW
    WBWWBWBBWWBW
    BWWBWBBWWBWW
    WBWWBWBBWWBW

# **[ 예제 출력 #7 ]**
    15

# **[ 접근 순서 ]**
1. 검수해야 하는 체스판의 사이즈는 8 * 8 이다.
    - 어떤 사이즈의 판이 들어와도 최소값의 결과를 만들어 내는건 8 * 8 사이즈 체스판이다.


2. 맨 위 좌측 상단이 W(백색), B(흑색) 두 가지 가능성을 가진 체스판이 있다.
    - 한 개의 체스판에는 2번의 검수가 필요하다.


3. 새로운 체스판을 만들 때에 인덱스 잘 체크 할것.
    - 가지고 있는 판은 N * M 으로 8 ~ 50까지의 수를 갖기 때문에 그 안에서 8 * 8 사이즈 체스판을 만들어야 한다.

# **[ 문제점 ]**
1. 탐색으로 풀게 될 경우
    - 탐색할 인덱스에 대한 제한 조건을 만들어야 해서 더 복잡해질듯 싶다.
  
2. 매번 새로운 8 * 8을 구성하는 것 (연산 횟수가 많아짐)
    - 전체 판을 가지고 연산하는 방법이 있을거 같지만 제한 조건이 복잡할 것 같아서 포기

# **[ 새로 알게된 사실 ]**

# **[ 결과 ]**
<img width="1148" alt="스크린샷 2023-04-07 오전 1 22 56" src="https://user-images.githubusercontent.com/59809278/230439142-3fc0636c-25cd-4a7f-84b4-1cd4d7c837fb.png">

