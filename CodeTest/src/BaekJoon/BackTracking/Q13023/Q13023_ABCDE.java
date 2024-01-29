package BaekJoon.BackTracking.Q13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q13023_ABCDE {

    public static int N;
    public static int M;
    public static boolean[] visited;
    public static LinkedList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        adj = new LinkedList[N];

        for(int idx = 0; idx < N; idx++){
            adj[idx] = new LinkedList<>();
        }

        for(int idx = 0; idx < M; idx++){
            st = new StringTokenizer(br.readLine());
            int srt = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[srt].add(end);
            adj[end].add(srt);
        }

        for(int idx = 0; idx < N; idx++){
            if(!visited[idx]){
                backTracking(idx, 0);
            }
        }

        System.out.println(0);
    }

    public static void backTracking(int node, int relation){
        if(relation == 5){
            System.out.println(1);
            System.exit(0);
        }

        Iterator<Integer> it = adj[node].listIterator();

        while(it.hasNext()){
            int linkedNode = it.next();

            if(!visited[linkedNode]){
                visited[linkedNode] = true;
                backTracking(linkedNode, relation + 1);
                visited[linkedNode] = false;
            }
        }
    }
}