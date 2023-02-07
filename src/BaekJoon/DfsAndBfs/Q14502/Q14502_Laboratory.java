package BaekJoon.DfsAndBfs.Q14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q14502_Laboratory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sizeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int row = sizeInfo[0];
        int col = sizeInfo[1];
        int[] walls = new int[row * col];

        for(int i = 0; i < row; i++){
            int[] nodeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int j = 0; j < col; j++){
                walls[(i * col) + j] = nodeInfo[j];
            }
        }

        Graph graph = new Graph(row * col);
        graph.linkNode(col);
        graph.BFS(walls);
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
            if(idx + 1 < this.nodeCnt && (idx + 1) % col != 0){
                this.adj[idx].offer(idx + 1);
            }
        }
    }

    void BFS(int[] walls){
        boolean[] visited = new boolean[this.nodeCnt];
        Queue<Integer> queue = new LinkedList<>();
        int[] virusTest = walls.clone();
        int maxSafeSpace = 0;

        // for, if: 빈 공간에 벽 3개 설치
        for(int i = 0; i < this.nodeCnt - 2; i++){
            if(virusTest[i] != 0){
                continue;
            }
            for(int j = i + 1; j < this.nodeCnt - 1; j++){
                if(virusTest[j] != 0){
                    continue;
                }
                for(int k = j + 1; k < this.nodeCnt; k++) {
                    if (virusTest[k] != 0) {
                        continue;
                    }
                    // 여기 까지의 코드가 3개의 벽 설치 로직

                    for(int idx = 0; idx < this.nodeCnt; idx++) {
                        if(virusTest[idx] == 2) {
                            queue.offer(idx);
                            visited[idx] = true;
                        }
                    }

                    virusTest[i] = 1;   // 첫 번째 벽
                    virusTest[j] = 1;   // 두 번째 벽
                    virusTest[k] = 1;   // 세 번째 벽

                    // BFS: 바이러스 침식
                    while(!queue.isEmpty()){
                        int curNode = queue.poll();

                        Iterator<Integer> it = adj[curNode].listIterator();

                        while(it.hasNext()){
                            int linkNode = it.next();

                            if(virusTest[linkNode] != 1 && !visited[linkNode]){
                                visited[linkNode] = true;
                                queue.offer(linkNode);
                                virusTest[linkNode] = 2;
                            }
                        }
                    }

                    int safeSpace = countSafeSpace(virusTest);

                    // 바이러스 침식 후 안전한 공간 갯수
                    if(maxSafeSpace < safeSpace){
                        maxSafeSpace = safeSpace;
                    }

                    // 배열 초기화
                    virusTest = walls.clone();
                    visited = new boolean[this.nodeCnt];
                }
            }
        } // 3중 for end
        System.out.println(maxSafeSpace);
    }

    int countSafeSpace(int[] virusTest) {
        int cnt = 0;

        for(int idx = 0; idx < this.nodeCnt; idx++){
            if(virusTest[idx] == 0){
                cnt++;
            }
        }
        return cnt;
    }
}
