package baekjoon.dfs_back;

import java.io.*;

// https://www.acmicpc.net/problem/10974
/**
 *  [ 효율성 ]
 *  - 메모리: 54968KB
 *  - 시간 : 2044ms
 */
public class Q10974 { // 중복 순열

    private static int N;
    private static int[] arr;
    private static boolean[] visited; // 해당 depth 에 방문했는지 check

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        permutation(1);
    }

    private static void permutation(int depth) {

        if (depth == N + 1) {
            for (int i = 1;i < arr.length; i++) System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
