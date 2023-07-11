package BaekJoon.BackTracking.Q15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15654_NAndM5 {

    public static int N;
    public static int M;
    public static int[] arr;
    public static int[] seq;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        seq = new int[M];

        backTracking(0, 0);
        System.out.print(sb);
    }

    public static void backTracking(int arrIdx, int seqIdx){
        if(seqIdx == M){
            for(int num : seq){
                sb.append(num + " ");
            }
            sb.append('\n');
            return;
        }

        for(int idx = 0; idx < N; idx++){
            if(!visited[idx]){
                seq[seqIdx] = arr[idx];
                visited[idx] = true;
                backTracking(idx + 1, seqIdx + 1);
                visited[idx] = false;
            }
        }
    }
}