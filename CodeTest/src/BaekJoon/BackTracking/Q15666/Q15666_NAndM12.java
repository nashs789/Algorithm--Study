package BaekJoon.BackTracking.Q15666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q15666_NAndM12 {

    public static int N;
    public static int M;
    public static int[] arr;
    public static int[] seq;
    public static StringBuilder answer = new StringBuilder();
    public static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        seq = new int[M];

        backTracking(0, 0);
        System.out.print(answer);
    }

    public static void backTracking(int arrIdx, int seqIdx){
        if(seqIdx == M){
            StringBuilder sb = new StringBuilder();

            for(int n : seq){
                sb.append(n + " ");
            }

            String s = sb.toString();

            if(!set.contains(s)){
                set.add(s);
                answer.append(s + '\n');
            }

            return;
        }

        for(int idx = arrIdx; idx < N; idx++){
            seq[seqIdx] = arr[idx];
            backTracking(idx, seqIdx + 1);
        }
    }
}