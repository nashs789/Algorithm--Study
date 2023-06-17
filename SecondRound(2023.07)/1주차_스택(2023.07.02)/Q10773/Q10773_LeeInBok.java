/**
 *  [ 효율성 ]
 *  - 메모리: 23896KB
 *  - 시간 : 252ms
 */

package BaekJoon.Stack.Q10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10773_Zero_sol2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int idx = 0; idx < TC; idx++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                stack.pop();
                continue;
            }

            stack.push(num);
        }

        System.out.println(stack.stream().mapToInt(e -> e).sum());
    }
}