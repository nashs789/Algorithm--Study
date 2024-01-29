package Programmers.Lv2.Q8;

import java.util.Stack;

public class Q8_properParenthesis {
    public static void main(String[] args) {
        String s = "(()(";
        Stack<Character> stack = new Stack<>();

        for(int idx = 0; idx < s.length(); idx++){
            char c = s.charAt(idx);

            if(!stack.isEmpty()){
                if(c == ')' && stack.peek() == '('){
                    stack.pop();
                    continue;
                }
            }

            stack.push(c);
        }

        System.out.println(stack.isEmpty());
    }
}
