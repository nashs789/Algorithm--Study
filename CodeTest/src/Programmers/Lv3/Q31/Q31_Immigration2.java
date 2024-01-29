package Programmers.Lv3.Q31;

public class Q31_Immigration2 {
    public static void main(String[] args) {
        int n = 8;
        int[] times = {1, 9};
        long left = 1;
        long right = (long) n * times[times.length - 1];
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for(int i = 0; i < times.length; i++){
                sum += mid / times[i];
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}