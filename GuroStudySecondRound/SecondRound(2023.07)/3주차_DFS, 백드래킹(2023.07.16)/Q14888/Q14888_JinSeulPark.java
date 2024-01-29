package baekjoon.dfs_back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14888
/**
 *  [ 효율성 ]
 *  - 메모리: 15696KB
 *  - 시간 : 132ms
 */
public class Q14888 {

    private static int MAX = Integer.MIN_VALUE;// 최댓값
    private static int MIN = Integer.MAX_VALUE;// 최솟값
    private static int[] operator = new int[4];// 연산자 개수
    private static int[] number;               // 숫자
    private static int N;                      // 숫자 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        // 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    private static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (operator[i] > 0) {
                // 해당연산자를 1 감소시킨다
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(num + number[idx], idx + 1);
                        break;
                    case 1:
                        dfs(num - number[idx], idx + 1);
                        break;
                    case 2:
                        dfs(num * number[idx], idx + 1);
                        break;
                    case 3:
                        dfs(num / number[idx], idx + 1);
                        break;
                }

                // 재귀 호출이 종료되면 다시 해당 연산자 개수를 복구
                operator[i]++;
            }
        }
    }

}
