package BaekJoon.DfsAndBfs.Q1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260_DfsAndBfs_sol3 {

    public static int N;    // 정점의 개수
    public static int M;    // 간선의 개수
    public static int V;    // 시작 정점 번호
    public static List<Integer>[] adj;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];

        for(int idx = 0; idx <= N; idx++){
            adj[idx] = new ArrayList<>();
        }

        for(int idx = 0; idx < M; idx++){
            st = new StringTokenizer(br.readLine());
            int srt = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[srt].add(end);
            adj[end].add(srt);
        }

        for(int idx = 1; idx <= N; idx++){
            Collections.sort(adj[idx]);
        }

        dfs(V, new boolean[N + 1]);
        sb.append('\n');
        bfs();

        System.out.println(sb);
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        visited[V] = true;
        queue.add(V);

        while(!queue.isEmpty()){
            int curV = queue.poll();
            Iterator<Integer> it = adj[curV].listIterator();

            sb.append(curV + " ");

            while(it.hasNext()){
                int linkedV = it.next();

                if(!visited[linkedV]){
                    visited[linkedV] = true;
                    queue.add(linkedV);
                }
            }
        }
    }

    public static void dfs(int V, boolean[] visited){
        Iterator<Integer> it = adj[V].listIterator();

        visited[V] = true;
        sb.append(V + " ");

        while(it.hasNext()){
            int linkedV = it.next();

            if(!visited[linkedV]){
                dfs(linkedV, visited);
            }
        }
    }
}