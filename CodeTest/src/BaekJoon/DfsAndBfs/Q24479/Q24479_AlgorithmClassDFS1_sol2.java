package BaekJoon.DfsAndBfs.Q24479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q24479_AlgorithmClassDFS1_sol2 {

    public static int N;
    public static int M;
    public static int srt;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        srt = Integer.parseInt(st.nextToken());
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int idx = 0; idx < M; idx++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(srt);
        System.out.print(sb);
    }

    // 순서 저장하는 로직이 없음 but 메모리 초과 나기 때문에 폐기
    static void dfs(int idx){
        visited[idx] = true;

        for(int i = 1; i < graph.length; i++){
            // 연결된 노드 && 방문하지 않은 경우
            if(graph[idx][i] && !visited[i]){
                visited[idx] = true;
                dfs(i);
            }
        }
    }
}