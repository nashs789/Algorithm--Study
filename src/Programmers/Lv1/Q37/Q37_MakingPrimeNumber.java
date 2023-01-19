/**
 * [ 문제 설명 ]
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * [ 제한사항 ]
 * - nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
 * - nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
 *
 * [ 입출력 예 ]
 * nums	        result
 * [1,2,3,4]	1
 * [1,2,7,6,4]	4
 *
 * [ 입출력 예 #1 ]
 * [1,2,4]를 이용해서 7을 만들 수 있습니다.
 *
 * [ 입출력 예 #2 ]
 * [1,2,4]를 이용해서 7을 만들 수 있습니다.
 * [1,4,6]을 이용해서 11을 만들 수 있습니다.
 * [2,4,7]을 이용해서 13을 만들 수 있습니다.
 * [4,6,7]을 이용해서 17을 만들 수 있습니다.
 */

package Programmers.Lv1.Q37;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q37_MakingPrimeNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4, 11, 16, 46, 25, 26, 95, 153, 32};
        int answer = 0;

        Arrays.sort(nums);

        for(int idx1 = 0; idx1 < nums.length - 2; idx1++){
            for(int idx2 = idx1 + 1; idx2 < nums.length - 1; idx2++){
                for(int idx3 = idx2 + 1; idx3 < nums.length; idx3++){
                    if(isPrimeNumber(nums[idx1] + nums[idx2] + nums[idx3])){
                        answer++;
                    }
                }
            }
        }
    }

    public static boolean isPrimeNumber(int num){
        if(num % 2 == 0 || num % 3 == 0 || num % 5 == 0){
            return false;
        }

        for(int idx = 7; idx < num; idx++){
            if(num % idx == 0){
                return false;
            }
        }

        return true;
    }
}