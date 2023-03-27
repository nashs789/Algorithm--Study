package BaekJoon.TimeComplexity.Q24265;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24264_TimeComplexity4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.println(n * (n - 1) / 2);
        System.out.print(2);
    }
}