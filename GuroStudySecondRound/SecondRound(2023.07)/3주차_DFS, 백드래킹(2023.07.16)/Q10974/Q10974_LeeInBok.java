/**
 *  [ 효율성 ]
 *  - 메모리: 35348KB
 *  - 시간 : 348ms
 */

package BaekJoon.BackTracking.Q10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10974_AllSequences {

    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;
    public static int[] seq;
    public static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        seq = new int[N];

        backTracking(0);
        System.out.println(sb);
    }

    public static void backTracking(int len){
        if(len == N){
            for(int n : seq){
                sb.append(n + " ");
            }
            sb.append('\n');
            return;
        }

        for(int idx = 1; idx <= N; idx++){
            if(!visited[idx]){
                visited[idx] = true;
                seq[len] = idx;
                backTracking(len + 1);
                visited[idx] = false;
            }
        }
    }
}