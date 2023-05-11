package BaekJoon.BinarySearch.Q2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805_CutTrees {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int meter = Integer.parseInt(st.nextToken());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long left = 1;
        long right = 2000000000;
        long answer = 0;

        while (left <= right){
            long mid = (left + right) / 2;
            long finalMid = mid;
            long sum = Arrays.stream(arr).map(e -> (int) (e - finalMid)).filter(e -> e >= 0).sum();

            if(sum >= meter){
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}