package baekjoon.dfs_back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  [ 효율성 ]
 *  - 메모리: 14148KB
 *  - 시간 : 136ms
 */
// https://www.acmicpc.net/problem/1182
public class Q1182 {

    private static int N, S;
    private static int count = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        // S가 0인 경우엔 공집합을 빼줘야 하기 때문에 count -1
        System.out.println(S == 0 ? count - 1 : count);

    }

    private static void dfs(int depth, int sum) {

        // depth 마지막 위치로 오면
        if (depth == N) {
            // 원하는 합계인지 체크
            if (sum == S) count++;
            return;
        }

        // 현재 위치의 원소를 선택 O
        dfs(depth + 1, sum + arr[depth]);

        // 현재 위치의 원소를 선택 X
        dfs(depth + 1, sum);
    }
}
