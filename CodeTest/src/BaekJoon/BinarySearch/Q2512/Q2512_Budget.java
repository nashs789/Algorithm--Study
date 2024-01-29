package BaekJoon.BinarySearch.Q2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2512_Budget {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(br.readLine());
        int[] budgets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int budget = Integer.parseInt(br.readLine());
        int left = 0;
        int right = Arrays.stream(budgets).max().getAsInt();
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int sum = Arrays.stream(budgets).map(n -> n < mid ? n : mid).sum();

            if(sum <= budget){
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
