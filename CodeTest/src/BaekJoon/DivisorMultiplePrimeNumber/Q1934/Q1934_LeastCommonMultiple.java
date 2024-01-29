package BaekJoon.DivisorMultiplePrimeNumber.Q1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1934_LeastCommonMultiple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());

        for(int idx = 0; idx < cnt; idx++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(lcm(x, y)).append('\n');
        }

        System.out.println(sb);
    }

    public static int gcd(int num1, int num2){
        if(num2 == 0){
            return num1;
        } else {
            return gcd(num2, num1 % num2);
        }
    }

    public static int lcm(int num1, int num2){
        return num1 * num2 / gcd(num1, num2);
    }
}
