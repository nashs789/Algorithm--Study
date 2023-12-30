/**
* Author    : Lee In Bok 
* Date      : 2023.12.31(Sun)
* Problem   : 거스름돈
* Spend Time: 15m 01s
* Runtime   : 16.95 ms (Longest Time)
* Memory    : 80.8 MB (Most Spacious)
* Algoritm  : Dynamic Programming
 */

package Programmers.Lv3.Q2;

public class Q2 {
  public static void main(String[] args) {
    Solution s = new Solution();
    int res = s.solution(5, new int[]{1, 2, 5});

    System.out.println(res);
  }
}

class Solution {
  public int solution(int n, int[] money) {
    int[] dp = new int[n + 1];
    dp[0] = 1;

    for(int i = 0; i < money.length; i++){
      for(int j = money[i]; j < n + 1; j++){
        dp[j] += dp[j - money[i]];
      }
    }

    return dp[n];
  }
}