package Programmers.Lv2.Q35;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q35 {
    public static void main(String[] args) {
        //String[] phone_book = {"12", "123", "1235", "567", "88"};
        //String[] phone_book = {"123", "456", "789"};
        String[] phone_book = {"119", "97674223", "1195524421"};
        Trie trie = new Trie();
        boolean flag = false;

        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for(int idx = 0; idx < phone_book.length; idx++){
            flag = trie.insert(phone_book[idx]);

            if(!flag){
                break;
            }
        }

        System.out.println(flag);
    }
}

class Node{
    Map<Character, Node> childNode = new HashMap<>();
    boolean terminalNode;
}

class Trie{
    Node rootNode = new Node();

    boolean insert(String str){
        Node node = this.rootNode;
        int len = str.length();
        int cnt = 0;

        for(int idx = 0; idx < len; idx++){
            if(node.childNode.get(str.charAt(idx)) != null){
                cnt++;
            }

            if(cnt == len){
                return false;
            }

            node = node.childNode.computeIfAbsent(str.charAt(idx), key -> new Node());
        }

        node.terminalNode = true;
        return true;
    }
}