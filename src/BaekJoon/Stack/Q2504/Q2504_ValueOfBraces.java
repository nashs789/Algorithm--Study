package BaekJoon.Stack.Q2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2504_ValueOfBraces {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().replace("()", "2").replace("[]", "3");
        Stack<Character> stack = new Stack<>();

        int mul = 1;
        int answer = 0;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            // 계산하는 부분
            if(c == '('){
                mul *= 2;
            } else if(c == ')'){
                mul /= 2;
            } else if(c == '['){
                mul *= 3;
            } else if(c == ']'){
                mul /= 3;
            } else {
                answer += Character.getNumericValue(c) * mul;
            }

            // 괄호만 스택에 넣는다(짝이 이루는지 확인)
            if(48 <= c && c <= 57) {
                continue;
            }

            // 스택에서 () [] 짝이 맞는지 확인
            if(!stack.isEmpty()){
                if(c == ')' && stack.peek() == '('){
                    stack.pop();
                    continue;
                }

                if(c == ']' && stack.peek() == '['){
                    stack.pop();
                    continue;
                }
            }

            stack.push(c);
        }

        System.out.println(stack.size() == 0 ? answer : "0");
    }
}