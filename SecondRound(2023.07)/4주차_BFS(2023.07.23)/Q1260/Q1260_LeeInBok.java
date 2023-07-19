/**
 *  [ 효율성 ]
 *  - 메모리: 19956KB
 *  - 시간 : 216ms
 */

package BaekJoon.DfsAndBfs.Q1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260_DfsAndBfs_sol2 {

    private static int N;
    private static int M;
    private static int V;
    private static int curNode;
    private static ArrayList<Integer>[] adj;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];

        for(int idx = 1; idx <= N; idx++){
            adj[idx] = new ArrayList<>();
        }

        for(int idx = 0; idx < M; idx++){
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[str].add(end);
            adj[end].add(str);
        }

        for(int idx = 1; idx <= N; idx++){
            Collections.sort(adj[idx]);
        }

        // DFS
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        DFS(V);
        System.out.println(sb);

        // BFS
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        BFS(V);
        System.out.println(sb);
    }

    private static void DFS(int V){
        sb.append(V).append(" ");
        visited[V] = true;

        for(int n : adj[V]){
            if(!visited[n]){
                DFS(n);
            }
        }
    }

    private static void BFS(int V){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(V);
        visited[V] = true;

        while(!queue.isEmpty()){
            curNode = queue.poll();
            sb.append(curNode).append(" ");

            for(int n : adj[curNode]){
                if(!visited[n]){
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }
    }
}
