package BackJoon.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * 스택 - 균형잡힌 세상
 * 메모리 : 49484KB
 * 시간 : 576ms
 */

public class Q4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] checkText = { "[", "]", "(", ")" };


        while (true) {
            String text = br.readLine();
            if(text.equals(".")) {
                break;
            }
            Stack<String> stack = new Stack<>();
            String[] word = text.split("");

            for (int i=0; i< word.length; i++) {
                if(Arrays.asList(checkText).contains(word[i])) {
                    if(stack.size() > 0) {
                        if(word[i].equals("(") || word[i].equals("[")) {
                            stack.push(word[i]);
                        }
                        else if (word[i].equals(")")) {
                            if(stack.peek().equals("(")) {
                                stack.pop();
                            } else {
                                stack.push(word[i]);
                            }
                        } else if (word[i].equals("]")) {
                            if(stack.peek().equals("[")) {
                                stack.pop();
                            } else {
                                stack.push(word[i]);
                            }
                        }
                    } else {
                        if(word.equals(")") || word.equals("]")) {
                            stack.push(word[i]);
                            break;
                        } else {
                            stack.push(word[i]);
                        }
                    }

                }
            }
            System.out.println(stack.isEmpty() ? "yes" : "no" );
        }
    }
}
