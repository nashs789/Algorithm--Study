/**
 *  [ 효율성 ]
 *  - 메모리: 14308KB
 *  - 시간 : 124ms
 */

package Baekjoon.Q1339;

import java.util.*;
import java.io.*;

/**
 * 1. 각 char 문자당 자릿수에 위치한 int 값을 입력받을 배열 int[] arr = new int[26]을 생성합니다.
 * 2. br.readLine().toCharArray()를 통해 char형 배열로 String을 받고, pow를 통해 앞서 말한 값을 int형 배열에 저장합니다.
 * 3. 이를 정렬하여 마지막 값부터 9,8... 식으로 곱하여 더해줍니다.
 */

public class findWord {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        int answer = 0;
        int idx = 25;

        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            int pow = (int) Math.pow(10, str.length - 1);

            for (char e : str) {
                arr[e - 'A'] += pow;
                pow /= 10;
            }
        }

        Arrays.sort(arr);

        for (int i = 9; i >= 0; i--) {
            answer += i * arr[idx--];
            //System.out.println(i + "-> " + arr[idx + 1] + " , " + answer);
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }
}
