package Programmers.Lv2.Q11;

public class Q11_LongJump {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }

    public static class Solution{
        public static long solution(int n){
            long[] dp = new long[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            for(int idx = 2; idx <= n; idx++){
                dp[idx] = (dp[idx - 2] + dp[idx - 1]) % 1234567;
            }

            return dp[n];
        }
    }
}