package 백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


/**
 *  [ 효율성 ]
 *  - 메모리: 23192KB
 *  - 시간 : 252ms
 */

public class 제로_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                stack.pop();
            }else{
                stack.push(num);
            }

        }
        System.out.println(stack.size() == 0 ? "0" : stack.stream().mapToInt(Integer::intValue).sum());

    }
}
