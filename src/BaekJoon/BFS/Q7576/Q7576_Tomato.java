package BaekJoon.BFS.Q7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7576_Tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInfo = br.readLine().split(" ");
        int col = Integer.parseInt(sizeInfo[0]);
        int row = Integer.parseInt(sizeInfo[1]);
        Tomato tomatoes[] = new Tomato[row * col];

        for(int i = 0; i < row; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int j = 0; j < col; j++){
                int tomatoIdx = (i * col) + j;

                tomatoes[tomatoIdx] = new Tomato(input[j]);
            }
        }

        Graph graph = new Graph(col * row);
        graph.linkNode(col);
        graph.BFS(tomatoes);
    }
}

class Graph {
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
            // 상
            if(idx - col >= 0){
                this.adj[idx].offer(idx - col);
            }
            // 하
            if(idx + col < this.nodeCnt){
                this.adj[idx].offer(idx + col);
            }
            // 좌
            if(idx - 1 >= 0 && (idx - 1) % col != col - 1){
                this.adj[idx].offer(idx - 1);
            }
            // 우
            if(idx + 1 < this.nodeCnt && (idx + 1) % col != 0){
                this.adj[idx].offer(idx + 1);
            }
        }
    }

    void BFS(Tomato[] tomatoes){
        List<Integer> list = getRipedList(tomatoes);

        boolean[] visited = new boolean[this.nodeCnt];
        Queue<Integer> queue = new LinkedList<>();
        int maxDay = 0;

        for(Integer idx : list){
            visited[idx] = true;
            queue.offer(idx);
        }

        while(!queue.isEmpty()){
            int curTomato = queue.poll();
            Iterator<Integer> it = this.adj[curTomato].listIterator();

            while(it.hasNext()){
                int linkedTomato = it.next();

                if(!visited[linkedTomato] && !tomatoes[linkedTomato].getEmpty()){
                    visited[linkedTomato] = true;
                    queue.offer(linkedTomato);
                    tomatoes[linkedTomato].setDay(tomatoes[curTomato].getDay() + 1);
                    tomatoes[linkedTomato].setRipe(true);
                    maxDay = tomatoes[curTomato].getDay() + 1;
                }
            }
        }

        System.out.println(!isAllRiped(tomatoes) ? -1 : maxDay);
    }

    List<Integer> getRipedList(Tomato[] tomatoes){
        List<Integer> list = new ArrayList<>();

        for(int idx = 0; idx < nodeCnt; idx++){
            if(tomatoes[idx].getRipe() && !tomatoes[idx].getEmpty()){
                list.add(idx);
            }
        }

        return list;
    }

    boolean isAllRiped(Tomato[] tomatoes){
        for(int idx = 0; idx < nodeCnt; idx++){
            if(!tomatoes[idx].getEmpty() && !tomatoes[idx].getRipe()){
                return false;
            }
        }

        return true;
    }
}

class Tomato {
    private boolean ripe;   // true: 익음    false: 덜 익음
    private boolean empty;  // true: 비어있음    false: 안 비어있음
    private int day = 0;

    Tomato(int info){
        this.ripe = info == 1 ? true : false;
        this.empty = info == -1 ? true : false;
    }

    void setDay(int day){
        this.day = day;
    }

    void setRipe(boolean ripe){
        this.ripe = ripe;
    }

    int getDay(){
        return this.day;
    }

    boolean getRipe(){
        return this.ripe;
    }

    boolean getEmpty() {
        return this.empty;
    }
}