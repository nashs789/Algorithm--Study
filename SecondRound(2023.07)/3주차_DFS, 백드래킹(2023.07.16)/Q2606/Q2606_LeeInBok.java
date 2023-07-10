/**
 *  [ 효율성 ]
 *  - 메모리: 14212KB
 *  - 시간 : 128ms
 */


package BaekJoon.DfsAndBfs.Q2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2606_Virus_sol2 {

    public static int vertex;
    public static int edge;
    public static List<List<Integer>> adj;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        visited = new boolean[vertex + 1];
        adj = new ArrayList<>(vertex + 1);

        for(int idx = 0; idx <= vertex; idx++){
            adj.add(new ArrayList<>());
        }

        for(int idx = 0; idx < edge; idx++){
            st = new StringTokenizer(br.readLine());
            int comA = Integer.parseInt(st.nextToken());
            int comB = Integer.parseInt(st.nextToken());

            adj.get(comA).add(comB);
            adj.get(comB).add(comA);
        }

        visited[1] = true;
        System.out.println(dfs(1, 0));
    }

    public static int dfs(int vertex, int cnt){
        for(int linkedVertex : adj.get(vertex)){
            if(!visited[linkedVertex]){
                visited[linkedVertex] = true;
                cnt = dfs(linkedVertex, ++cnt);
            }
        }

        return cnt;
    }
}