/**
 *  [ 효율성 ]
 *  - 메모리: 357920KB
 *  - 시간 : 1680ms
 */

package BaekJoon.Sorting.Q10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10989_SortingNumbers3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        int arr[] = new int[10000001];
        int max = 0;

        for(int idx = 0; idx < cnt; idx++){
            int num = Integer.parseInt(br.readLine());
            arr[num] += 1;

            if(max < num){
                max = num;
            }
        }

        for(int i = 1; i < max + 1; i++){
            if(arr[i] == 0){
                continue;
            }

            for(int j = 0; j < arr[i]; j++){
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }
}
