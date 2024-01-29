/**
 *  [ 효율성 ]
 *  - 메모리: 14440KB
 *  - 시간 : 152ms
 */

package BaekJoon.BackTracking.Q1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1182_Subsequence {

    public static int N;
    public static int S;
    public static int answer = 0;
    public static int seq[];
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        seq = new int[N];

        seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        backTracking(0, 0);

        System.out.println(answer);
    }

    public static void backTracking(int idx, long sum){
        for(int i = idx; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                sum += seq[i];

                if(sum == S){
                    answer++;
                }

                backTracking(i + 1, sum);
                sum -= seq[i];
                visited[i] = false;
            }
        }
    }
}