package BackJoon.스택;

import java.io.*;
import java.util.Stack;

/**
 * 스택 - 스택 수열
 * 메모리 : 26756KB
 * 시간 : 356ms
 */

public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int value = 0;
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
       for(int i=0; i<input; i++) {
           int number = Integer.parseInt(br.readLine());

           if(value < number) {
               for (int j=value+1; j<=number; j++) {
                   stack.push(j);
                   sb.append("+" + "\n");
               }
               value = number;
           }
           if(stack.peek() != number) {
               System.out.println("NO");
               return;
           }
           stack.pop();
           sb.append("-" + "\n");
       }
        System.out.println(sb);
    }
}
