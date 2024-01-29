package BaekJoon.QueueAndDeque.Q10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10866_Deque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        myDeque<Integer> myDeque = new myDeque<>();

        for(int idx = 0; idx < TC; idx++){
            st = new StringTokenizer(br.readLine());
            String reg = st.nextToken();

            switch (reg){
                case "push_front":
                    int frontNum = Integer.parseInt(st.nextToken());
                    myDeque.push_front(frontNum);
                    break;
                case "push_back":
                    int backNum = Integer.parseInt(st.nextToken());
                    myDeque.push_back(backNum);
                    break;
                case "pop_front":
                    sb.append(myDeque.pop_front().getData()).append('\n');
                    break;
                case "pop_back":
                    sb.append(myDeque.pop_back().getData()).append('\n');
                    break;
                case "size":
                    sb.append(myDeque.size()).append('\n');
                    break;
                case "empty":
                    sb.append(myDeque.empty()).append('\n');
                    break;
                case "front":
                    sb.append(myDeque.front().getData()).append('\n');
                    break;
                case "back":
                    sb.append(myDeque.back().getData()).append('\n');
                    break;
            }
        }

        System.out.print(sb);
    }
}

class myDeque<T>{
    private Node<T> firstHead;
    private Node<T> firstTail;
    private Node<T> lastHead;
    private Node<T> lastTail;
    private  int size = 0;

    class Node<T>{
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }

        T getData(){
            return this.data;
        }
    }

    void push_front(T data){
        Node<T> node = new Node<>(data);

        if(this.firstHead == null){
            this.firstTail = node;
        } else {
            this.firstHead.prev = node;
            node.next = this.firstHead;
        }

        this.firstHead = node;
        size++;
    }

    Node<T> pop_front(){
        if(this.firstHead == null){
            if(this.lastHead != null){
                Node<T> temp = this.lastTail;
                this.lastTail = this.lastTail.next;

                if(this.lastTail != null){
                    this.lastTail.prev = null;
                } else {
                    this.lastHead = null;
                }

                size--;
                return temp == null ? getNegNode() : temp;
            }
            return getNegNode();
        }

        Node<T> temp = this.firstHead;
        this.firstHead = this.firstHead.next;

        if(this.firstHead != null){
            this.firstHead.prev = null;
        } else {
            this.firstTail = null;
        }

        size--;
        return temp;
    }

    void push_back(T data){
        Node<T> node = new Node<>(data);

        if(this.lastHead == null){
            this.lastTail = node;
        } else {
            this.lastHead.next = node;
            node.prev = this.lastHead;
        }

        this.lastHead = node;
        size++;
    }

    Node<T> pop_back(){
        if(this.lastHead == null){
            if(this.firstHead != null){
                Node<T> temp = this.firstTail;
                this.firstTail = this.firstTail.prev;

                if(this.firstTail != null){
                    this.firstTail.next = null;
                } else {
                    this.firstHead = null;
                }

                size--;
                return temp == null ? getNegNode() : temp;
            }
            return getNegNode();
        }

        Node<T> temp = this.lastHead;
        this.lastHead = this.lastHead.prev;
        if(this.lastHead != null){
            this.lastHead.next = null;
        } else {
            this.lastTail = null;
        }

        size--;
        return temp;
    }

    int empty(){
        return this.size == 0 ? 1 : 0;
    }

    Node<T> front(){
        if(this.firstHead == null){
            if(this.lastHead == null){
                return getNegNode();
            }

            return this.lastTail;
        }

        return this.firstHead;
    }

    Node<T> back(){
        if(this.lastHead == null){
            if(this.firstHead == null){
                return getNegNode();
            }

            return this.firstTail;
        }
        return this.lastHead;
    }

    // T에 대한 대응은 안됨... -1 반환해야해
    public Node<T> getNegNode(){
        return new Node(-1);
    }

    public int size(){
        return this.size;
    }
}