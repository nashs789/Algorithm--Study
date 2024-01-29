/**
* Author    : Lee In Bok 
* Date      : 2023.12.30(Sat)
* Spend Time: 09m 27s
* Runtime   : 3.91 ms (Longest Time)
* Memory    : 77.3 MB (Most Spacious)
* Algoritm  : Dynamic Programming
*/

package Programmers.Lv2.Q5;

public class Q5 {
  public static void main(String[] args) {
    Solution s = new Solution();
    int res = s.solution(4);

    System.out.println(res);
  }  
}

class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
          dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        }

        return dp[n];
    }
}