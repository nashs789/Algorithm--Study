package BaekJoon.DfsAndBfs.Q2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2468_SafeArea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] area = new int[N * N];
        int max = 0;

        for(int i = 0; i < N; i++){
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int j = 0; j < N; j++){
                int idx = i * N + j;

                area[idx] = in[j];
                if(max < in[j]){
                    max = in[j];
                }
            }
        }
        Graph graph = new Graph(N * N);
        graph.linkNode(N);
        graph.BFS(area, N, max);
    }
}

class Graph{
    private int nodeCnt;
    private LinkedList<Integer>[] adj;

    Graph(int nodeCnt){
        this.nodeCnt = nodeCnt;
        adj = new LinkedList[nodeCnt];

        for(int idx = 0; idx < nodeCnt; idx++){
            adj[idx] = new LinkedList();
        }
    }

    void linkNode(int col){
        for(int idx = 0; idx < this.nodeCnt; idx++){
            // 상
            if(idx - col >= 0){
                this.adj[idx].offer(idx - col);
            }
            // 하
            if(idx + col < this.nodeCnt){
                this.adj[idx].offer(idx + col);
            }
            // 좌
            if(idx % col != 0 && idx - 1 >= 0){
                this.adj[idx].offer(idx - 1);
            }
            // 우
            if((idx + 1) % col != 0 && idx + 1 < this.nodeCnt){
                this.adj[idx].offer(idx + 1);
            }
        }
    }

    void BFS(int[] area, int col, int m){
        boolean[] visited = new boolean[this.nodeCnt];
        Queue<Integer> queue = new LinkedList();
        int areaCnt = 0;    // 안전지역 개수
        int maxAreaCnt = 0; // 안전지역 개수가 제일 많을 때

        for(int max = 0; max < m; max++){
            for(int idx = 0; idx < this.nodeCnt; idx++){
                if(area[idx] > max && !visited[idx]){
                    queue.offer(idx);
                    visited[idx] = true;
                    areaCnt++;
                }

                while(!queue.isEmpty()){
                    int curNode = queue.poll();

                    Iterator<Integer> it = adj[curNode].listIterator();
                    while(it.hasNext()){
                        int linkedNode = it.next();

                        if(!visited[linkedNode] && area[linkedNode] > max){
                            queue.offer(linkedNode);
                            visited[linkedNode] = true;
                        }
                    }
                }

                if(maxAreaCnt < areaCnt){
                    maxAreaCnt = areaCnt;
                }
            }
            areaCnt = 0;
            visited = new boolean[this.nodeCnt];
        }

        System.out.print(maxAreaCnt);
    }
}