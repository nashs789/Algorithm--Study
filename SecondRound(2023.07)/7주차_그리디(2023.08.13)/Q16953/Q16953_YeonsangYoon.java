package Baekjoon.Q16953;

import java.io.*;
import java.util.StringTokenizer;

/*
[효율성]
메모리 : 14232KB
시간 : 124ms
 */

public class Q16953_YeonsangYoon {
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    static long a, b;
    static long ans = Long.MAX_VALUE;

    static void solve(long cur, long cnt){
        if(cur == b){
            ans = Math.min(ans, cnt);
        }
        else if(cur > b){
            return;
        }

        solve(cur*2, cnt+1);
        solve(cur*10+1, cnt+1);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(in.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        solve(a, 0);

        out.write(String.valueOf((ans==Long.MAX_VALUE) ? -1 : ans+1));
        out.flush();
        out.close();
    }
}
