# **[ 정보 ]**
1. 소요 시간: 1시간 48분
2. 날짜: 2023.07.10(월)
3. 저자: 이 인복
4. 난이도: BaekJoon (Silver 1)
5. 분류: Depth First Search
   - Graph Theory
   - Breadth First Search
   - Graph Search
6. 문제: 효율적인 해킹

# **[ 문제 설명 ]**

<img width="1148" alt="스크린샷 2023-07-10 오전 2 36 42" src="https://github.com/nashs789/CodeTest/assets/59809278/d7460dbe-c06b-429c-83ae-98e1d04208fb">

해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다.   
이 회사는 N개의 컴퓨터로 이루어져 있다.   
김지민은 귀찮기 때문에, 한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.

이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.

이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.

# **[ 입력 ]**
- 첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다.  
- 둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다. 
- 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.

# **[ 출력 ]**
- 첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.

# **[ 예제 입력 #1 ]**
      5 4
      3 1
      3 2
      4 3
      5 3

# **[ 예제 출력 #1 ]**
      1 2

# **[ 접근 순서 ]**
1. dfs 노드를 탐색
   - 정점에서 노드를 타고 내려오는 방법으로 알고리즘 진행
      - A -> B 로 그래프를 이어주게 되면 정점부터 탐색하게 되어 정점으로 올 가능성이 있는 노드들을 탐색하게 된다.
      - B -> A 로 그래프를 이어주게 되면 첫 노드 부터 해서 탐색하게 된다.
      - 위 두개의 차이점은 없어 보이는데 감염시킬 수 있는 컴퓨터 개수를 어떻게 제어 하나의 차이
   

# **[ 문제점 & 주의점 ]**
- 초기 제출 했던 시간초과 코드

1. LinkedList -> ArrayList<ArrayList> 로 변경
   - 이유: LinkedList 의 경우 포인터를 사용한 구현 방법을 사용하기 때문에 크기 초기에 정해져 있지 않으며, 주소에 접근하는 Random Access performance
          가 떨어지게 되어 변경
     
2. visited 처리 추가
   - dfs 알고리즘은 오랜만이라...
   - 이거 때문에 같은 노드를 방문하면서 시간이 더 길어진 걸로 보임


      import java.io.BufferedReader;
      import java.io.IOException;
      import java.io.InputStreamReader;
      import java.util.ArrayList;
      import java.util.LinkedList;
      import java.util.List;
      import java.util.PriorityQueue;
      import java.util.StringTokenizer;
      
      public class Main {
          static int N; // 컴퓨터의 수
          static int M; // 신뢰하는 관계의 수
          static List<Integer>[] adj;
          static PriorityQueue<Result> results;
      
          public static void main(String[] args) throws IOException {
              BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              StringTokenizer st = new StringTokenizer(br.readLine());
      
              N = Integer.parseInt(st.nextToken());
              M = Integer.parseInt(st.nextToken());
              adj = new List[N + 1];
      
              for (int i = 1; i <= N; i++) {
                  adj[i] = new ArrayList<>();
              }
      
              for (int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  int A = Integer.parseInt(st.nextToken());
                  int B = Integer.parseInt(st.nextToken());
                  adj[B].add(A);
              }
      
              results = new PriorityQueue<>();
      
              for (int i = 1; i <= N; i++) {
                  results.add(dfs(i));
              }
      
              int max = results.peek().com;
      
              StringBuilder sb = new StringBuilder();
              while (!results.isEmpty() && results.peek().com == max) {
                  Result r = results.poll();
                  sb.append(r.num).append(' ');
              }
      
              System.out.println(sb);
          }
      
          public static Result dfs(int num) {
              boolean[] visited = new boolean[N + 1];
              visited[num] = true;
              int com = 0;
      
              for (int next : adj[num]) {
                  if (!visited[next]) {
                      visited[next] = true;
                      com += dfs(next).com;
                  }
              }
      
              return new Result(num, com + 1);
          }
      }
      
      class Result implements Comparable<Result> {
      int num; // 컴퓨터의 번호
      int com; // 해킹한 컴퓨터의 개수
      
          public Result(int num, int com) {
              this.num = num;
              this.com = com;
          }
      
          @Override
          public int compareTo(Result other) {
              if (this.com == other.com) {
                  return Integer.compare(this.num, other.num);
              }
              return Integer.compare(other.com, this.com);
          }
      }

# **[ 새로 알게된 사실 ]**

# **[ 결과 ]**
<img width="1148" alt="스크린샷 2023-07-10 오전 2 36 35" src="https://github.com/nashs789/CodeTest/assets/59809278/e461689c-ddfe-4e6d-90bb-184ba1133fad">
