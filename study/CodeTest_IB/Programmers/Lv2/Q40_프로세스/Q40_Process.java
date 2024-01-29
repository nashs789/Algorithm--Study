package Programmers.Lv2.Q40;

import java.util.LinkedList;

public class Q40_Process {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{2, 1, 3, 2}, 2));
    }

    public static class Solution{
        public static int solution(int[] priorities, int location) {
            LinkedList<Node> dQueue = new LinkedList();
            int[] impInfo = new int[10];

            for(int idx = 0; idx < priorities.length; idx++){
                dQueue.add(new Node(priorities[idx], idx));

                impInfo[priorities[idx]]++;
            }

            int seq = 0;

            while(true){
                int maxImp = getMaxImp(impInfo);
                Node firstNode = dQueue.peek();

                if(firstNode.imp == maxImp && firstNode.idx == location){
                    break;
                }

                if(firstNode.imp < maxImp){
                    dQueue.addLast(dQueue.poll());
                } else {
                    dQueue.poll();
                    impInfo[maxImp]--;
                    seq++;
                }
            }

            return ++seq;
        }

        public static int getMaxImp(int[] impInfo){
            for(int idx = 9; idx > 0; idx--){
                if(impInfo[idx] != 0){
                    return idx;
                }
            }

            return 0;
        }

        static class Node{
            int imp;
            int idx;

            public Node(int imp, int idx) {
                this.imp = imp;
                this.idx = idx;
            }
        }
    }
}