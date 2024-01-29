/**
 * 두 가지로 풀이 방식으로 풀었는데 3개의 수가 정해져있기 때문에 단순 반복문이 가장 빠른 방법인듯 싶다.
 * 재귀함수 호출로 인한 메모리 사용량은 알겠는데 시간도 많이 걸릴거라고는 생각 못했는데..
 * 시간이 더 들어간 이유는 정확히 모르겠다.
 *
 *                      [ 메모리 ]         [ 시간 ]
 *  sol1_backTracking   14340KB           123ms
 *  sol2_Roop           105346KB          336ms
 */

package BaekJoon.BruteForce.Q2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2798_LeeInBok {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 0;

        for(int i = 0; i < N - 2; i++){
            for(int j = i + 1; j < N - 1; j++){
                for(int k = j + 1; k < N; k++){
                    int sum = nums[i] + nums[j] + nums[k];

                    if(max < sum && M >= sum){
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}