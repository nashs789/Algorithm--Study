package Programmers.Lv3.Q;

import java.util.Arrays;

public class Q31_Immigration {
    public static void main(String[] args) {
        int n = 8;
        int[] times = {1, 9};
        long left = 0;
        long right = (long) n * times[times.length - 1];
        long mid = (left + right) / 2;
        long answer = right;

        while (right - mid > 0 && mid - left > 0) {
            long finalMid = mid;
            long sum = Arrays.stream(times).mapToLong(e -> finalMid / e).sum();

            if (answer >= sum) {
                answer = finalMid;
            }

            if (sum >= n) {
                right = mid;
            } else if (sum < n) {
                left = mid;
            }

            mid = (left + right) / 2;
        }

        for(long idx = left; idx <= right; idx++){
            long time = idx;
            long sum = Arrays.stream(times).mapToLong(e -> time / e).sum();

            if(sum >= n){
                answer = idx;
                break;
            }
        }

        System.out.println(answer);
    }
}