/**
 * [ 문제 설명 ]
 * 머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다. 
 * 피자를 나눠먹을 사람의 수 n이 주어질 때, 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 return 하는 solution 함수를 완성해보세요.
 *
 * [ 제한사항 ]
 * - 1 ≤ n ≤ 100
 * 
 * [ 입출력 예 ]
 * n	result
 * 7	1
 * 1	1
 * 15	3
 * 
 * [ 입출력 예 #1 ]
 * 7명이 최소 한 조각씩 먹기 위해서 최소 1판이 필요합니다.
 *
 * [ 입출력 예 #2 ]
 * 1명은 최소 한 조각을 먹기 위해 1판이 필요합니다.
 *
 * [ 입출력 예 #3 ]
 * 15명이 최소 한 조각씩 먹기 위해서 최소 3판이 필요합니다.
 */

package Programmers.Lv0.Q15;

public class Q15_SharePizza1 {
    public static void main(String[] args) {
        int n = 15;
        int pizza = 1;
        
        while(true){
            if(n - (pizza * 7) <= 0){
                break;
            }
            
            pizza++;
        }

        System.out.println("pizza = " + pizza);
    }
}