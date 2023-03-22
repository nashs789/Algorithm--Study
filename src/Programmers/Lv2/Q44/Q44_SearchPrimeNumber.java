package Programmers.Lv2.Q44;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q44_SearchPrimeNumber {

    private static Set<Integer> allNumSet = new HashSet<>();
    private static String[] nums;
    private static int cnt = 0;

    public static void main(String[] args) {
        String numbers = "143";
        nums = numbers.split("");

        for(int i = 0; i < nums.length; i++){
            // ex) 주어진 숫자가 123 일 때
            // 3번의 재귀함수 호출로 1, 2, 3이 가장 먼저올 수 있는 경우의 수 산출
            initSet(i, nums[i], new boolean[numbers.length()]);
        }

        for(int num : allNumSet){
            if(isPrimeNumber(num)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    /**
     * 제곱근을 이용한 소수 판별 함수
     * @param num
     * @return
     */
    private static boolean isPrimeNumber(int num){
        if(num <= 1){
            return false;
        }

        int sqrt = (int)Math.sqrt(num) + 1;

        for(int idx = 2; idx < sqrt; idx++){
            if(num % idx == 0){
                return false;
            }
        }

        return true;
    }

    /**
     * HashSet 에 조합 가능한 숫자들을 넣어주는 재귀함수
     * @param i: 인덱스
     * @param number: 조합된 숫자
     * @param done: 숫자를 조합 할 때 이미 사용한 숫자는 true, 사용하지 않은 숫자는 false
     */
    private static void initSet(int i, String number, boolean[] done) {
        allNumSet.add(Integer.parseInt(number));
        done[i] = true;

        if(isAllTrue(done)){
            return;
        }

        for(int j = 0; j < done.length; j++){
            if(done[j]){
                continue;
            }

            initSet(j, number + nums[j], Arrays.copyOf(done, done.length));
        }
    }

    /**
     * 모든 숫자를 조합에 사용했는지 확인하는 함수(재귀함수 탈출 조건)
     * @param done
     * @return
     */
    private static boolean isAllTrue(boolean[] done){
        for(int idx = 0; idx < done.length; idx++){
            if(!done[idx]){
                return false;
            }
        }
        return true;
    }
}