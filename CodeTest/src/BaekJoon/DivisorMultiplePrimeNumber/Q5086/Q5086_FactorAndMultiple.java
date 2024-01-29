package BaekJoon.DivisorMultiplePrimeNumber.Q5086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5086_FactorAndMultiple {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0){
                break;
            }

            if(a < b && b % a == 0){
                sb.append("factor").append("\n");
            } else if(a > b && a % b == 0){
                sb.append("multiple").append("\n");
            } else {
                sb.append("neither").append("\n");
            }
        }

        System.out.print(sb);
    }
}