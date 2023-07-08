/**
 *  [ 효율성 ]
 *  - 메모리: 14408KB
 *  - 시간 : 128ms
 */

package BaekJoon.QueueAndDeque.Q11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11866_JoesphusProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedNode linkedNode = new LinkedNode(new Node(1, null, null));

        for(int idx = 2; idx < N; idx++){
            linkedNode.addNode(new Node(idx, null, null));
        }

        if(N != 1){
            linkedNode.addLastNode(new Node(N, null, null));
        }

        linkedNode.run(K);
    }
}

class LinkedNode {
    Node firstNode;
    Node lastNode;
    StringBuilder sb = new StringBuilder();

    LinkedNode(Node node){
        this.firstNode = node;
        this.lastNode = node;
    }

    public void addNode(Node node){
        node.preNode = lastNode;
        this.lastNode.nextNode = node;
        this.lastNode = node;
    }

    public void addLastNode(Node node){
        this.addNode(node);
        this.lastNode.nextNode = this.firstNode;
        this.firstNode.preNode = this.lastNode;
    }

    public void run(int gap){
        sb.append('<');
        int cnt = 1;

        while(this.firstNode.nextNode != null && this.firstNode != this.firstNode.nextNode){
            if(cnt % gap == 0){
                sb.append(this.firstNode.num).append(',').append(' ');
                this.firstNode.preNode.nextNode = this.firstNode.nextNode;
                this.firstNode.nextNode.preNode = this.firstNode.preNode;
                this.firstNode = this.firstNode.nextNode;
                cnt++;
                continue;
            }

            this.firstNode = this.firstNode.nextNode;
            cnt++;
        }
        sb.append(this.firstNode.num).append('>');

        System.out.print(sb);
    }
}

class Node{
    int num;
    Node preNode;
    Node nextNode;

    public Node(int num, Node preNode, Node nextNode) {
        this.num = num;
        this.preNode = preNode;
        this.nextNode = nextNode;
    }
}