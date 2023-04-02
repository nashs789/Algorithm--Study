package BaekJoon.TimeComplexity.Q24266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24264_TimeComplexity5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.print(n * n * n + "\n3");
    }
}