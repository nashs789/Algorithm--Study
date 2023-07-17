/**
 *  [ 효율성 ]
 *  - 메모리: 23288KB
 *  - 시간 : 340ms
 */

package Baekjoon.July17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Q1260_dfsbfs {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int key, value;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            key = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(key, list -> new TreeSet<>()).add(value);
            map.computeIfAbsent(value, list -> new TreeSet<>()).add(key);
        }

        Solution.solution(n, m, v, map);
    }
}

class Solution {
    public static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    private static void dfs(int v, HashMap<Integer, TreeSet<Integer>> map) {
        visited[v] = true;
        if (map.get(v) == null) return ;
        for (int e : map.get(v)) {
            if (!visited[e]) {
                sb.append(e + " ");
                visited[e] = true;
                dfs(e, map);
            }
        }
    }
    private static void bfs(int v, HashMap<Integer, TreeSet<Integer>> map) {
        visited[v] = true;
        Queue<Integer> q = new LinkedList<>();
        if (map.get(v) == null) return ;
        for (Integer e : map.get(v)) {
            q.add(e);
        }

        while (!q.isEmpty()) {
            int key = q.poll();
            if (!visited[key]) {
                visited[key] = true;
                if (map.get(key) == null) continue ;
                for (int e : map.get(key)) {
                    q.add(e);
                }
                sb.append(key + " ");
            }
        }
    }
    public static void solution(int n, int m, int v, HashMap<Integer, TreeSet<Integer>> map) {
        visited = new boolean[n + 1];
        sb.append(v + " ");
        dfs(v, map);
        sb.append("\n" + v + " ");
        visited = new boolean[n + 1];
        bfs(v, map);
        System.out.println(sb);
    }
}