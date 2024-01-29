/**
 * [ 문제 설명 ]
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 *
 * [ 제한 사항 ]
 * 두 수는 1이상 1000000이하의 자연수입니다.
 *
 * [ 입출력 예 ]
 * n	m	return
 * 3	12	[3, 12]
 * 2	5	[1, 10]
 *
 * [ 입출력 예 #1 ]
 * 위의 설명과 같습니다.
 *
 * [ 입출력 예 #2 ]
 * 자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.
 */

package Programmers.Lv1.Q46;

public class Q46_GreatestCommonDivisorAndMultiple {
    public static void main(String[] args) {
        int n = 2;
        int m = 5;

        int[] answer = new int[2];
        int smaller = n > m ? n : m;

        for(int idx = 1; idx <= smaller; idx++){
            if(n % idx == 0 && m % idx == 0){
                answer[0] = idx;
            }
        }

        int num1 = n;
        int num2 = m;

        while(true){
            if(num1 == num2){
                answer[1] = num1;
                break;
            }

            if(num1 < num2){
                num1 += n;
            } else if(num1 > num2) {
                num2 += m;
            }
        }

        System.out.println("answer = " + answer[0]);
        System.out.println("answer = " + answer[1]);
    }
}
