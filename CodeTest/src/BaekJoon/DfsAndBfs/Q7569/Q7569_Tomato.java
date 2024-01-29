package BaekJoon.DfsAndBfs.Q7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7569_Tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sizeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int col = sizeInfo[0];
        int row = sizeInfo[1];
        int height = sizeInfo[2];
        int nodeCnt = col * row * height;
        int[] tomatoes = new int[nodeCnt];
        Graph graph = new Graph(nodeCnt);

        for(int i = 0; i < height; i++){
            for(int j = 0; j < row; j++){
                int[] tomatoInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                for(int k = 0; k < col; k++){
                    int idx = i * (col * row) + (j * col) + k;

                    tomatoes[idx] = tomatoInfo[k];
                }
            }
        }

        graph.linkNode(row, col);
        graph.BFS(tomatoes);
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

    void linkNode(int row, int col){
        for(int idx = 0; idx < this.nodeCnt; idx++){
            // 한 층의 토마토 갯수
            int floorCnt = row * col;

            // 위층
            if(idx + (floorCnt) < this.nodeCnt){
                this.adj[idx].offer(idx + (floorCnt));
            }
            // 아래층
            if(idx - (floorCnt) >= 0){
                this.adj[idx].offer(idx - (floorCnt));
            }
            // 상
            // 적어도 0번 노드 && 같은 층에 있을 때
            if(idx - col >= 0 && (idx - col) / floorCnt == idx / floorCnt){
                this.adj[idx].offer(idx - col);
            }
            // 하
            // 가장 큰 노드의 범위 && 같은 층에 있을 때
            if(idx + col < this.nodeCnt && (idx + col) / floorCnt == idx / floorCnt){
                this.adj[idx].offer(idx + col);
            }
            // 좌
            // 적어도 0번 노드 && 같은 라인에 있으며 && 같은 층에 있을 때
            if(idx - 1 >= 0 && idx % col != 0 && (idx - 1) / floorCnt == idx / floorCnt){
                this.adj[idx].offer(idx - 1);
            }
            // 우
            // 가장 큰 노드의 범위 && 같은 라인에 있으며 && 같은 층에 있을 때
            if(idx + 1 < this.nodeCnt && (idx + 1) % col != 0 && (idx + 1) / floorCnt == idx / floorCnt){
                this.adj[idx].offer(idx + 1);
            }
        }
    }

    void BFS(int[] tomatoes){
        boolean[] visited = new boolean[this.nodeCnt];
        int[] day = new int[this.nodeCnt];
        int minDay = 0;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> tomatoList = getFirstNode(tomatoes);

        for(int idx = 0; idx < tomatoList.size(); idx++){
            int tomatoIdx = tomatoList.get(idx);

            visited[tomatoIdx] = true;
            queue.offer(tomatoIdx);
            day[tomatoIdx] = 0;
        }

        while(!queue.isEmpty()){
            int curNode = queue.poll();

            Iterator<Integer> it = adj[curNode].listIterator();

            while(it.hasNext()){
                int linkedNode = it.next();

                if(!visited[linkedNode] && tomatoes[linkedNode] == 0){
                    queue.offer(linkedNode);
                    visited[linkedNode] = true;
                    day[linkedNode] = day[curNode] + 1;

                    if(minDay < day[linkedNode]){
                        minDay = day[linkedNode];
                    }
                }
            }
        }

        if(isAllRiped(tomatoes, day)){
            System.out.print(minDay);
        }
    }

    boolean isAllRiped(int[] tomatoes, int[] day){
        for(int idx = 0; idx < tomatoes.length; idx++){
            if(tomatoes[idx] == 0 && day[idx] == 0){
                System.out.print(-1);
                return false;
            }
        }

        return true;
    }

    ArrayList<Integer> getFirstNode(int[] tomatoes){
        ArrayList<Integer> list = new ArrayList<>();

        for(int idx = 0; idx < tomatoes.length; idx++){
            if(tomatoes[idx] == 1){
                list.add(idx);
            }
        }

        return list;
    }
}