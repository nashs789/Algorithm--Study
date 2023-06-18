package BaekJoon.Stack.Q1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1406_Editor {

    public static Stack<Character> editor;
    public static Stack<Character> temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        editor = new Stack<>();
        temp = new Stack<>();
        String str = br.readLine();
        int TC = Integer.parseInt(br.readLine());

        for(int idx = 0; idx < str.length(); idx++){
            editor.push(str.charAt(idx));
        }

        for(int idx = 0; idx < TC; idx++){
            st = new StringTokenizer(br.readLine());
            String reg = st.nextToken();

            switch (reg){
                case "L":
                    L();
                    break;
                case "D":
                    D();
                    break;
                case "B":
                    B();
                    break;
                case "P":
                    char c = st.nextToken().charAt(0);

                    P(c);
                    break;
            }
        }

        while(!editor.isEmpty()){
            temp.push(editor.pop());
        }

        while(!temp.isEmpty()){
            sb.append(temp.pop());
        }

        System.out.println(sb);
    }
    public static void L(){
        if(!editor.isEmpty()){
            temp.push(editor.pop());
        }
    }

    public static void D(){
        if(!temp.isEmpty()){
            editor.push(temp.pop());
        }
    }

    public static void B(){
        if(!editor.isEmpty()){
            editor.pop();
        }
    }

    public static void P(char c){
        editor.push(c);
    }
}