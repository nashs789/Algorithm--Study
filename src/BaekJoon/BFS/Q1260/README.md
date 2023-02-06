# **[ 정보 ]**
1. 소요 시간: 44분
2. 날짜: 2023.02.05(일)
3. 저자: 이 인복
4. 문제: DFS와 BFS

# **[ 문제 설명 ]**

<img width="1157" alt="스크린샷 2023-02-05 오후 11 45 39" src="https://user-images.githubusercontent.com/59809278/216826377-983be01a-94f9-46ba-856e-c5949a03ba0f.png">

그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.  
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,  
더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

# **[ 입력 ]**
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.  
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.   
어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.   
입력으로 주어지는 간선은 양방향이다.

# **[ 출력 ]**
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.  
V부터 방문된 점을 순서대로 출력하면 된다.

# **[ 예제 입력 #1 ]**  
4 5 1   
1 2   
1 3   
1 4   
2 4   
3 4

# **[ 예제 출력 #1 ]**  
1 2 4 3   
1 2 3 4

# **[ 예제 입력 #2 ]**  
5 5 3   
5 4   
5 2   
1 2   
3 4   
3 1

# **[ 예제 출력 #2 ]**
3 1 2 5 4   
3 1 4 2 5

# **[ 예제 입력 #3 ]**
1000 1 1000   
999 1000

# **[ 예제 출력 #3 ]**
1000 999   
1000 999

# **[ 접근 순서 ]**
1. 기본 DFS && 기본 BFS

# **[ 문제점 ]**
- DFS 로직 변경 
    - 이유: 기존 코드는 stack 에서 idx 를 가지고 요소를 조작하기 때문에 요소를 재구성 하는데 
           코스트 소모가 될거라고 생각했다. 


      [ 변경 전 로직]
      void DFS(int start){
          boolean[] visited = new boolean[this.nodeCnt];
          Stack<Integer> stack = new Stack<>();
    
            visited[start] = true;
            stack.push(start);
    
            while(!stack.isEmpty()){
                int curNode = stack.pop();
                System.out.print(curNode + " ");
    
                adj[curNode].sort(Comparator.reverseOrder());
                Iterator<Integer> it = adj[curNode].listIterator();
    
                while(it.hasNext()){
                    int linkedNode = it.next();
    
                    if(stack.contains(linkedNode)){
                        stack.remove(stack.size() - stack.search(linkedNode));
                        stack.push(linkedNode);
                    }
    
                    if(!visited[linkedNode]){
                        visited[linkedNode] = true;
                        stack.push(linkedNode);
                    }
                }
            }
      }

# **[ 새로 알게된 사실 ]**

# **[ 결과 ]**
<img width="1142" alt="스크린샷 2023-02-05 오후 11 45 28" src="https://user-images.githubusercontent.com/59809278/216826371-642c302a-c1dd-434f-88ac-369d77ea05cf.png">




         
