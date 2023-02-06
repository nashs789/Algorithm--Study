package BaekJoon.BFS.Q11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11724_ConnectCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = input[0];
        int M = input[1];
        Graph graph = new Graph(N + 1);

        for(int idx = 0; idx < M; idx++){
            int[] nodeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            graph.linkNode(nodeInfo[0], nodeInfo[1]);
        }

        graph.BFS();
        graph.DFS();
    }
}

class Graph{
    private int nodeCnt;
    private LinkedList<Integer>[] adj;

    Graph(int nodeCnt){
        this.nodeCnt = nodeCnt;
        this.adj = new LinkedList[nodeCnt];

        for(int idx = 0; idx < nodeCnt; idx++){
            this.adj[idx] = new LinkedList<>();
        }
    }

    void linkNode(int u, int v){
        this.adj[u].offer(v);
        this.adj[v].offer(u);
    }

    void DFS(){
        boolean[] visited = new boolean[this.nodeCnt];
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int idx = 1; idx < this.nodeCnt; idx++) { // 0번 노드는 없기 때문에 1부터 시작
            if(visited[idx]){
                continue;
            }

            answer++;
            visited[idx] = true;
            stack.push(idx);

            while(!stack.isEmpty()){
                int curNode = stack.pop();

                Iterator<Integer> it = adj[curNode].listIterator();

                while(it.hasNext()){
                    int linkedNode = it.next();

                    if(!visited[linkedNode]){
                        visited[linkedNode] = true;
                        stack.push(linkedNode);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    void BFS(){
        boolean[] visited = new boolean[this.nodeCnt];
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;

        for(int idx = 1; idx < this.nodeCnt; idx++){ // 0번 노드는 없기 때문에 1부터 시작
            if(visited[idx]){
                continue;
            }

            answer++;
            visited[idx] = true;
            queue.offer(idx);

            while(!queue.isEmpty()){
                int curNode = queue.poll();

                Iterator<Integer> it = adj[curNode].listIterator();

                while (it.hasNext()){
                    int linkedNode = it.next();

                    if(!visited[linkedNode]){
                        visited[linkedNode] = true;
                        queue.offer(linkedNode);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}