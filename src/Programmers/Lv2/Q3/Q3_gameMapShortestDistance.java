package Programmers.Lv2.Q3;

import java.util.*;

public class Q3_gameMapShortestDistance {
    public static void main(String[] args) {
        /*int[][] maps = {
                        {1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,1},
                        {0,0,0,0,1}
                       };*/

        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        Map<Integer, Node> mapNode = new HashMap<>();
        int row = maps.length;
        int col = maps[0].length;
        int mapNodeIdx = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                mapNode.put(mapNodeIdx++,  new Node(maps[i][j]));
            }
        }

        Graph graph = new Graph(mapNodeIdx);
        graph.linkNode(col);
        graph.BFS(mapNode);
        System.out.println(graph.getResult());
    }
}

class Graph{
    private int nodeCnt;
    private LinkedList<Integer>[] adj;
    private boolean reachLastNode = false;
    private int distance;

    Graph(int nodeCnt){
        this.nodeCnt = nodeCnt;
        this.adj = new LinkedList[nodeCnt];

        for(int idx = 0; idx < nodeCnt; idx++){
            this.adj[idx] = new LinkedList<>();
        }
    }

    void linkNode(int col){
        for(int idx = 0; idx < nodeCnt; idx++){
            // 상
            if(idx - col >= 0){
                this.adj[idx].offer(idx - col);
            }

            // 하
            if(idx + col < nodeCnt){
                this.adj[idx].offer(idx + col);
            }

            // 좌
            if(idx - 1 >= 0 && (idx - 1) % col != col - 1){
                this.adj[idx].offer(idx - 1);
            }

            // 우
            if((idx + 1) % col != 0){
                this.adj[idx].offer(idx + 1);
            }
        }
    }

    void BFS(Map<Integer, Node> mapNode){
        boolean[] visited = new boolean[this.nodeCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;
        mapNode.get(0).setDistance(1);

        while(!queue.isEmpty()){
            int curNode = queue.poll();

            if(curNode == this.nodeCnt - 1){
                this.reachLastNode = true;
                this.distance = mapNode.get(curNode).getDistance();
                break;
            }

            Iterator<Integer> it = this.adj[curNode].listIterator();

            while(it.hasNext()){
                int linkedNode = it.next();

                if(!visited[linkedNode] && mapNode.get(linkedNode).getOpen() == 1){
                    queue.offer(linkedNode);
                    visited[linkedNode] = true;
                    mapNode.get(linkedNode).setDistance(mapNode.get(curNode).getDistance() + 1);
                }
            }
        }
    }

    int getResult(){
        return this.reachLastNode ? this.distance : -1;
    }
}

class Node{
    private int open;       // 0: close, 1: open
    private int distance;   // 현재까지 지나온 거리

    Node(int open){
        this.open = open;
    }

    int getOpen(){
        return this.open;
    }

    int getDistance(){
        return this.distance;
    }

    void setDistance(int distance){
        this.distance = distance;
    }
}