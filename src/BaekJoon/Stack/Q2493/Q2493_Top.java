package BaekJoon.Stack.Q2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493_Top {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Top> stack = new Stack<>();
        int idx = 1;

        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek().height < num){
                stack.pop();
            }

            sb.append(stack.isEmpty() ? 0 : stack.peek().idx).append(' ');
            stack.push(new Top(num, idx++));
        }

        System.out.println(sb);
    }
}

class Top{
    int height;
    int idx;

    public Top(int height, int idx) {
        this.height = height;
        this.idx = idx;
    }
}