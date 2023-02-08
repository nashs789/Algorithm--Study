package Programmers.Lv2.Q1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q1_KakaoFriendsColoringBook {
    public static void main(String[] args) {
        int m = 6;  // row
        int n = 4;  // col
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        Graph graph = new Graph(m * n);
        graph.linkNode(n);
        graph.BFS(picture, n);
    }

    static class Graph{
        private int nodeCnt;
        private LinkedList<Integer>[] adj;

        Graph(int nodeCnt){
            this.nodeCnt = nodeCnt;
            adj = new LinkedList[nodeCnt];

            for(int idx = 0; idx < nodeCnt; idx++){
                adj[idx] = new LinkedList<>();
            }
        }

        void linkNode(int col){
            for(int idx = 0; idx < this.nodeCnt; idx++){
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

        int[] BFS(int[][] picture, int col){
            boolean[] visited = new boolean[this.nodeCnt];
            Queue<Integer> queue = new LinkedList();
            int maximumSize = 0;
            int area = 0;

            for(int i = 0; i < picture.length; i++){
                for(int j = 0; j < picture[0].length; j++){
                    // 비어있는 공간
                    if(picture[i][j] == 0 || visited[i * col + j]){
                        continue;
                    }

                    int color = picture[i][j];
                    int nodeNumber = i * col + j;
                    int size = 0;

                    queue.offer(nodeNumber);
                    visited[nodeNumber] = true;
                    area++;

                    while(!queue.isEmpty()){
                        int curNode = queue.poll();
                        size++;

                        Iterator<Integer> it = adj[curNode].listIterator();

                        while(it.hasNext()){
                            int linkedNode = it.next();
                            int nodeRow = linkedNode / col;
                            int nodeCol = linkedNode % col;

                            if(!visited[linkedNode] && picture[nodeRow][nodeCol] == color){
                                visited[linkedNode] = true;
                                queue.offer(linkedNode);
                            }
                        }

                        if(maximumSize < size){
                            maximumSize = size;
                        }
                    }
                }
            }

            return new int[]{area, maximumSize};
        }
    }
}