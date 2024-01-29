# **[ 정보 ]**
1. 소요 시간: 1시간 3분
2. 날짜: 2023.06.07(수)
3. 저자: 이 인복
4. 난이도: BaekJoon (Silver 1)
5. 분류: Tree
   - Recursive
6. 문제: 트리 순회

# **[ 문제 설명 ]**

<img width="1148" alt="스크린샷 2023-06-07 오전 12 53 47" src="https://github.com/nashs789/CodeTest/assets/59809278/ee2c75b3-27df-4047-ae90-f21170a6c201">

이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.

<img width="1148" alt="스크린샷 2023-06-07 오전 12 53 50" src="https://github.com/nashs789/CodeTest/assets/59809278/5236a0e1-489d-433f-8db9-715cb70013b4">

예를 들어 위와 같은 이진 트리가 입력되면,

- 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
- 중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
- 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
가 된다.

# **[ 입력 ]**
- 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다.   
- 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.   
- 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다.   
- 자식 노드가 없는 경우에는 .으로 표현한다.

# **[ 출력 ]**
- 첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다.   
- 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.

# **[ 예제 입력 #1 ]**
      7
      A B C
      B D .
      C E F
      E . .
      F . G
      D . .
      G . .

# **[ 예제 출력 #1 ]**
      ABDCEFG
      DBAECFG
      DBEGFCA

# **[ 접근 순서 ]**
1. 트리를 구성
   - 루트 노드(Root Node)를 베이스로 재귀함수를 통해 트리를 구성한다.
      - 루트 노드 케이스: left, right 에 바로 삽입
      - 로트 노드 x 케이스: 현재 노드에서 left 와 right 를 베이스로 계속해서 탐색해서 해당 노드가 나올때까지 반복
   
2. 전위 순회 (Preorder Traversal)
   - 항상 루트노드를 먼저 탐색하며 left, right 탐색 이전에 parent 노드를 탐색한다
   - parent(root) -> left -> right
   
3. 중위 순회 (InOrder Traversal)
   - left 노드가 항상 먼저 이며 후에 parent 노드를 탐색한다.
   - left -> parent(root) -> right
   
3. 후위 순회 (PostOrder Traversal)
   - left 노드가 항상 먼저이며 후에 right 노드를 탐색한다.
   - left -> right -> parent(root)

# **[ 문제점 & 주의점 ]**

# **[ 새로 알게된 사실 ]**
1. 트리 구현하는 알고리즘 문제는 이번에 접한게 처음이라 다른 사람의 코드를 참고해서 풀었다.
   - 여러번 풀어야 내 것으로 만드는게 가능할듯... (순회 자체는 쉬우나 트리 구성이 쉽지 않았음 -> 첨이라)

# **[ 결과 ]**
<img width="1148" alt="스크린샷 2023-06-07 오전 12 53 57" src="https://github.com/nashs789/CodeTest/assets/59809278/7af1e908-4510-429b-b890-a730773e0a04">
