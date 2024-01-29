package BaekJoon.BackTracking.Q15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15649_NAndM1_sol2 {

    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visited;
    private static int[] comb;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        comb = new int[M + 1];

        dfs(1);

        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if(depth == M + 1){
            for(int idx = 1; idx <= M; idx++){
                sb.append(comb[idx]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int idx = 1; idx <= N; idx++){
            if(!visited[idx]){
                visited[idx] = true;
                comb[depth] = idx;
                dfs(depth + 1);
                visited[idx] = false;
            }
        }
    }
}