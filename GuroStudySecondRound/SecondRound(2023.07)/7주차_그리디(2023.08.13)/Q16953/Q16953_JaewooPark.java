/**
 *  [ 효율성 ]
 *  - 메모리: 14264KB
 *  - 시간 : 124ms
 */

package Baekjoon.Q16953;

import java.util.*;
import java.io.*;

/* 
 * 1. a,b를 입력받습니다.
 * 2. solution(long a, long b, int count) 함수를 재귀로 돌립니다.
 * 3. a > b 보다 커질 경우, 재귀를 멈추고 같을 경우 min 값과 비교해 min값을 갱신합니다.
 * 4. 재귀함수는 스택형태로 쌓이기 때문에 마지막 min값을 리턴해줍니다.
*/


public class AtoB {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static long min = Long.MAX_VALUE;

    public static long solution(long a, long b, int count) {
        if (a > b) {
            return -1;
        } else if (a == b){
            return min = Math.min(min, count);
        }
        solution(a * 2, b, count + 1);
        solution(a * 10 + 1, b, count + 1);
        return min;
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        bw.write(String.valueOf(solution(a, b, 1) != Long.MAX_VALUE ? min : -1));
        bw.flush();
    }
}
