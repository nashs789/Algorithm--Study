package BaekJoon.Stack.Q17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q17413_ReverseWord {

    public static Stack<Character> stack = new Stack<>();
    public static Queue<Character> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] str = br.readLine().toCharArray();
        boolean isTag = false;

        for(int idx = 0; idx < str.length; idx++){
            char c = str[idx];

            if(c == '<'){
                isTag = true;
                pop();
            } else if(c == '>'){
                isTag = false;
                queue.add(c);
                continue;
            } else if(c == ' '){
                pop();
                queue.add(c);
                continue;
            }

            if(isTag){
                queue.add(c);
                continue;
            }

            stack.push(c);
        }

        pop();

        for(char a : queue){
            sb.append(a);
        }
        System.out.println(sb);
    }

    public static void pop(){
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }
}
