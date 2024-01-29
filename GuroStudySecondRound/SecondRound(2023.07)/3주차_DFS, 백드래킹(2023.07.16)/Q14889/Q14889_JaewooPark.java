/**
 *  [ 효율성 ]
 *  - 메모리: 31844KB
 *  - 시간 : 384ms
 */

package Baekjoon.July13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q14889_startlink {
    static int[][] arr;
    static int n;
    static int min = Integer.MAX_VALUE;
    static Integer[] values; 
    static Deque<Integer[]> dq;
    static boolean[] visited;

    public static void calculate() {
        Integer[] start = dq.pollFirst();
        Integer[] link = dq.pollLast();

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n / 2 - 1; i++) {
            for (int j = i + 1; j < n / 2; j++) {
                sum1 += arr[start[i]][start[j]];
                sum2 += arr[link[i]][link[j]];
            }
        }
        min = Math.min(min, Math.abs(sum1 - sum2));
    }
    
    public static void backtracking(int idx, int num) {
        if (idx == n / 2 + 1) {
            Integer[] tmp = values.clone();
            dq.add(tmp);
            return ;
        }
        for (int i = num + 1; i < n + 1; i++) {
            if (!visited[idx - 1]) {
                visited[idx - 1] = true;
                values[idx - 1] = i;
                backtracking(idx + 1, i);
                visited[idx - 1] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1][n + 1];
        visited = new boolean[n / 2 + 1];
        dq = new ArrayDeque<>();
        values = new Integer[n / 2];
        for (int i = 0; i < n / 2; i++) values[i] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                arr[i][j] += arr[j][i];
            }
        }
        backtracking(1, 0);
        int len = dq.size();
        for (int i = 0; i < len / 2; i++) calculate();
        System.out.println(min);
        sc.close();
    }
}

