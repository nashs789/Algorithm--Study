package BaekJoon.String.Q11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11720_SumOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        System.out.print(Arrays.stream(input).sum());
    }
}
