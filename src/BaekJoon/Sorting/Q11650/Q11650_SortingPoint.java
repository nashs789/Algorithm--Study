package BaekJoon.Sorting.Q11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q11650_SortingPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        int arr[][] = new int[cnt][2];

        for(int idx = 0; idx < cnt; idx++){
            st = new StringTokenizer(br.readLine());

            arr[idx][0] = Integer.parseInt(st.nextToken());
            arr[idx][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for(int[] a : arr){
            for(int b : a){
                sb.append(b).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}