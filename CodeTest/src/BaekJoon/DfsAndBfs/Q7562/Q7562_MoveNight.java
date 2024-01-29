package BaekJoon.DfsAndBfs.Q7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q7562_MoveNight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        Graph graph;

        for(int i = 0; i < cnt; i++){
            // 사이즈, 시작 좌표, 목표 좌표
            int size = Integer.parseInt(br.readLine());
            int[] str = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int strNode = str[0] * size + str[1];
            int endNode = end[0] * size + end[1];

            graph = new Graph(size * size);
            graph.linkNode(size);
            graph.BFS(strNode, endNode);
        }
    }
}

class Graph {
    private int nodeCnt;
    private LinkedList<Integer>[] adj;

    Graph(int nodeCnt) {
        this.nodeCnt = nodeCnt;
        this.adj = new LinkedList[nodeCnt];

        for (int idx = 0; idx < nodeCnt; idx++) {
            this.adj[idx] = new LinkedList();
        }
    }

    void linkNode(int col) {
        for (int idx = 0; idx < this.nodeCnt; idx++) {
            if (idx % col != 0) {
                // 상 -> 우
                if (idx - (col * 2 + 1) >= 0) {
                    this.adj[idx].offer(idx - (col * 2 + 1));
                }

                // 하 -> 좌
                if (idx + (col * 2 - 1) < this.nodeCnt) {
                    this.adj[idx].offer(idx + (col * 2 - 1));
                }
            }

            if ((idx + 1) % col != 0) {
                // 상 -> 좌
                if (idx - (col * 2 - 1) >= 0) {
                    this.adj[idx].offer(idx - (col * 2 - 1));
                }

                // 하 -> 우
                if (idx + (col * 2 + 1) < this.nodeCnt) {
                    this.adj[idx].offer(idx + (col * 2 + 1));
                }
            }

            if (idx % col >= 2) {
                // 좌 -> 상
                if (idx - (col + 2) >= 0) {
                    this.adj[idx].offer(idx - (col + 2));
                }

                // 좌 -> 하
                if (idx + (col - 2) < this.nodeCnt) {
                    this.adj[idx].offer(idx + (col - 2));
                }
            }

            if (idx % col < col - 2) {
                // 우 -> 상
                if ((idx + 2) - col >= 0) {
                    this.adj[idx].offer((idx + 2) - col);
                }
                // 우 -> 하
                if (idx + (col + 2) < this.nodeCnt) {
                    this.adj[idx].offer(idx + (col + 2));
                }
            }
        }
    }

    void BFS(int strNode, int endNode) {
        boolean[] visited = new boolean[this.nodeCnt];
        int[] distance = new int[this.nodeCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(strNode);
        visited[strNode] = true;
        distance[strNode] = 0;

        while(!queue.isEmpty()){
            int curNode = queue.poll();

            if(curNode == endNode){
                System.out.println(distance[curNode]);
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