package BaekJoon.DfsAndBfs.Q24479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q24479_AlgorithmClassDFS1 {

    public static int N;
    public static int M;
    public static int srt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        srt = Integer.parseInt(st.nextToken());
        Graph graph = new Graph(N + 1);

        for(int idx = 0; idx < M; idx++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.linkNode(x, y);
        }

        graph.dfs(srt);
    }
}

class Graph{
    private StringBuilder sb = new StringBuilder();
    private PriorityQueue<Integer>[] adj;
    private boolean[] visited;
    private int[] seqArr;

    Graph(int cnt){
        this.adj = new PriorityQueue[cnt];
        this.visited = new boolean[cnt];
        this.seqArr = new int[cnt];

        for(int idx = 0; idx < cnt; idx++){
            this.adj[idx] = new PriorityQueue<>(Comparator.reverseOrder());
        }
    }

    void linkNode(int x, int y){
        this.adj[x].add(y);
        this.adj[y].add(x);
    }

    void dfs(int srt){
        Stack<Integer> stack = new Stack<>();
        int seq = 1;

        stack.push(srt);
        this.visited[srt] = true;

        while (!stack.isEmpty()){
            int curNode = stack.pop();
            this.visited[curNode] = true;
            this.seqArr[curNode] = seq++;

            while(!adj[curNode].isEmpty()){
                Integer linkedNode = adj[curNode].poll();

                if(stack.contains(linkedNode)){
                    stack.remove(linkedNode);
                }

                if(!this.visited[linkedNode]){
                    stack.push(linkedNode);
                }
            }
        }

        print();
    }

    void print(){
        for(int idx = 1; idx < this.seqArr.length; idx++){
            this.sb.append(this.seqArr[idx]).append('\n');
        }

        System.out.println(this.sb);
    }
}