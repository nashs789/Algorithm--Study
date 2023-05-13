package BaekJoon.Stack.Q10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10773_Zero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for(int idx = 0; idx < cnt; idx++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        while (!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}