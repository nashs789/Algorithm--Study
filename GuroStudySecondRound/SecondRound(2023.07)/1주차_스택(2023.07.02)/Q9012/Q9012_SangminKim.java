package 백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringJoiner;

/**
 *  [ 효율성 ]
 *  - 메모리: 14492KB
 *  - 시간 : 132ms
 */

public class 괄호_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner("\n");
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String gwalHo = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean result = true;

            for (int j = 0; j < gwalHo.length(); j++) {

                char ch = gwalHo.charAt(j);

                if(ch =='('){
                    stack.push(ch);
                }else if(ch ==')'){
                    if (stack.isEmpty()){
                        result = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                result = false;
            }
                sj.add(result ? "YES" : "NO");
        }
        System.out.println(sj.toString());
    }

}
