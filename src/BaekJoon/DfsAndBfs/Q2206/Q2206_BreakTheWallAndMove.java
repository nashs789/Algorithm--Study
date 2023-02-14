package BaekJoon.DfsAndBfs.Q2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q2206_BreakTheWallAndMove {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sizeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = sizeInfo[0];
        int col = sizeInfo[1];
        int[] wall = new int[row * col];

        for(int i = 0; i < row; i++){
            int[] mapInfo = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            
            for(int j = 0; j < col; j++){
                int idx = i * col + j;

                wall[idx] = mapInfo[j];
            }
        }

        Graph graph = new Graph(col * row, col);
        graph.BFS(wall, (col * row) - 1);
    }
}

class Graph{
    private int nodeCnt;
    private LinkedList<Integer>[] adj;

    Graph(int nodeCnt, int col){
        this.nodeCnt = nodeCnt;
        this.adj = new LinkedList[nodeCnt];

        for(int idx = 0; idx < this.nodeCnt; idx++){
            this.adj[idx] = new LinkedList<>();

            // 상
            if(idx - col >= 0){
                adj[idx].offer(idx - col);
            }
            // 하
            if(idx + col < this.nodeCnt){
                adj[idx].offer(idx + col);
            }
            // 좌
            if(idx % col != 0 && idx - 1 >= 0){
                adj[idx].offer(idx - 1);
            }
            // 우
            if((idx + 1) % col != 0 && idx + 1 < this.nodeCnt){
                adj[idx].offer(idx + 1);
            }
        }
    }

    void BFS(int[] wall, int end){
        boolean[] visited = new boolean[this.nodeCnt];
        boolean[] broke = new boolean[this.nodeCnt];
        int[] distance = new int[this.nodeCnt];
        Queue<Integer> queue = new LinkedList<>();
        boolean finished = false;

        queue.offer(0);
        visited[0] = true;
        distance[0] = 1;

        while(!queue.isEmpty()){
            int curNode = queue.poll();

            if(curNode == end){
                System.out.println(distance[curNode]);
                finished = true;
                break;
            }

            Iterator<Integer> it = adj[curNode].listIterator();

            while(it.hasNext()){
                int linkedNode = it.next();

                if(wall[linkedNode] == 1 && broke[curNode]){
                    continue;
                }

                if(!visited[linkedNode]){
                    queue.offer(linkedNode);
                    visited[linkedNode] = true;
                    distance[linkedNode] = distance[curNode] + 1;

                    if(wall[linkedNode] == 0){
                        broke[linkedNode] = broke[curNode];
                    } else if(wall[linkedNode] == 1 && !broke[curNode]){
                        broke[linkedNode] = true;
                    }
                }
            }
        }

        if(!finished){
            System.out.println(-1);
        }
    }
}