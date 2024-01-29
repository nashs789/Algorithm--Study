# **[ 정보 ]**
1. 소요 시간: 3시간 8분
2. 날짜: 2023.02.03(금)
3. 저자: 이 인복
4. 문제: 토마토

# **[ 문제 설명 ]**  

<img width="1033" alt="스크린샷 2023-02-05 오후 9 04 46" src="https://user-images.githubusercontent.com/59809278/216817730-72554daf-524f-4bb4-837c-ed417c6b0ebe.png">

철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.   
토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.   

<img width="1142" alt="스크린샷 2023-02-05 오후 9 05 49" src="https://user-images.githubusercontent.com/59809278/216817703-627610b1-4ed0-444b-8bf2-7d7efac0b925.png">

창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.  
보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.  
하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.  
대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.  
철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,  
며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.  
단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.


# **[ 입력 ]**  
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다.   
M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M,N ≤ 1,000 이다.  
둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.   
즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.  
하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.  
정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.   
토마토가 하나 이상 있는 경우만 입력으로 주어진다.  

# **[ 출력 ]**   
여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.   
만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,   
토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

# **[ 예제 입력 #1 ]**  
6 4   
0 0 0 0 0 0   
0 0 0 0 0 0   
0 0 0 0 0 0   
0 0 0 0 0 1  

# **[ 예제 출력 #1 ]**  
8

# **[ 예제 입력 #2 ]**  
6 4   
0 -1 0 0 0 0   
-1 0 0 0 0 0   
0 0 0 0 0 0   
0 0 0 0 0 1

# **[ 예제 출력 #2 ]**  
-1

# **[ 예제 입력 #3 ]**  
6 4   
1 -1 0 0 0 0   
0 -1 0 0 0 0   
0 0 0 0 -1 0   
0 0 0 0 -1 1

# **[ 예제 출력 #3 ]**  
6

# **[ 예제 입력 #4 ]**  
6 4   
1 -1 0 0 0 0   
0 -1 0 0 0 0   
0 0 0 0 -1 0   
0 0 0 0 -1 1

# **[ 예제 출력 #4 ]**  
6

# **[ 예제 입력 #5 ]**  
2 2   
1 -1   
-1 1

# **[ 예제 출력 #5 ]**  
0

# **[ 접근 순서 ]**
1. 그래프의 구성
- 그래프는 입력 값이 6 * 4 = 24 라면 각 노드는 0 ~ 23의 번호를 갖는다
- 각 노드는 속성 값으로 '익음' 과 '비어있음' 를 갖는다

2. 각 노드의 연결
- 인접한 상, 하, 좌, 우 노드를 연결한다.

3. BFS 로직 구현
- 로직 실현시 문제에서 제시한 조건인 모두 익지 못하는 조건과 이미 익어있는 경우도 추가한다.

# **[ 문제점 ]**
- 첫 로직의 실패 이유
     - 성공 코드의 tomatoes[] 배열을 기존에는 HashMap 으로 구현 했었는데 입력 값으로 최대 들어오는 사이즈가 1000 * 1000 이다 보니까
       Heap 사이즈 때문에 Memory 가 초과된 것 같다.
        - HashMap 으로 구현은 필수는 아니지만 나에게 더 직관적이기 때문에 이용 했었고, 각 노드는 클래스로 독립적인 객체로 만들어
          객체 지향의 코드를 살리며, 직관 적이게 만들었었다. (아마 class Tomato 를 만들지 않았다면 각 속성들을 1. 0, -1 로 알아봐야 해서
          읽이 어려운 코드가 되었을거라고 생각 한다. ===> 시간과 메모리가 다른 코드에 비해 많이 들어감)
          

- 과립이 고립되어 익지 못하는 케이스를 생각 했는데 고립된 케이스가 아니여도 과일이 익지 않는 케이스가 있었다.


    - 내가 생각한 과일이 고립된 케이스
       -1  
    -1  0  -1   
       -1  


    - 반례 테스트 케이스  
    5 1  
    1 0 -1 0 0


# **[ 새로 알게된 사실 ]**

# **[ 결과 ]**
<img width="1142" alt="스크린샷 2023-02-05 오후 9 04 56" src="https://user-images.githubusercontent.com/59809278/216817718-cd24fe5c-e4a1-472b-b30c-da2ff3522a9f.png">




         