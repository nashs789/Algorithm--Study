package BackJoon.스택;

import java.io.*;
import java.util.Stack;

/**
 *  스택 
 * 	메모리 : 19440KB
 * 	시간 : 388ms
 */

public class Q10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for(int i=0; i<input; i++) {
            String inputValue = br.readLine();
            int lastIndex = stack.size()-1;
            if(inputValue.contains("push")) {
                String pushValue = inputValue.split(" ")[1];

                stack.push(pushValue);
            }
            else if (inputValue.equals("pop")) {
                if(stack.isEmpty()) {
                    bw.write("-1" + "\n");
                    bw.flush();
                } else {
                    bw.write(stack.get(lastIndex) + "\n");
                    stack.pop();
                    bw.flush();
                }
            }
            else if (inputValue.equals("size")) {
                bw.write(stack.size() + "\n");
                bw.flush();
            }
            else if (inputValue.equals("empty")) {
                if (stack.isEmpty()) {
                    bw.write("1" + "\n");
                    bw.flush();
                } else {
                    bw.write("0" + "\n");
                    bw.flush();
                }
            }
            else if (inputValue.equals("top")) {
                if(stack.isEmpty()) {
                    bw.write("-1" + "\n");
                    bw.flush();
                } else{
                    bw.write(stack.get(lastIndex) + "\n");
                    bw.flush();
                }
            }
        }
        bw.close();
    }
}
