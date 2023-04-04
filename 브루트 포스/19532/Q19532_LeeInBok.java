package BaekJoon.BruteForce.Q19532;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19532_LeeInBok {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        long e = Long.parseLong(st.nextToken());
        long f = Long.parseLong(st.nextToken());

        for(int i = -999; i <= 999; i++){
            for(int j = -999; j <= 999; j++){
                if(c == (a * i) + (b * j) && f == (d * i) + (e * j)){
                    sb.append(i).append(' ').append(j);
                }
            }
        }

        System.out.println(sb);
    }
}