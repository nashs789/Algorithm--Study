package BaekJoon.Stack.Q4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4949_BalancedWorld_sol2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] chArr;

        while((chArr = br.readLine().toCharArray())[0] != '.'){
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < chArr.length; i++){
                if(chArr[i] == '(' || chArr[i] == ')' || chArr[i] == '[' || chArr[i] == ']'){
                    if(chArr[i] == ')' && (!stack.isEmpty() && stack.peek() == '(')){
                        stack.pop();
                        continue;
                    }

                    if(chArr[i] == ']' && (!stack.isEmpty() && stack.peek() == '[')){
                        stack.pop();
                        continue;
                    }

                    stack.push(chArr[i]);
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