package BaekJoon.DfsAndBfs.Q10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q10026_RedGreenColourWeakness {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nodes = new String[N * N];
        String[] nodes2 = new String[N * N];

        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split("");

            for(int j = 0; j < N; j++){
                nodes[i * N + j] = line[j];
                // R -> G, G -> G, B -> B 적록색약 적용
                nodes2[i * N + j] = line[j].equals("R") ? "G" : (line[j].equals("G") ? "G" : "B");
            }
        }

        Graph graph = new Graph(N * N);

        graph.linkNode(N);
        graph.BFS(nodes);
        graph.BFS(nodes2);
    }
}

class Graph{
    private int nodeCnt;
    private LinkedList<Integer>[] adj;

    Graph(int nodeCnt){
        this.nodeCnt = nodeCnt;
        adj = new LinkedList[nodeCnt];

        for(int idx = 0; idx < nodeCnt; idx++){
            adj[idx] = new LinkedList<>();
        }
    }

    void linkNode(int N){
        for(int idx = 0; idx < nodeCnt; idx++){
            // 상
            if(idx - N >= 0){
                this.adj[idx].offer(idx - N);
            }

            // 하
            if(idx + N < this.nodeCnt){
                this.adj[idx].offer(idx + N);
            }

            // 좌
            if((idx + 1) % N != 0 && idx + 1 < this.nodeCnt){
                this.adj[idx].offer(idx + 1);
            }

            // 우
            if(idx - 1 >= 0 && idx % N != 0){
                this.adj[idx].offer(idx - 1);
            }
        }
    }

    void BFS(String[] nodes){
        boolean[] visited = new boolean[this.nodeCnt];
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;

        for(int idx = 0; idx < this.nodeCnt; idx++){
            if(visited[idx]){
                continue;
            }

            visited[idx] = true;
            queue.offer(idx);

            while(!queue.isEmpty()){
                int curNode = queue.poll();

                Iterator<Integer> it = adj[curNode].listIterator();

                while(it.hasNext()){
                    int linkNode = it.next();

                    if(!visited[linkNode] && nodes[curNode].equals(nodes[linkNode])){
                        queue.offer(linkNode);
                        visited[linkNode] = true;
                    }
                }
            }

            answer++;
        }

        System.out.print(answer + " ");
    }
}