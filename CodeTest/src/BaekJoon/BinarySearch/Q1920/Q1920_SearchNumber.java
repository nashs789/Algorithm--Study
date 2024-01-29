package BaekJoon.BinarySearch.Q1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1920_SearchNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt1 = Integer.parseInt(br.readLine());
        long[] range = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();
        int cnt2 = Integer.parseInt(br.readLine());
        long[] nums = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        for(long n : nums){
            int left = 0;
            int right = range.length - 1;

            while(left <= right){
                int mid = (left + right) / 2;

                if(n < range[mid]){
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            }

            if(right < 0){
                right = left;
            }

            if(range[right] == n){
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
