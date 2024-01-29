/**
* Author    : Lee In Bok 
* Date      : 2023.11.02(Thu)
* Spend Time: 02m 04s
* Runtime   : 0 ms (Beats 100%)
* Memory    : 40.4 MB (Beats 78.81%)
* Algoritm  : String
 */

public class Q58_LengthOfLastWord {
    public static void main(String[] args) {
        Solution s = new Solution();

        int result = s.lengthOfLastWord("a");
        System.out.println(result);
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.strip().split(" ");

        return arr[arr.length - 1].length();
    }
}

// class Solution {
//     public int lengthOfLastWord(String s) {
//         int cnt = 0;

//         for(int i = s.length() - 1; i >= 0; i--){
//             if(s.charAt(i) != ' '){
//                 cnt++;
//             } else {
//                 if(cnt > 0){
//                     return cnt;
//                 }
//             }
//         }

//         return cnt;
//     }
// }