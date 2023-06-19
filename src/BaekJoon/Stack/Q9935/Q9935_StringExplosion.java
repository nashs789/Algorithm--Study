package BaekJoon.Stack.Q9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9935_StringExplosion {

    public static String str;
    public static String bomb;
    public static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        bomb = br.readLine();

        for(int i = 0; i < str.length(); i++){
            boolean isSame = true;
            stack.push(str.charAt(i));

            if(stack.size() < bomb.length()){
                continue;
            }

            for(int j = 0; j < bomb.length(); j++){
                int idx = stack.size() - bomb.length() + j;

                if(stack.get(idx) != bomb.charAt(j)){
                    isSame = false;
                    break;
                }
            }

            if(isSame){
                for(int j = 0; j < bomb.length(); j++){
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        str = sb.reverse().toString().replace(bomb, "");

        System.out.println(str.equals("") ? "FRULA" : str);
    }
}

// 11:38 - 1:10