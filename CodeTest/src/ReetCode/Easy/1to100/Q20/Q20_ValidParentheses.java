/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * [ Example 1 ]
 * Input: s = "()"
 * Output: true
 *
 * [ Example 2 ]
 * Input: s = "()[]{}"
 * Output: true
 *
 * [ Example 3 ]
 * Input: s = "(]"
 * Output: false
 *
 * [ Constraints ]
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
package ReetCode.Easy.Q20;

public class Q20_ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        
        while(true){
            if(s.indexOf("()") == -1 && s.indexOf("[]")  == -1 && s.indexOf("{}")  == -1){
                break;
            }

            s = s.replaceAll("(\\(\\)|\\[\\]|\\{\\})", "");
        }

        // s.equals("") ? true : false;
    }
}