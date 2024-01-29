package BaekJoon.Stack.Q9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012_Parenthesis_sol2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < TC; i++){
            Stack<String> stack = new Stack<>();
            String[] arr = br.readLine().split("");

            for(int j = 0; j < arr.length; j++){
                if(arr[j].equals(")") && (!stack.isEmpty() && stack.peek().equals("("))){
                    stack.pop();
                    continue;
                }
                stack.push(arr[j]);
            }

            if(stack.isEmpty()){
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);
    }
}