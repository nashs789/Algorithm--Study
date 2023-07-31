# ** [ 07월 23일 (일) 기록 ] **
- 인원: 4명
- 장소: 구로 홀릭스터디카페
- 시간: 10:00 - 13:00

# ** [ To - DO ] **
- 다음주 세미발표: (스터디원들과 공유)
    - 발표자: 박재우님
    - 발표내용: 누적합
    - 7/30 구로 홀릭스터디카페

- 과제: DP (Dynamic Programming)
    - URL: 
      1. [Q9095  - 1,2,3 더하기 (Silver 3)](https://www.acmicpc.net/problem/9095)
      2. [Q2579  - 계단오르기 (Silver 3)](https://www.acmicpc.net/problem/2579)
      3. [Q2502  - 떡 먹는 호랑이 (Silver 1)](https://www.acmicpc.net/problem/2502)
      4. [Q12865 - 평범한 배낭 (Gold 5)](https://www.acmicpc.net/problem/12865)

# ** [ 건의/공지 사항 ] **
1. 추가 인원모집
    인복님: 2명정도 예상
2. 맴버 깃허브 링크
3. 휴가 날짜 공유
    - 홍희표님: 8월 첫째주

# ** [ 발표 내용 ] **

# BFS(Breadth First Search)

하나의 정점을 시작으로 차례로 모든 정점을 탐색하는 알고리즘

# [ 특징 ]

1. Queue 를 사용한 코드가 주로 사용된다.
    - FIFO (First In First Out) 선입 선출 방식의 콜렉션
    - 자기 자신과 이어진 모든 노드를 탐색하는게 우선이 되는 알고리즘
    - Queue 에 더 이상 노드가 존재하지 않는 시점이 BFS 종료 시점


2. 방문한 노드를 방문 처리 해준다.
    - visited 처리를 해줌으로써 이미 방문한 노드를 방문하지 않도록 처리하여 무한 루프를 방지한다.
        - 주어진 문제의 요구 사항에 따라서 충분히 변할 수 있다.
    

3. Tracing 이 힘들다(추적이 힘들다)
    - DFS 의 경우 Depth 를 타고 내려가기 때문에 한 번의 탐색이 끝나면 그 경로가 추적이 가능
    - BFS 의 경우 인접한 노드를 전부 탐색하기 때문에 탐색이 끝나면 그 경로가 추적이 불가능(가능 하지만 상당히 쉽지 않음)


4. 최단거리 탐색에 적합한 알고리즘
    - DFS 의 경우 한 경로의 Depth 가 깊은 경우 해당 경로에 있어서 탐색이 길어져서 다른 경로 탐색까지의 시간이 오래 걸릴 수 있다.
    - BFS 의 경우 인접 노드들을 전부 확인하기 때문에 케이스에 따라서 DFS 보다 느릴 수 있지만 최단 경로에 훨씬 적합한 알고리즘(최단 거리에 있어 평균치가 월등함)
    
# [ 그림 ]
- 그래프로 보는 BFS

[ DFS ]

![왼쪽 노드 우선탐색(전제조건)](https://github.com/nashs789/CodeTest/assets/59809278/db94554a-36ff-4179-8c33-06773d59b34c)

    순서: A -> B -> D -> H -> I -> J -> E -> C -> F -> K -> G -> L -> M

[ BFS ]

![왼쪽노드 우선 탐색(전제조건)](https://github.com/nashs789/CodeTest/assets/59809278/18a850e2-01ae-45d5-84f5-e64ce3d03c66)

    순서: A -> B -> C -> D -> E -> F -> G -> H -> I -> J -> K -> L -> M

- 0 과 1로된 좌표상 BFS 

[ DFS ]

<img width="578" alt="스크린샷 2023-07-11 오전 1 44 09" src="https://github.com/nashs789/CodeTest/assets/59809278/55bda845-d1b0-4c12-98c7-40063ada5482">

    순서1 - 파랑색): 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12 -> 13 (최악의 케이스)
    순서2 - 빨간색): 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 (최단 거리 케이스)

결론: DFS 로는 최단 거리를 구할 수 있지만 그에 대한 비용이 예측이 불가능 하며 주어진 시간내에 해결하지 못하는 케이스에 걸려 시간초과를 겪을 수 있다.
        

[ BFS ]

<img width="578" alt="스크린샷 2023-07-11 오전 1 46 45" src="https://github.com/nashs789/CodeTest/assets/59809278/cc575f31-ed77-494a-b093-c747fb16c3ee">

    순서1 - 파랑색): 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 (최악의 케이스)
    순서2 - 빨간색): 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 (최단 거리 케이스)

결론: BFS 는 모든 노드를 탐색하기 때문에 느려 보일 수 있으나 최단거리 구하기에는 적합한 알고리즘
단점: 그림에서는 갈래가 2개이지만 상, 하, 좌, 우 + 대각선 이라면 갈래가 8개로 갈리기 때문에 추적이 거의 불가능하다.  
(8갈래 -> 8갈래 * 8갈래(64갈래) -> 8갈래 * 8갈래 * 8갈래(512갈래))

# [ 소스 코드 (그래프) - 2606(바이러스)]
- url: https://www.acmicpc.net/problem/2606
- linkNode 메소드를 통해서 양방향 그래프 구성
- 시작점 1 (출발지점)

``` Java
public class Q2606_Virus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCnt = Integer.parseInt(br.readLine());
        int linkedCnt = Integer.parseInt(br.readLine());
        Graph graph = new Graph(nodeCnt + 1);

        for(int idx = 0; idx < linkedCnt; idx++){
            String[] input = br.readLine().split(" ");
            graph.linkNode(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        graph.BFS(1);
        System.out.println(graph.getAnswer());
    }
}

class Graph{
    private int nodeCnt;
    private LinkedList<Integer> adjNodeList[];
    private int answer = -1;

    Graph(int cnt){
        nodeCnt = cnt;
        adjNodeList = new LinkedList[cnt];

        for(int idx = 1; idx < cnt; idx++){
            adjNodeList[idx] = new LinkedList<>();
        }
    }

    // 양쪽 노드 이어주는 함수
    void linkNode(int x, int y){
        adjNodeList[x].offer(y);
        adjNodeList[y].offer(x);
    }

    void BFS(int start){
        boolean visited[] = new boolean[nodeCnt + 1];
        Queue<Integer> queue = new LinkedList();

        visited[start] = true;
        queue.offer(start);

        while(queue.size() != 0){
            int node = queue.poll();
            answer++;

            Iterator<Integer> it = adjNodeList[node].listIterator();
            while(it.hasNext()){
                int linkedNode = it.next();

                if(!visited[linkedNode]){
                    visited[linkedNode] = true;
                    queue.offer(linkedNode);
                }
            }
        }
    }

    int getAnswer(){
        return answer;
    }
}
```

# [ 소스 코드 (좌표) - 프로그래머스 Lv2 게임맵 최단거리 ]
- url: https://school.programmers.co.kr/learn/courses/30/lessons/1844
- 좌표상에서 상, 하, 좌, 우 움직이는 시뮬레이션 코드
- 목표 좌표에 도달시 현재까지의 거리 값 리턴
- 좌표가 유효한 좌표인지 확인 해줘야 배열 인덱스 값을 넘어가지 않음

``` Java
public class Q3_gameMapShortestDistance_sol2 {

    public static int n;
    public static int m;
    public static boolean[][] visited;
    public static int[][] maps;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        maps = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Node2> queue = new LinkedList<>();

        queue.add(new Node2(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node2 curNode = queue.poll();

            if(curNode.x == n - 1 && curNode.y == m - 1){
                return curNode.dist;
            }

            for(int moveIdx = 0; moveIdx < 4; moveIdx++){
                int newX = curNode.x + move[moveIdx][0];
                int newY = curNode.y + move[moveIdx][1];

                if(isValidCoord(newX, newY) && maps[newX][newY] == 1 && !visited[newX][newY]){
                    queue.add(new Node2(newX, newY, curNode.dist + 1));
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }

    public static boolean isValidCoord(int newX, int newY) {
        if(newX < 0 || newX >= n || newY < 0 || newY >= m){
            return false;
        }

        return true;
    }
}

class Node2{
    int x;
    int y;
    int dist;

    public Node2(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
```


