package BaekJoon.Stack.Q17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Q17298_NGE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        Stack<Number> stack = new Stack<>();
        int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[TC];

        for(int idx = 0; idx < TC; idx++){
            int num = inp[idx];

            while(!stack.isEmpty() && stack.peek().num < num){
                answer[stack.pop().index] = num;
            }

            stack.push(new Number(num, idx));
        }

        while (!stack.isEmpty()){
            answer[stack.pop().index] = -1;
        }

        Arrays.stream(answer).forEach(e -> sb.append(e).append(' '));
        System.out.println(sb);
    }
}

class Number{
    int num;
    int index;

    public Number(int num, int index) {
        this.num = num;
        this.index = index;
    }
}