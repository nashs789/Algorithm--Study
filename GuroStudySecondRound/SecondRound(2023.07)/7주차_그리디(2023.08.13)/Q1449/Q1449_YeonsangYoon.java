package Baekjoon.Q1449;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
[효율성]
메모리 : 14284KB
시간 : 124ms
 */

public class Q1449_YeonsangYoon {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    static int solve(int n, int l, int[] holes){
        Arrays.sort(holes);

        int prev = holes[1];
        int cnt = 1;
        for(int i=2;i<=n;i++){
            if(holes[i]-prev >= l){
                cnt++;
                prev = holes[i];
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int[] arr = new int[n + 1];
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        out.write(String.valueOf(solve(n, l, arr)));
        out.flush();
        out.close();
    }
}
