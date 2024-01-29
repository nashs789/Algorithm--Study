package BaekJoon.BackTracking.Q15657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15657_NAndM8 {

    public static int N;
    public static int M;
    public static int[] arr;
    public static int[] seq;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        seq = new int[M];

        backTracking(0);
        System.out.print(sb);
    }
    public static void backTracking(int seqIdx){
        if(seqIdx == M){
            for(int num : seq){
                sb.append(num + " ");
            }
            sb.append('\n');
            return;
        }

        for(int idx = 0; idx < N; idx++){
            if(seqIdx > 0 && seq[seqIdx - 1] > arr[idx]){
                continue;
            }

            seq[seqIdx] = arr[idx];
            backTracking(seqIdx + 1);
        }
    }
}