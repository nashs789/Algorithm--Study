package Programmers.Lv2.Q39;

import java.util.ArrayList;
import java.util.List;

public class Q39_DevelopFunction_Sol1 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        // {95, 90, 99, 99, 80, 99}
        int[] speeds = {1, 30, 5};
        // {1, 1, 1, 1, 1, 1}
        List<Integer> answer = new ArrayList<>();
        int finIdx = 0;

        while(finIdx != progresses.length){
            int cnt = 0;

            for(int idx = 0; idx < progresses.length; idx++){
                progresses[idx] += speeds[idx];
            }

            while (finIdx != progresses.length && progresses[finIdx] >= 100){
                finIdx++;
                cnt++;
            }

            if(cnt != 0){
                answer.add(cnt);
            }
        }
        // answer.stream().mapToInt(Integer::intValue).toArray();
    }
}