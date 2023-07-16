package baekjoon.dfs_back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  [ 효율성 ]
 *  - 메모리: 14116KB
 *  - 시간 : 120ms
 */
// https://www.acmicpc.net/problem/2606
public class Q2606 {

    private static int N, M, count;

    private static int[][] computer;
    private static boolean[] visited;


    private static void dfs(int x) {
        // 현재 노드 방문 처리
        visited[x] = true;

        // 방문 노드 출력
        // System.out.print(x + " ");

        for (int node = 1; node < N + 1; node++) {

            if (!visited[node] && computer[x][node] == 1){
                dfs(node);
                count++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        M = Integer.parseInt(br.readLine()); // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

        computer = new int [N + 1][N + 1];  // 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍
        visited = new boolean[N + 1];

        StringTokenizer st;
        int a, b;

        for (int i=0; i< M; i++){
             st = new StringTokenizer(br.readLine(), " ");
             a = Integer.parseInt(st.nextToken());
             b = Integer.parseInt(st.nextToken());
             computer[a][b] = computer[b][a] = 1;
        }

        dfs(1);

        System.out.println(count);

    }
}
