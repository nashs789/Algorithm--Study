/**
 *  [ 효율성 ]
 *  - 메모리: 14552KB
 *  - 시간 : 132ms
 */
package BaekJoon.String.Q1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q1427_SortInside {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr, Comparator.reverseOrder());

        for(int num : arr){
            sb.append(num);
        }

        System.out.println(sb);
    }
}