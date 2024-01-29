package BaekJoon.BinarySearch.Q1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1654_CutLanLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int required = Integer.parseInt(st.nextToken());
        int[] lan = new int[cnt];

        long left = 1;
        long right = 2147483647;            // 2^31 - 1
        long answer = 0;

        for(int idx = 0; idx < cnt; idx++){
            lan[idx] = Integer.parseInt(br.readLine());
        }

        while (left <= right){
            long mid = (left + right) / 2;
            long sum = Arrays.stream(lan).map(e -> e / (int)mid).sum();

            if(sum >= required){
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
