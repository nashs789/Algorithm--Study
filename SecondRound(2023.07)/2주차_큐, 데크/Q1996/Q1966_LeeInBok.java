/**
 *  [ 효율성 ]
 *  - 메모리: 14460KB
 *  - 시간 : 140ms
 */

package BaekJoon.QueueAndDeque.Q1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q1966_PrintQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int i = 0; i < TC; i++){
            Deque<Node> dQueue = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] impInfo = new int[10];
            int cnt = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());    // 중요도 입력

            for(int j = 0; j < cnt; j++){
                int imp = Integer.parseInt(st.nextToken());

                impInfo[imp]++;
                dQueue.add(new Node(j, imp));
            }

            // #################### input end ####################
            int seq = 0;

            while(true){
                int maxImp = getMaxImp(impInfo);

                if(dQueue.peek().imp == maxImp && dQueue.peek().idx == target){
                    break;
                }

                if(dQueue.peek().imp < maxImp){
                    dQueue.addLast(dQueue.poll());
                } else {
                    dQueue.poll();
                    impInfo[maxImp]--;
                    seq++;
                }
            }

            sb.append(++seq).append('\n');
        }

        System.out.println(sb);
    }

    public static int getMaxImp(int[] impInfo){
        for(int idx = 9; idx > 0; idx--){
            if(impInfo[idx] != 0){
                return idx;
            }
        }

        return 0;
    }
}

class Node {
    int imp;
    int idx;

    public Node(int idx, int imp) {
        this.idx = idx;
        this.imp = imp;
    }
}