package BaekJoon.DfsAndBfs.Q1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q1697_HideAndSeek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] loc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = loc[0];
        int K = loc[1];
        Graph graph = new Graph(100001);

        for(int idx = 0; idx <= 100000; idx++){
            if(idx + 1 <= 100000){
                graph.linkNode(idx,idx + 1);
            }

            if(idx - 1 >= 0){
                graph.linkNode(idx,idx - 1);
            }

            if(idx * 2 <= 100000){
                graph.linkNode(idx,idx * 2);
            }
        }

        graph.BFS(N, K);
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

    void linkNode(int nodeX, int nodeY){
        this.adj[nodeX].offer(nodeY);
    }

    void BFS(int start, int end){
        boolean[] visited = new boolean[this.nodeCnt];
        int[] distance = new int[this.nodeCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int curNode = queue.poll();

            if(curNode == end){
                System.out.print(distance[curNode]);
                break;
            }

            Iterator<Integer> it = this.adj[curNode].listIterator();

            while(it.hasNext()){
                int linkedNode = it.next();

                if(!visited[linkedNode]){
                    visited[linkedNode] = true;
                    queue.offer(linkedNode);
                    distance[linkedNode] = distance[curNode] + 1;
                }
            }
        }
    }
}