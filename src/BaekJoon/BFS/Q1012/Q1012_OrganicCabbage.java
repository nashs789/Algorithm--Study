package BaekJoon.BFS.Q1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1012_OrganicCabbage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수

        for(int idx = 0; idx < T; idx++){
            String[] sizeInfo = br.readLine().split(" ");
            Map<Integer, Node> cabbageFarm = new HashMap<>();

            int row = Integer.parseInt(sizeInfo[0]); // 가로길이
            int col = Integer.parseInt(sizeInfo[1]); // 세로길이
            int cabbageCnt = Integer.parseInt(sizeInfo[2]); // 배추개수

            for(int idx2 = 0; idx2 < col * row; idx2++){
                cabbageFarm.put(idx2, new Node(0));
            }

            for(int idx3 = 0; idx3 < cabbageCnt; idx3++){
                String[] point = br.readLine().split(" ");
                int x = Integer.parseInt(point[0]);
                int y = Integer.parseInt(point[1]);
                int notEmptyIdx = (x * col) + y;

                cabbageFarm.get(notEmptyIdx).setEmpty(1);
            }

            Graph graph = new Graph(col * row);
            graph.linkNode(col);
            graph.BFS(cabbageFarm);
            System.out.println(graph.getResult());
        }
    }
}

class Graph{
    private int nodeCnt;
    private LinkedList<Integer>[] adj;
    private int answer = 0;

    Graph(int nodeCnt){
        this.nodeCnt = nodeCnt;
        adj = new LinkedList[nodeCnt];

        for(int idx = 0; idx < this.nodeCnt; idx++){
            adj[idx] = new LinkedList<>();
        }
    }

    void linkNode(int col){
        for(int idx = 0; idx < this.nodeCnt; idx++){
            // '상'
            if(idx - col >= 0){
                this.adj[idx].offer(idx - col);
            }

            // '하'
            if(idx + col < this.nodeCnt){
                this.adj[idx].offer(idx + col);
            }

            // '좌'
            if(idx - 1 >= 0 && (idx - 1) % col != col - 1){
                this.adj[idx].offer(idx - 1);
            }

            // '우'
            if(idx + 1 < this.nodeCnt && (idx + 1) % col != 0){
                this.adj[idx].offer(idx + 1);
            }
        }
    }

    void BFS(Map<Integer, Node> cabbageFarm){
        boolean[] visited = new boolean[this.nodeCnt];
        Queue<Integer> queue = new LinkedList<>();

        for(int idx = 0; idx < this.nodeCnt; idx++){
            if(cabbageFarm.get(idx).getEmpty() == 0 || visited[idx]){
                continue;
            }

            visited[idx] = true;
            queue.offer(idx);
            this.answer++;

            while(!queue.isEmpty()){
                int curNode = queue.poll();

                Iterator<Integer> it = this.adj[curNode].listIterator();

                while(it.hasNext()){
                    int linkedNode = it.next();

                    if(!visited[linkedNode] && cabbageFarm.get(linkedNode).getEmpty() == 1){
                        queue.offer(linkedNode);
                        visited[linkedNode] = true;
                    }
                }
            }
        }
    }

    int getResult(){
        return this.answer;
    }
}

class Node{
    private int empty; // 0: empty    1: not empty

    Node(int empty){
        this.empty = empty;
    }

    void setEmpty(int empty){
        this.empty = empty;
    }

    public int getEmpty() {
        return empty;
    }
}