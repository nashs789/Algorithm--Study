package BaekJoon.Stack.Q10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10828_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        Stack stack = new Stack();

        for(int idx = 0; idx < cnt; idx++){
            String[] reg = br.readLine().split(" ");

            switch (reg[0]){
                case "push":
                    stack.push(Integer.parseInt(reg[1]));
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

        System.out.print(sb);
    }
}

class Stack{
    int capacity;
    int top;
    int[] arr;

    public Stack() {
        this(8);
    }

    public Stack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.arr = new int[capacity];
    }

    void push(int num){
        if(this.top + 1 == this.capacity){
            this.capacity *= 2;

            arr = Arrays.copyOf(arr, this.capacity);
        }

        arr[++top] = num;
    }

    int pop(){
        if(isEmpty()){
            return -1;
        }
        return this.arr[this.top--];
    }

    int size(){
        return this.top + 1;
    }

    int empty(){
        if(isEmpty()){
            return 1;
        }
        return 0;
    }

    int top(){
        if(isEmpty()){
            return -1;
        }
        return this.arr[this.top];
    }

    boolean isEmpty(){
        if(this.top == -1){
            return true;
        }
        return false;
    }
}
