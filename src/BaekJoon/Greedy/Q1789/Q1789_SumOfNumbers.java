/**
 * 문제
 * 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
 *
 * 입력
 * 첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.
 *
 * 출력
 * 첫째 줄에 자연수 N의 최댓값을 출력한다.
 *
 * [ 예제 입력 ]                [ 예제 출력 ]
 *     200                        19
 */

package BaekJoon.Greedy.Q1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1789_SumOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        int lastIdx = 0;
        long sum = 0;

        for(int idx = 1; idx <= S; idx++){
            sum += idx;

            if(sum >= S){
                lastIdx = sum > S ? idx - 1: idx;
                break;
            }
        }

        System.out.println(lastIdx);
    }
}