/**
 * [ 문제 설명 ]
 * "*"의 높이와 너비를 1이라고 했을 때, "*"을 이용해 직각 이등변 삼각형을 그리려고합니다.
 * 정수 n 이 주어지면 높이와 너비가 n 인 직각 이등변 삼각형을 출력하도록 코드를 작성해보세요.
 *
 * [ 제한사항 ]
 * 1 ≤ n ≤ 10
 *
 * [ 입력 #1 ]
 * 3
 *
 * [ 출력 #1 ]
 * *
 * **
 * ***
 *
 * [ 입출력 예 #1 ]
 * n이 3이므로 첫째 줄에 * 1개, 둘째 줄에 * 2개, 셋째 줄에 * 3개를 출력합니다.
 */

package Programmers.Lv0.Q24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24_PrintRightTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int idx = 0; idx < n; idx++){
            for(int idx2 = 0; idx2 < idx + 1; idx2++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

