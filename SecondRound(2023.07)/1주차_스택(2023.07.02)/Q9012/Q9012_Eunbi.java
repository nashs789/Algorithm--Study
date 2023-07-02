package BackJoon.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 *  스택 - 괄호
 * 	메모리 : 150240KB
 * 	시간 : 156ms
 */

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input; i++) {
            Stack<String> stack = new Stack<>();
            String[] arr = br.readLine().split("");

            for(int j=0; j< arr.length; j++) {
                if(stack.size() > 0 && stack.peek().equals("(") && arr[j].equals(")")) {
                    stack.pop();
                } else {
                    stack.push(arr[j]);
                }
            }
            System.out.println(stack.size() == 0 ? "YES" : "NO");
        }
    }
}
