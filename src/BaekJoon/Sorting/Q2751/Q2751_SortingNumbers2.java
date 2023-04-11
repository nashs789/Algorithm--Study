package BaekJoon.Sorting.Q2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2751_SortingNumbers2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());    // 1 <= N <= 1,000,000
        boolean[] negNums = new boolean[1000001];   // -1,000,000 <= number <= 1,000,000
        boolean[] posNums = new boolean[1000001];

        for(int idx = 0; idx < N; idx++){
            int num = Integer.parseInt(br.readLine());

            if(num >= 0){
                posNums[num] = true;
            } else {
                negNums[Math.abs(num)] = true;
            }
        }

        for(int idx = negNums.length - 1; idx >= 0 ; idx--){
            if(negNums[idx]){
                sb.append(idx * -1).append('\n');
            }
        }

        for(int idx = 0; idx < posNums.length; idx++){
            if(posNums[idx]){
                sb.append(idx).append('\n');
            }
        }

        System.out.print(sb);
    }
}