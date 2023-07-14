package Programmers.Lv2.Q15;

import java.util.Arrays;

public class Q15_MaxAndMin {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1 2 3 4"));
    }
}

class Solution{
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int idx = 0; idx < arr.length; idx++){
            int num = arr[idx];

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return min + " " + max;
    }
}