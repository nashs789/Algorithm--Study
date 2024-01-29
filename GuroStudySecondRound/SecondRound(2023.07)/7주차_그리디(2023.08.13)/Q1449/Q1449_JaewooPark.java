/**
 *  [ 효율성 ]
 *  - 메모리: 14620KB
 *  - 시간 : 128ms
 */

package Baekjoon.Q1449;

import java.util.*;
import java.io.*;

public class repairPipe {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int count = 0;

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int a = 0;
        int b = 1;

        while (b < n) {
            if (arr[b] - arr[a] < l - 1) {
                b++;
            } else if (arr[b] - arr[a] == l - 1) {
                a = b + 1;
                b = a + 1;
                count++;
            } else {
                count++;
                a = b;
                b = a + 1;
            }
            if (a < n && b >= n) {
                count++;
                break;
            }
        }
        if (n == 1) {
            bw.write("1");
        } else {
            bw.write(Integer.toString(count));
        }

        bw.flush();

//        int tapes = 0;
//        int end = 0;
//        for (int i = 0; i < n; i++) {
//            if (arr[i] > end) {
//                tapes++;
//                end = arr[i] + l - 1;
//            }
//        }
//
//        System.out.println(tapes);
    }

}
