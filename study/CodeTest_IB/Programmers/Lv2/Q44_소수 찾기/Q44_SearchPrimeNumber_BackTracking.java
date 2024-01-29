package Programmers.Lv2.Q44;

import java.util.HashSet;
import java.util.Set;

public class Q44_SearchPrimeNumber_BackTracking {

    private static Set<Integer> set = new HashSet<>();
    private static StringBuilder sb = new StringBuilder();
    private static String[] nums;
    private static boolean[] visited;
    private static int cnt = 0;

    public static void main(String[] args) {
        String numbers = "123";

        nums = numbers.split("");
        visited = new boolean[numbers.length()];

        dfs();

        for(int num : set){
            if(isPrimeNumber(num)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(){
        for(int idx = 0; idx < nums.length; idx++){
            if(!visited[idx]){
                visited[idx] = true;
                sb.append(nums[idx]);
                set.add(Integer.parseInt(sb.toString()));
                dfs();
                visited[idx] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    // 제곱근을 이용한 소수 판별 함수
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
}