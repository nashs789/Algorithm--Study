/**
 *  [ 효율성 ]
 *  - 메모리: 94260KB
 *  - 시간 : 776ms
 */

package BaekJoon.Sorting.Q2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2750_SortNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for(int idx = 0; idx < N; idx++){
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Comparator.naturalOrder());

        for(Integer n : list){
            sb.append(n).append('\n');
        }

        System.out.println(sb);
    }
}
