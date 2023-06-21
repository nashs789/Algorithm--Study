package BaekJoon.Stack.Q5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q5397_KeyLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int i = 0; i < TC; i++){
            Stack<Character> mainStack = new Stack<>();
            Stack<Character> subStack = new Stack<>();
            String str = br.readLine();

            for(int j = 0; j < str.length(); j++){
                char c = str.charAt(j);

                switch (c){
                    case '<':
                        if(!mainStack.isEmpty()){
                            subStack.push(mainStack.pop());
                        }
                        break;
                    case '>':
                        if(!subStack.isEmpty()){
                            mainStack.push(subStack.pop());
                        }
                        break;
                    case '-':
                        if(!mainStack.isEmpty()){
                            mainStack.pop();
                        }
                        break;
                    default:
                        mainStack.push(c);
                }
            }

            while(!subStack.isEmpty()){
                mainStack.push(subStack.pop());
            }

            for(char c : mainStack){
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}