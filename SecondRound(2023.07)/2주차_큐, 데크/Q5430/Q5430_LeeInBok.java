/**
 *  [ 효율성 ]
 *  - 메모리: 115168KB
 *  - 시간 : 988ms
 */

package BaekJoon.QueueAndDeque.Q5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Q5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int idx = 0; idx < TC; idx++){
            char[] regs = br.readLine().toCharArray();
            int numCnt = Integer.parseInt(br.readLine());
            List<Integer> seq = Arrays.stream(br.readLine().replaceAll("[\\[\\]]", "").split(","))
                                      .filter(e -> !e.equals(""))
                                      .mapToInt(Integer::parseInt)
                                      .boxed()
                                      .collect(Collectors.toList());
            LinkedList<Integer> deque = new LinkedList<>();
            boolean isReverse = false;
            boolean error = false;

            deque.addAll(seq);

            loop:
            for(char r : regs){
                if(r == 'R'){
                    isReverse = !isReverse;
                } else {
                    if(!deque.isEmpty()){
                        if(isReverse){
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    } else {
                        sb.append("error").append('\n');
                        error = true;
                        break loop;
                    }
                }
            }

            if(!error){
                Iterator<Integer> it;

                if(isReverse){
                    it = deque.descendingIterator();
                } else {
                    it = deque.iterator();
                }

                if(deque.isEmpty()){
                    sb.append('[').append(']').append('\n');
                } else {
                    sb.append('[');
                    while(it.hasNext()){
                        sb.append(it.next()).append(',');
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(']').append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}