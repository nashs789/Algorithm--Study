package BaekJoon.Stack.Q4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4949_BalancedWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] chArr;

        while((chArr = br.readLine().toCharArray())[0] != '.'){
            Stack<Character> stack = new Stack<>();

            for(char c : chArr){
                if(c == '(' || c == '['){
                    stack.push(c);
                }

                if(c == ')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    } else {
                        stack.push(c);
                        break;
                    }
                }

                if(c == ']'){
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    } else {
                        stack.push(c);
                        break;
                    }
                }
            }

            if(stack.isEmpty()){
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
        }

        System.out.println(sb);
    }
}