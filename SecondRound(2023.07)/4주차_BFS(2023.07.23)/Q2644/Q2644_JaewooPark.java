/**
 *  [ 효율성 ]
 *  - 메모리: 17820KB
 *  - 시간 : 212ms
 */


package Baekjoon.Q2644;

import java.util.*;

public class Q2644_degree {
    static int n, m;
    static int num1, num2;
    static int count;
    static HashMap<Integer, LinkedList<Integer>> map;
    static boolean[] visited;

    public static void dfs(int num, int idx) {
        if (num == num2) {
            count = idx;
            return ;
        }
        visited[num] = true;
        if (map.getOrDefault(num, null) == null) {
            return ;
        }
        for (int e : map.get(num)) {
            if (!visited[e]) {
                visited[e] = true;
                dfs(e, idx + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new HashMap<>();
        n = sc.nextInt();
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();

            map.computeIfAbsent(key, k -> new LinkedList<>()).add(value);
            map.computeIfAbsent(value, k -> new LinkedList<>()).add(key);
        }

        dfs(num1, 1);
        if (count == 0) System.out.println(-1);
        else System.out.println(count - 1);
        sc.close();
    }
}