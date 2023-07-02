package BackJoon.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 메모리 : 24284KB	
 * 시간 : 244ms
 */

public class Q10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<input; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        System.out.println(stack.stream().reduce(0,Integer::sum));
    }
}
