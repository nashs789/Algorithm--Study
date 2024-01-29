package Programmers.Lv2.Q46;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q46_JoyStick {

    public static int answer = 0;
    public static char[] nameArr;
    public static int[] cntArr;

    public static void main(String[] args) {
        String name = "ABAAAAAAAAABB";
        int len = name.length();

        nameArr = name.toCharArray();
        cntArr = new int[len];

        for(int idx = 0; idx < len; idx++){
            cntArr[idx] = setCntArr(idx);
        }

        System.out.println(Arrays.stream(cntArr).sum() + bfs());
    }

    private static int bfs(){
        int cntNotA = cntArr.length - getCntA();
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 0));
        while (!queue.isEmpty()){
            Node curNode = queue.poll();

            if(cntArr[curNode.num] != 0){
                curNode.cnt += 1;
            }

            if(curNode.cnt == cntNotA){
                return curNode.dist;
            }

            int next = curNode.num == cntArr.length - 1 ? 0 : curNode.num + 1;
            int prev = curNode.num == 0 ? cntArr.length - 1 : curNode.num - 1;

            queue.add(new Node(next, curNode.dist + 1, curNode.cnt));
            queue.add(new Node(prev, curNode.dist + 1, curNode.cnt));
        }

        return 1;   // 여기로 넘어가면 로직 망한거
    }

    private static int getCntA(){
        return (int) Arrays.stream(cntArr).filter(e -> e == 0).count();
    }

    private static int setCntArr(int index){
        int cnt1 = 0;
        int cnt2 = 1;   // A에서 Z로 넘어가면서 +1
        char ch = nameArr[index];

        for(int idx = 65; idx <= 90; idx++){
            if(idx == ch){
                break;
            }

            cnt1++;
        }

        for(int idx = 90; idx >= 65; idx--){
            if(idx == ch){
                break;
            }

            cnt2++;
        }

        return cnt1 > cnt2 ? cnt2 : cnt1;
    }
}

class Node{
    int num;
    int dist;
    int cnt;

    Node(int num, int dist, int cnt){
        this.num = num;
        this.dist = dist;
        this.cnt = cnt;
    }
}