package BackJoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * [정렬]
 * 11650 - 좌표 정렬하기
 * 메모리 : 183384KB
 * 시간 : 1492ms
 */
public class Q11650 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = scanner.nextInt();
        int[][] arr = new int[input][2];
        for (int i=0; i<arr.length; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[0] == b[0]) {
               return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
      
        for (int i=0; i<arr.length;i++) {
            for (int j=0; j<arr[i].length; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
