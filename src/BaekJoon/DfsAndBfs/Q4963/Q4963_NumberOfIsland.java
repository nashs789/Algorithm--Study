package BaekJoon.DfsAndBfs.Q4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q4963_NumberOfIsland {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int col = info[0];
            int row = info[1];
            int[] lands = new int[col * row];

            if(col == 0 && row == 0){
                break;
            }

            for(int i = 0; i < row; i++){
                int[] landInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                for(int j = 0; j < col; j++){
                    lands[i * col + j] = landInfo[j];
                }
            }

            Graph graph = new Graph(row * col);
            graph.linkNode(col);
            graph.DFS(lands);
        }
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

    void linkNode(int col){
        for(int idx = 0; idx < this.nodeCnt; idx++){
            // 좌상
            if(idx % col != 0 && idx - (col + 1) >= 0){
                this.adj[idx].offer(idx - (col + 1));
            }

            // 상
            if(idx - col >= 0){
                this.adj[idx].offer(idx - col);
            }

            // 우상
            if((idx + 1) % col != 0 && idx - (col - 1) >= 0){
                this.adj[idx].offer(idx - (col - 1));
            }

            // 좌
            if(idx - 1 >= 0 && idx % col != 0){
                this.adj[idx].offer(idx - 1);
            }

            // 우
            if((idx + 1) % col != 0 && (idx + 1) < this.nodeCnt){
                this.adj[idx].offer(idx + 1);
            }

            // 좌하
            if(idx % col != 0 && idx + (col - 1) < this.nodeCnt){
                this.adj[idx].offer(idx + (col - 1));
            }

            // 하
            if(idx + col < this.nodeCnt){
                this.adj[idx].offer(idx + col);
            }

            // 우하
            if((idx + 1) % col != 0 && idx + (col + 1) < this.nodeCnt){
                this.adj[idx].offer(idx + (col + 1));
            }
        }
    }

    void DFS(int[] lands){
        boolean[] visited = new boolean[this.nodeCnt];
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for(int idx = 0; idx < this.nodeCnt; idx++){
            if(lands[idx] == 0 || visited[idx]){
                continue;
            }

            stack.push(idx);
            visited[idx] = true;
            cnt++;

            while(!stack.isEmpty()){
                int curNode = stack.pop();

                Iterator<Integer> it = this.adj[curNode].listIterator();

                while(it.hasNext()){
                    int linkedNode = it.next();

                    if(lands[linkedNode] == 1 && !visited[linkedNode]){
                        visited[linkedNode] = true;
                        stack.push(linkedNode);
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
