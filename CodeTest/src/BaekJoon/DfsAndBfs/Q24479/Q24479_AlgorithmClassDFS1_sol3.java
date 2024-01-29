package BaekJoon.DfsAndBfs.Q24479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q24479_AlgorithmClassDFS1_sol3 {

    public static int N;
    public static int M;
    public static int srt;
    public static PriorityQueue<Integer>[] adj;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;
    public static int[] seqArr;
    public static int seq = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        srt = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        adj = new PriorityQueue[N + 1];
        seqArr = new int[N + 1];

        for(int idx = 1; idx <= N; idx++){
            adj[idx] = new PriorityQueue<>(Comparator.naturalOrder());
        }

        for(int idx = 0; idx < M; idx++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        dfs(srt);

        for(int idx = 1; idx < seqArr.length; idx++){
            sb.append(seqArr[idx]).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int idx){
        visited[idx] = true;
        seqArr[idx] = seq++;

        while (!adj[idx].isEmpty()){
            int linkedNode = adj[idx].poll();

            if(!visited[linkedNode]){
                dfs(linkedNode);
            }
        }
    }
}