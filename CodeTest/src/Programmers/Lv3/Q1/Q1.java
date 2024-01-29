/**
* Author    : Lee In Bok 
* Date      : 2023.12.29(Fri)
* Spend Time: 17m 53s
* Runtime   : 601.21 ms (Longest Time)
* Memory    : 85.2 MB (Most Spacious)
* Algoritm  : Palindrome
 */

package Programmers.Lv3.Q1;

public class Q1 {
  public static void main(String[] args) {
    Solution s = new Solution();
    int res = s.solution("abaaaa");

    System.out.println(res);
  }
}

class Solution {
  public int solution(String s) {
      int ans = 1;
      char[] arr = s.toCharArray();

      for(int i = 0; i < s.length(); i++){
        for(int j = i + 1; j < s.length(); j++){
          if(chkPalindrome(arr, i, j)){
            ans = Math.max(ans, j - i + 1);
          }
        }
      }

      return ans;
  }

  public boolean chkPalindrome(char[] arr, int srt, int end){
    while(srt < end){
      if(arr[srt++] != arr[end--]){
        return false;
      }
    }

    return true;
  }
}