/**
 * [ 접근 순서 ]
 * 1. 1부터 어디까지 반복해야 하는가?
 *     - 탈출문의 조건은?
 *
 * 2. 생성자가 없는 케이스는?
 *     - ex) 자연수가 1일 때
 *     - 생성자가 한 번도 갱신되지 않았다면 생성자가 없다고 판단
 *
 * 3. 문자열이 아닌 사칙연산을 이용
 *     - 문자열로 계산하면 효율이 떨어질 것으로 보임(잦은 캐스팅 혹은 문자열 연산 메소드 이용)
 *     - 사칙연산보다 효율을 높이려면 비트연산
 *
 *  [ 효율성 ]
 *  - 메모리: 14300KB
 *  - 시간 : 156ms
 */

package BaekJoon.BruteForce.Q2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2231_DivideAndSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int min = num; // 생성자는 언제나 입력값보다 작을 것

        for(int idx = 0; idx < num; idx++){
            int tempSum = idx;
            int tempNum = idx;

            while(tempNum != 0){
                tempSum += tempNum % 10;
                tempNum /= 10;
            }

            tempSum += tempNum;

            if(tempSum == num){
                min = idx;
                break;
            }
        }

        if(min == num){ // min 값이 한 번도 변하지 않은 경우 생성자가 존재하지 않는다
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}