# **[ 정보 ]**
1. 소요 시간: 시간 측정 불가(오랜시간 풀었음... 힌트도 봄)
2. 날짜: 2023.05.13(화) ===> 최초 도전: 2023.02.14
3. 저자: 이 인복
4. 난이도: BaekJoon (Gold 3)
5. 분류: BFS
6. 문제: 벽 부수고 이동하기

# **[ 문제 설명 ]**
N×M의 행렬로 표현되는 맵이 있다.   
맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다.   
당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다.   
최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.

한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

# **[ 입력 ]**
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다.   
다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.

# **[ 출력 ]**
첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.

# **[ 예제 입력 #1 ]**
    6 4
    0100
    1110
    1000
    0000
    0111
    0000

# **[ 예제 출력 #1 ]**
    15

# **[ 예제 입력 #2 ]**
    4 4
    0111
    1111
    1111
    1110

# **[ 예제 출력 #2 ]**
    -1

# **[ 접근 순서 ]**
1. 벽을 부수고 이동하는 줄기 && 벽을 부수지 않고 이동하는 줄기
   - 3 차원 배열 visited 만들어서 
      - ex) visited[x][y][0]: 벽을 부수지 않음
      - ex) visited[x][y][1]: 벽을 이미 부쉈음
   - 이유: 벽을 부수고 간 줄기가 부수지 않은 줄기보다 빠를순 있지만 목표까지 도달한다는 보장이 없음
   

# **[ 문제점 & 주의점 ]**
   
       [ 초기코드 ] - 반례는 전부 통과하지만 탐색하는 줄기가 많이 나오기 때문에 메모리가 초과되는 코드
       public class Q2206_BreakTheWallAndMove {
   
             public static boolean[][] map;
             public static boolean[][] visited;
             public static boolean[][] mapInfo;
             public static int row;
             public static int col;
             public static int[][] moveInfo = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
      
          public static void main(String[] args) throws IOException {
              BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              int[] sizeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
              row = sizeInfo[0];
              col = sizeInfo[1];
              Node.col = col;
              Node.row = row;
              map = new boolean[row][col];
              visited = new boolean[row][col];
              mapInfo = new boolean[row][col];
      
              for(int i = 0; i < row; i++){
                  int[] wallInfo = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
      
                  for(int j = 0; j < col; j++){
                      map[i][j] = wallInfo[j] == 0 ? true : false;
                  }
              }
      
              bfs();
          }
      
          private static void bfs(){
              Queue<Node> queue = new LinkedList<>();
              int answer = 0;
              Node firstNode = new Node(0, 0, 1, false);
      
              queue.add(firstNode);
              visited[0][0] = true;
              mapInfo[0][0] = firstNode.broke;
      
              Loop:
              while(!queue.isEmpty()){
                  Node curNode = queue.poll();
      
                  System.out.println("curNode === > " + curNode.x + "    " + curNode.y + "    cnt: " + curNode.cnt + "    broke: " + curNode.broke);
      
                  // 상, 하, 좌, 우 이동
                  for(int idx = 0; idx < 4; idx++){
                      int x = curNode.x + moveInfo[idx][0];
                      int y = curNode.y + moveInfo[idx][1];
      
                      // 방문한 좌표인지 확인
                      if(curNode.move(x, y)){
                          // 방문 안했던 좌표
                          if(!visited[x][y]){
                              // 벽 && 부수기 가능
                              if(!map[x][y] && !curNode.broke){
                                  queue.add(new Node(x, y, curNode.cnt + 1,true));
                                  visited[x][y] = true;
                              }
                              // 벽이 아님
                              if(map[x][y]){
                                  queue.add(new Node(x, y, curNode.cnt + 1, curNode.broke));
                                  visited[x][y] = true;
                              }
      
                              mapInfo[x][y] = curNode.broke;
                          } else {    // 방문 했던 좌표
                              // 벽을 부셨던 노드가 지나간 흔적 && 내가 부실 수 있는 기회가 있다면
                              if(mapInfo[x][y] && !curNode.broke){
                                  queue.add(new Node(x, y, curNode.cnt + 1, !map[x][y]));
                              }
                          }
      
                          if(x == row - 1 && y == col - 1){
                              answer = curNode.cnt + 1;
                              break Loop;
                          }
                      }
                  }
              }
      
              System.out.println(answer == 0 ? -1 : answer);
          }
       } 

       public boolean move(int x, int y){
         if(x < 0 || x >= row || y < 0 || y >= col){
             return false;
         }
   
           return true;
       }
    }

# **[ 새로 알게된 사실 ]**
1. 반례 모음집
    - https://www.acmicpc.net/board/view/66299
    - 위 url 에서 첫 번쨰 반례가 중요

# **[ 결과 ]**

