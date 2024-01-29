package BaekJoon.DfsAndBfs.Q11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11725_SearchParentsOfTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCnt = Integer.parseInt(br.readLine()) + 1;
        Graph graph = new Graph(nodeCnt);

        for(int idx = 1; idx < nodeCnt - 1; idx++){
            int[] nodeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.linkNode(nodeInfo[0], nodeInfo[1]);
        }

        graph.BFS();
    }
}

class Graph{
    private int nodeCnt;
    private LinkedList<Integer>[] adj;

    Graph(int nodeCnt){
        this.nodeCnt = nodeCnt;
        this.adj = new LinkedList[nodeCnt];

        for(int idx = 1; idx < this.nodeCnt; idx++){
            this.adj[idx] = new LinkedList<>();
        }
    }

    void linkNode(int str, int end){
        this.adj[str].offer(end);
        this.adj[end].offer(str);
    }

    void BFS(){
        boolean[] visited = new boolean[this.nodeCnt];
        Queue<Integer> queue = new LinkedList<>();
        int[] rootNodeArr = new int[this.nodeCnt];

        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int curNode = queue.poll();

            Iterator<Integer> it = this.adj[curNode].listIterator();

            while(it.hasNext()){
                int linkedNode = it.next();

                if(!visited[linkedNode]){
                    rootNodeArr[linkedNode] = curNode;
                    queue.offer(linkedNode);
                    visited[linkedNode] = true;
                }
            }
        }

        for(int idx = 2; idx < this.nodeCnt; idx++){
            System.out.println(rootNodeArr[idx]);
        }
    }
}

// 16:36 - 17:25 : 시간초과 (49분)
// 17:25 - 17:50 : 시간초과 (25분)
// 원인 분석 결과(주관적인 분석): BFS 탐색 로직이 너무 많이 돈다.... 기준 노드에 연결된 모든 노드를 시작 노드로 두고 탐색하니
// 1번 로직 동작할걸 만약 4개의 노드가 연결되어 있다면 4번 하게되니까 문제가 생기는 듯 보인다(input volume이 커서 생기는 문제처럼 보임)

// 19:34 - 19:49 : 시간초과 (15분)
// 20:43 - 20:47 : 통과 (4분)