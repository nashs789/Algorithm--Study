/**
* Author    : Lee In Bok 
* Date      : 2023.11.02(Thu)
* Spend Time: 02m 04s
* Runtime   : 0 ms (Beats 100%)
* Memory    : 40.4 MB (Beats 97.35%)
* Algoritm  : String
 */

public class Q66_PlusOne {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.plusOne(new int[]{9,9,9});

        for(int a : result){
            System.out.print(a + " ");
        }
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        for(int idx = digits.length - 1; idx >= 0; idx--){
            if(digits[idx] < 9){
                digits[idx]++;
                return digits;
            } 
            
            digits[idx] = 0;
        }

        int[] newArr = new int[digits.length + 1];
        newArr[0] = 1;

        return newArr;
    }
}