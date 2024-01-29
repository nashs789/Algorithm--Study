package BaekJoon.DfsAndBfs.Q1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1325_EffectiveHacking {

    public static int N;    // 컴퓨터의 수
    public static int M;    // 신뢰하는 관계의 수
    public static List<List<Integer>> adj;
    public static int[] coms;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>(N + 1);
        coms = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj.get(A).add(B);
        }

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            dfs(i, visited);
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, coms[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (coms[i] == max) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb);
    }

    public static void dfs(int num, boolean[] visited) {
        visited[num] = true;

        for (int nextCom : adj.get(num)) {
            if (!visited[nextCom]) {
                coms[nextCom]++;
                dfs(nextCom, visited);
            }
        }
    }
}