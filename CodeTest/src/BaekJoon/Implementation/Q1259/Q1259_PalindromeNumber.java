package BaekJoon.Implementation.Q1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1259_PalindromeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while(!(str = br.readLine()).equals("0")){
            String answer = "yes";
            int len = str.length();

            for(int idx = 0; idx < len; idx++){
                if(str.charAt(idx) != str.charAt((len - 1) - idx)){
                    answer = "no";
                    break;
                }
            }

            sb.append(answer).append('\n');
        }

        System.out.println(sb);
    }
}
