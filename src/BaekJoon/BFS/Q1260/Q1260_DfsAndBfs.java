package BaekJoon.BFS.Q1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260_DfsAndBfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int nodeCnt = input[0] + 1;
        int connect = input[1];
        int startNode = input[2];
        Graph graph = new Graph(nodeCnt);

        for(int idx = 0; idx < connect; idx++){
            int[] nodeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            graph.linkNode(nodeInfo[0], nodeInfo[1]);
        }

        graph.DFS(startNode);
        System.out.println();
        graph.BFS(startNode);
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

    void linkNode(int x, int y){
        this.adj[x].offer(y);
        this.adj[y].offer(x);
    }

    void DFS(int start){
        boolean[] visited = new boolean[this.nodeCnt];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while(!stack.isEmpty()){
            int curNode = stack.pop();

            if(visited[curNode]){
                continue;
            }

            visited[curNode] = true;
            System.out.print(curNode + " ");

            adj[curNode].sort(Comparator.reverseOrder());
            Iterator<Integer> it = adj[curNode].listIterator();

            while(it.hasNext()){
                int linkedNode = it.next();

                if(!visited[linkedNode]){
                    stack.push(linkedNode);
                }
            }
        }
    }

    void BFS(int start){
        boolean[] visited = new boolean[this.nodeCnt];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            System.out.print(curNode + " ");

            adj[curNode].sort(Comparator.naturalOrder());
            Iterator<Integer> it = adj[curNode].listIterator();

            while(it.hasNext()){
                int linkedNode = it.next();

                if(!visited[linkedNode]){
                    visited[linkedNode] = true;
                    queue.offer(linkedNode);
                }
            }
        }
    }
}
// 23:00