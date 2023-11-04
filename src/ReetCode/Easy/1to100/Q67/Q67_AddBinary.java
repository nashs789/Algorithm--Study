/**
* Author    : Lee In Bok 
* Date      : 2023.11.04(Sat)
* Spend Time: 47m 50s
* Runtime   : 2 ms (Beats 55.51%)
* Memory    : 41 MB (Beats 70.52%)
* Algoritm  : String
 */

import java.util.ArrayList;
import java.util.List;

public class Q67_AddBinary {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.addBinary("1010", "1011");

        System.out.println(result);
    }
}

// class Solution {
//     public String addBinary(String a, String b) {
//         return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
//     }
// }

class Solution {

    public final String ZERO = "0";
    public final String ONE = "1";

    public String addBinary(String a, String b) {
        if(a.equals(ZERO) && b.equals(ZERO)){
            return a;
        }

        boolean carry = false;
        List<String> result = new ArrayList<>();
        int x = a.length() - 1;
        int y = b.length() - 1;

        while(0 <= x && 0 <= y){
            if(a.charAt(x) == '1' && b.charAt(y) == '1'){
                result.add(carry ? ONE : ZERO);
                carry = true;
            } else if(a.charAt(x) == '0' && b.charAt(y) == '0'){
                result.add(carry ? ONE : ZERO);
                carry = false;               
            } else {
                result.add(carry ? ZERO : ONE);
                carry = carry ? carry : false;
            }

            x--;
            y--;
        }

        carry = checkrest(a, x, carry, result);
        carry = checkrest(b, y, carry, result);

        if(carry || result.get(result.size() - 1).equals(ZERO)){
            result.add(ONE);
        }

        StringBuilder sb = new StringBuilder();

        for(String c : result){
            sb.append(c);
        }

        return sb.reverse().toString();
    }

    public boolean checkrest(String s, int idx, boolean carry, List<String> result){
        while(0 <= idx){
            if(s.charAt(idx) == '1'){
                result.add(carry ? ZERO : ONE);
                carry = carry ? carry : false;
            } else {
                result.add(carry ? ONE : ZERO);
                carry = false;
            }
            idx--;
        }

        return carry;
    }
}