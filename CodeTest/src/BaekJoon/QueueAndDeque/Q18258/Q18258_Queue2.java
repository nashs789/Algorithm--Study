package BaekJoon.QueueAndDeque.Q18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18258_Queue2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        Queue queue = new Queue();

        for(int idx = 0; idx < cnt; idx++){
            String[] reg = br.readLine().split(" ");

            switch (reg[0]){
                case "push":
                    queue.push(Integer.parseInt(reg[1]));
                    break;
                case "pop":
                    sb.append(queue.pop()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.empty()).append('\n');
                    break;
                case "front":
                    sb.append(queue.front()).append('\n');
                    break;
                case "back":
                    sb.append(queue.back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}

class Queue{
    private int[] arr;
    private int front;
    private int back;

    public Queue() {
        this.arr = new int[100000000];
        this.front = this.arr.length - 1;
        this.back = this.arr.length - 1;
    }

    void push(int n){
        if(this.back == -1 || this.front == -1){
            int[] newArr = new int[this.arr.length * 2];
            int newIdx = newArr.length - 1;

            for(int idx = this.front; idx <= this.back; idx--){
                newArr[newIdx--] = this.arr[idx];
            }

            this.front = newArr.length - 1;
            this.back = ++newIdx;
        }

        this.arr[this.back--] = n;
    }

    int pop(){
        if(this.empty() == 1){
            return -1;
        }

        return arr[this.front--];
    }

    int size(){
        return this.front - this.back;
    }

    int empty(){
        if(this.size() == 0){
            return 1;
        }

        return 0;
    }

    int front(){
        if(this.size() == 0){
            return -1;
        }

        return arr[this.front];
    }

    int back(){
        if(this.size() == 0){
            return -1;
        }

        return arr[this.back + 1];
    }
}