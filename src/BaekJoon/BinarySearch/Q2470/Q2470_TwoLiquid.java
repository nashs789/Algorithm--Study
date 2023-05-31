package BaekJoon.BinarySearch.Q2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2470_TwoLiquid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int liquid1 = arr[left];
        int liquid2 = arr[right];
        int mix = Math.abs(liquid1 + liquid2);

        while(left < right){
            int sum = Math.abs(arr[left] + arr[right]);

            if(sum < mix){
                mix = sum;
                liquid1 = arr[left];
                liquid2 = arr[right];
            }

            if(arr[left] + arr[right] > 0){
                right--;
            } else {
                left++;
            }
        }

        System.out.println(liquid1 + " " + liquid2);
    }
}