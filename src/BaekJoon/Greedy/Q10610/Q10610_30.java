package BaekJoon.Greedy.Q10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q10610_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr =  br.readLine().split("");
        int total = Arrays.stream(arr).mapToInt(Integer::parseInt).sum();

        Arrays.sort(arr, Comparator.reverseOrder());

        if(total % 3 != 0 || !arr[arr.length - 1].equals("0")){
            System.out.println(-1);
        } else {
            System.out.println(String.join("", arr));
        }
    }
}