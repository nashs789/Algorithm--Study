/**
 *  [ 효율성 ]
 *  - 메모리: 56184KB
 *  - 시간 : 2120ms
 */

package Baekjoon.July11;

import java.util.Scanner;

public class Q_10974_permutation {
    static boolean[] visited;
    static int[] arr;
    static int n;
    
    public static boolean isVisit() {
        for (var e : visited) {
            if (!e) return false;
        }
        return true;
    }
    public static void dfs(int idx) {
        if (isVisit()) {
            for (var e : arr) {
                System.out.print(e + " ");
            }
            System.out.println();
            return ;
        }
        else if (idx == n) return ;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = i + 1;
                dfs(idx + 1);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n];
        arr = new int[n];
        dfs(0);
        sc.close();
    }
}


