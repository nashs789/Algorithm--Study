package BaekJoon.Tree.Q1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1991_TreeTraverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree(new Node('A', null, null));
        int nodeCnt = Integer.parseInt(br.readLine());

        for(int idx = 0; idx < nodeCnt; idx++){
            String[] inp = br.readLine().split(" ");
            char parent = inp[0].charAt(0);
            char leftChild = inp[1].charAt(0);
            char rightChild = inp[2].charAt(0);

            tree.insertNode(tree.root, parent, leftChild, rightChild);
        }

        tree.preOrder(tree.root);
        tree.sb.append('\n');
        tree.inOrder(tree.root);
        tree.sb.append('\n');
        tree.postOrder(tree.root);
        tree.sb.append('\n');

        System.out.println(tree.sb);
    }
}

class Tree {
    Node root;
    StringBuilder sb = new StringBuilder();

    public Tree(Node root) {
        this.root = root;
    }

    public void insertNode(Node root, char parent, char left, char right){
        if(root.value == parent){
            root.left = left == '.' ? null : new Node(left, null, null);
            root.right = right == '.' ? null : new Node(right, null, null);
        } else {
            if(root.left != null){
                insertNode(root.left, parent, left, right);
            }

            if(root.right != null){
                insertNode(root.right, parent, left, right);
            }
        }
    }

    public void preOrder(Node node) {
        if(node == null){
            return;
        }

        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if(node == null){
            return;
        }

        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }
}

class Node{
    char value;
    Node left;
    Node right;

    public Node(char value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}