/**
 * [ 접근 순서 ]
 * 1. 모든 경우의 수를 구하는 방법 생각 (그리드 탐색)
 * - 큰 수(5kg) 기준으로 시행 하기로 함
 *     - ex) 18 - (5 * 0)
 *     - ex) 18 - (5 * 1)
 *     - ex) 18 - (5 * 2)
 *     - ex) 18 - (5 * 3)
 *
 * 2. 구해진 모든 경우의 수에서 가장 작은 값 산출
 *
 *  [ 효율성 ]
 *  - 메모리: 17780KB
 *  - 시간 : 216ms
 */

package BaekJoon.Greedy.Q2839;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q2839_SugarDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int tempInput = input;

        Set<Integer> cntSet = new HashSet();
        int fiveKg = 5;
        int threeKg = 3;

        for(int idx = 0; idx <= input / fiveKg; idx++){
            tempInput -= (fiveKg * idx);

            if(tempInput % threeKg == 0){
                cntSet.add(tempInput / threeKg + idx);
            }

            tempInput = input;
        }

        System.out.println(    cntSet.size() == 0 ? -1 : cntSet.stream().max(Comparator.reverseOrder()).get()    );
    }
}
