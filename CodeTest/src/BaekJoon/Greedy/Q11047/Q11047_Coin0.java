/**
 * [ 문제 ]
 * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
 * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 *
 * [ 입력 ]
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 * 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 *
 * [ 출력 ]
 * 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
 *
 * [ 예제 입력 ]        [ 예제 출력 ]
 * 10 4200                6
 * 1
 * 5
 * 10
 * 50
 * 100
 * 500
 * 1000
 * 5000
 * 10000
 * 50000
 *
 * [ 예제 입력 ]        [ 예제 출력 ]
 * 10 4790               12
 * 1
 * 5
 * 10
 * 50
 * 100
 * 500
 * 1000
 * 5000
 * 10000
 * 50000
 */
package BaekJoon.Greedy.Q11047;

import java.io.*;

public class Q11047_Coin0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);
        int[] coins = new int[10];
        int cnt = 0;

        for(int idx = 0; idx < N; idx++){
            coins[idx] = Integer.parseInt(br.readLine());
        }

        for(int idx = N - 1; idx >= 0; idx--){
            if(K == 0){
                break;
            }

            int quot = K / coins[idx];

            if(quot > 0){
                cnt += quot;
                K -= coins[idx] * quot;
            }
        }

        System.out.println(cnt);
    }
}
