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

/*
8
empty
push_front 1
empty
pop_back
size
front
back
empty

1
0
1
0
-1
-1
1

8
empty
push_back 1
empty
pop_back
size
front
back
empty

1
0
1
0
-1
-1
1


19
push_front 1
front
back
push_back 999
front
back
pop_back
front
back
push_front 3
front
back
push_back 123
back
pop_back
pop_back
empty
pop_back
empty

1
1
1
999
999
1
1
3
1
123
123
1
0
3
1

29
empty
push_front 1
front
push_front 2
back
pop_back
push_front 3
front
push_front 4
pop_back
push_front 5
pop_front
push_back 1
empty
push_back 2
pop_back
pop_back
push_back 3
push_back 4
pop_front
pop_front
push_back 5
emtpy
size
pop_front
pop_front
pop_front
pop_front
pop_front

1
1
1
1
3
2
5
0
2
1
4
3
3
3
4
5
-1
-1

16
push_front 1
pop_back
push_back 66
push_front 2
pop_back
push_back 77
push_front 3
pop_back
push_back 88
pop_front
pop_front
pop_front
pop_front
pop_front
pop_front
pop_front

1
66
77
3
2
88
-1
-1
-1
-1

22
push_front 1
push_front 2
pop_back
push_front 3
push_front 4
pop_back
push_front 5
pop_front
push_back 1
push_back 2
pop_back
pop_back
push_back 3
push_back 4
pop_front
pop_front
push_back 5
pop_front
pop_front
pop_front
pop_front
pop_front
1
2
5
2
1
4
3
3
4
5
-1
-1

15
push_front 1
push_front 2
pop_back
push_front 3
push_front 4
pop_back
push_front 5
pop_front
push_back 1
push_back 2
pop_front
pop_front
pop_front
pop_front
pop_front

1
2
5
4
3
1
2
-1

15
push_front 1
push_front 2
push_front 3
push_front 4
push_front 5
push_back 1
push_back 2
pop_front
pop_front
pop_front
pop_front
pop_front
pop_front
pop_front
pop_front

5
4
3
2
1
1
2
-1

26
push_front 1
front
back
pop_back
push_front 2
back
front
push_front 3
back
pop_back
pop_back
front
push_back 33
back
pop_back
pop_front
front
push_back 44
back
pop_front
front
push_back 55
back
front
pop_front
pop_back

1
1
1
2
2
2
2
3
-1
33
33
-1
-1
44
44
-1
55
55
55
-1

40
empty
push_front 1
push_back 33
empty
front
size
push_front 2
push_back 44
push_front 25
empty
front
push_front 15
push_front 72
empty
push_front 3
front
push_back 55
push_back 66
empty
size
push_back 77
front
push_front 4
back
pop_back
pop_back
pop_back
pop_back
pop_back
size
pop_back
pop_back
pop_back
pop_front
pop_front
pop_front
pop_front
pop_front
pop_back
pop_back

1
0
1
2
0
25
0
3
0
10
3
77
77
66
55
44
33
7
1
2
25
4
3
72
15
-1
-1
-1

15
push_back 1
push_front 2
front
back
size
empty
pop_front
pop_back
pop_front
size
empty
pop_back
push_front 3
empty
front
2
1
2
0
2
1
-1
0
1
-1
0
3

4
push_front 2
push_front 3
push_front 4
pop_back

2

3
push_front 1
pop_back
back

1
-1

76
empty
push_front 2
push_back 11
back
push_front 5
front
empty
push_back 22
size
pop_back
front
push_back 33
push_back 44
pop_back
pop_front
push_back 55
push_back 66
front
back
pop_front
push_front 3
push_front 1
pop_back
front
pop_back
push_front 6
pop_front
pop_back
pop_back
pop_front
front
pop_back
pop_front
push_back 77
back
push_back 88
push_front 7
pop_front
back
pop_front
push_front 8
push_back 99
push_front 9
push_back 999
back
push_front 10
empty
pop_front
front
pop_back
pop_back
push_front 11
pop_back
size
pop_back
pop_front
push_back 888
push_back 777
push_front 1000
pop_front
pop_front
back
push_front 100
push_front 10000
back
front
push_back 666
pop_back
pop_back
back
pop_back
size
pop_back
size
empty
back

1
11
5
0
4
22
5
44
5
2
66
2
66
1
55
6
33
11
1
3
3
3
77
7
88
77
999
0
10
9
999
99
88
2
8
11
1000
9
777
777
10000
666
777
888
888
1
100
0
1
10000

17
push_front 1
push_front 2
push_front 3
push_front 4
push_front 5
size
pop_back
size
pop_front
size
pop_back
size
pop_front
size
pop_back
size
empty

5
1
4
5
3
2
2
4
1
3
0
1

20
push_front 1
push_front 2
pop_back
pop_back
pop_back
pop_back
pop_back
pop_back
size
push_front 3
push_front 4
push_front 5
push_front 6
pop_front
pop_back
pop_front
pop_back
size
pop_back
size

1
2
-1
-1
-1
-1
0
6
3
5
4
0
-1
0

11
push_front 3
push_front 4
push_front 5
push_front 6
pop_front
pop_back
pop_front
pop_back
size
pop_back
size

6
3
5
4
0
-1
0
 */