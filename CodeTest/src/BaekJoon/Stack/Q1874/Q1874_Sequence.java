package BaekJoon.Stack.Q1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Q1874_Sequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int idx = 0; idx < cnt; idx++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        for(int idx = 1; idx <= cnt; idx++){
            stack.push(idx);
            sb.append('+').append('\n');

            while(!queue.isEmpty() && !stack.isEmpty() && Objects.equals(stack.peek(), queue.peek())){
                queue.poll();
                stack.pop();
                sb.append('-').append('\n');
            }
        }

        if(stack.isEmpty()){
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}