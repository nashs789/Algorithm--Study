/**
 *  [ 효율성 ]
 *  - 메모리: 19088KB
 *  - 시간 : 200ms
 */

package BaekJoon.Stack.Q10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10828_Stack_sol2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack();

        for(int idx = 0; idx < TC; idx++){
            st = new StringTokenizer(br.readLine());
            String reg = st.nextToken();

            switch (reg){
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                case "pop":
                    sb.append(stack.pop()).append('\n');
                    break;
                case "size":
                    sb.append(stack.size()).append('\n');
                    break;
                case "empty":
                    sb.append(stack.empty()).append('\n');
                    break;
                case "top":
                    sb.append(stack.top()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}

class MyStack{
    int arr[];
    int curPoint;

    public MyStack() {
        this.arr = new int[3];
        this.curPoint = -1;
    }

    public void push(int x){
        if(this.curPoint == this.arr.length - 1){
            arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }

        this.arr[++this.curPoint] = x;
    }

    public int pop(){
        if(empty() == 1){
            return this.curPoint;
        }

        return this.arr[this.curPoint--];
    }

    public int size(){
        return this.curPoint + 1;
    }

    public int empty(){
        if(this.curPoint == -1){
            return 1;
        }

        return 0;
    }

    public int top(){
        if(empty() == 1){
            return this.curPoint;
        }

        return this.arr[this.curPoint];
    }
}