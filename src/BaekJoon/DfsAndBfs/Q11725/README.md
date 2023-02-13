# **[ 정보 ]**
1. 소요 시간: 1시간 33분
   - 49분: 시간초과
   - 25분: 시간초과
   - 15분: 시간초과
   - 4분:  통과
2. 날짜: 2023.02.13(월)
3. 저자: 이 인복
4. 문제: 트리의 부모 찾기

# **[ 문제 설명 ]**
루트 없는 트리가 주어진다.  
이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

# **[ 입력 ]**
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다.  
둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

# **[ 출력 ]**
첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.

# **[ 예제 입력 #1 ]**
    7
    1 6
    6 3
    3 5
    4 1
    2 4
    4 7

# **[ 예제 출력 #1 ]**
    4
    6
    1
    3
    1
    4

# **[ 예제 입력 #2 ]**
    12
    1 2
    1 3
    2 4
    3 5
    3 6
    4 7
    4 8
    5 9
    5 10
    6 11
    6 12

# **[ 예제 출력 #2 ]**
    1
    1
    2
    3
    3
    4
    4
    5
    5
    6
    6

# **[ 접근 순서 ]**
- DFS or BFS 둘 다 괜찮아 보이는 문제

# **[ 문제점 & 주의점 ]**
- 첫 번째와 두 번쨰 시도 실패의 주관적인 원인 분석:
    - Root 노드를 시작점으로 잡지 않고, 순차적으로 노드를 시작점으로 잡고 인접 노드를 기점으로 BFS 로직을 시행 하면서
      BFS 로직이 한 번이 아닌 인접 노드의 갯수만큼 돌게됨
    - 로직 구현의 이유: Root 를 시작점으로 잡을 생각을 못해서 시작 노드 선정 방법이 필요함
        

- 세 번째 시도 주관적인 실패 원인 분석: 
    - 인접한 노드를 기점으로 BFS 노드 로직이 돌 때 시작 노드를 저장 했다가 Root 노드 도달 시 저장했던 시작 노드 출력
    - 여전히 많은 로직 수행이 필요함 O(N^2) 의 시간 복잡도로 보이는데 정답 코드는 O(N) 으로 해결이 가능하니 성능의 차이가
      많이 날 수 밖에 없음


        [ 3번쨰 시도 로직 ]
        void BFS(){
            boolean[] visited = new boolean[this.nodeCnt];
            int[] nodeNumber = new int[this.nodeCnt];
            Queue<Integer> queue = new LinkedList<>();
      
            for(int idx = 2; idx < this.nodeCnt; idx++){
                queue.offer(idx);
                visited[idx] = true;
      
                while(!queue.isEmpty()){
                    int curNode = queue.poll();
      
                    if(curNode == 1){
                        System.out.println(nodeNumber[curNode]);
                        break;
                    }
      
                    Iterator<Integer> it = this.adj[curNode].listIterator();
      
                    while(it.hasNext()){
                        int linkedNode = it.next();
      
                        if(!visited[linkedNode]){
                            queue.offer(linkedNode);
                            visited[linkedNode] = true;
                            if(idx == curNode){
                                nodeNumber[linkedNode] = linkedNode;
                            } else {
                                nodeNumber[linkedNode] = nodeNumber[curNode];
                            }
                        }
                    }
                }
                visited = new boolean[this.nodeCnt];
                nodeNumber = new int[this.nodeCnt];
                queue.clear();
            }
        }
    
# **[ 새로 알게된 사실 ]**

# **[ 결과 ]**
