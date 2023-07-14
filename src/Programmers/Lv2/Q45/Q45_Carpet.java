package Programmers.Lv2.Q45;

import java.util.*;

public class Q45_Carpet {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(24, 24);
    }
}

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        Map<Integer, Integer> map = getDivisors(brown + yellow);
        Iterator<Integer> it = map.keySet().iterator();

        while(it.hasNext()){
            int row = it.next();
            int col = map.get(row);

            if((row * 2) + (col * 2) - 4 == brown){
                answer[0] = row;
                answer[1] = col;
                break;
            }
        }

        return answer;
    }

    public Map<Integer, Integer> getDivisors(int num){
        Map<Integer, Integer> map = new HashMap<>();
        int sqrt = (int)Math.sqrt(num);

        for(int idx = 2; idx <= sqrt; idx++){
            if(num % idx == 0){
                map.put(num / idx, idx);
            }
        }

        return map;
    }
}