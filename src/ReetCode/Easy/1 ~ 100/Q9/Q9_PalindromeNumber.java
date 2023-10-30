/**
 * Given an integer x, return true if x is apalindrome, and false otherwise.
 */

package ReetCode.Easy.Q9;

public class Q9_PalindromeNumber {
    public static void main(String[] args) {
        int x = -121;
        boolean answer;
        String strX = Integer.toString(x);
        String[] xArr = strX.split("");
        StringBuilder sb = new StringBuilder(String.join("", xArr));

        answer = sb.reverse().toString().equals(strX) == true ? true : false;

        System.out.println("answer = " + answer);
    }
}
