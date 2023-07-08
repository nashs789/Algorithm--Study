package BaekJoon.QueueAndDeque.Q18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q18258_Queue2_sol2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        myQueue queue = new myQueue();

        for(int idx = 0; idx < cnt; idx++){
            String[] reg = br.readLine().split(" ");

            switch (reg[0]){
                case "push":
                    queue.push(Integer.parseInt(reg[1]));
                    break;
                case "pop":
                    sb.append(queue.pop().getData()).append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    sb.append(queue.isEmpty()).append('\n');
                    break;
                case "front":
                    sb.append(queue.front().getData()).append('\n');
                    break;
                case "back":
                    sb.append(queue.back().getData()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}

class myQueue<T>{
    private Node<T> first;
    private Node<T> last;
    int size = 0;

    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData(){
            return this.data;
        }
    }

    public void push(T data){
        Node<T> node = new Node<>(data);

        if(this.last != null){
            this.last.next = node;
        }

        this.last = node;

        if(this.first == null){
            this.first = node;
        }

        size++;
    }

    // 반환을 -1 해야해서 반환 타입을 Node<T>로 함
    public Node<T> pop(){
        if(this.first == null){
            return getNegNode();
        }

        Node<T> temp = this.first;
        this.first = this.first.next;

        if(this.first == null){
            this.last = null;
        }

        size--;
        return temp;
    }

    public Node<T> front(){
        if(this.first == null){
            return getNegNode();
        }

        return this.first;
    }

    public int isEmpty(){
        return this.first == null ? 1 : 0;
    }

    public Node<T> back(){
        if(this.last == null){
            return getNegNode();
        }

        return this.last;
    }

    public Node<T> getNegNode(){
        return new Node(-1);
    }

    public int size(){
        return this.size;
    }
}