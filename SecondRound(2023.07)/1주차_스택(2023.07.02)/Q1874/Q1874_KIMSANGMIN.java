package 백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 *  [ 효율성 ]
 *  - 메모리: 28548KB
 *  - 시간 : 388ms
 */
public class 스택수열_1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int testCaseCount = Integer.parseInt(br.readLine());

        int current = 1;

        boolean isPossible = true;

        for (int i = 0; i < testCaseCount; i++) {

            int targetNumber = Integer.parseInt(br.readLine());

            while (current <= targetNumber) {

                stack.push(current);
                sb.append("+").append("\n");
                current++;

            }

            if (stack.peek() == targetNumber) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                isPossible = false;
                break;
            }

        }

        if (isPossible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }
}
