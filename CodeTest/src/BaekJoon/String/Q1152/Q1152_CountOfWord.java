package BaekJoon.String.Q1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1152_CountOfWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;

        if(str.startsWith(" ")){
            answer--;
        }

        int len = str.split(" ").length;
        answer += len == 0 ? 1 : len;

        System.out.println(answer);
    }
}