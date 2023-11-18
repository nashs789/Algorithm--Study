/**
* Author    : Lee In Bok 
* Date      : 2023.11.17(Fri)
* Spend Time: overtime 30m
* Runtime   : 393.46 ms (Longest time)
* Memory    : 192 MB (Most spacious)
* Algoritm  : Implementation
 */

import java.util.Arrays;
import java.util.Comparator;

class Q106_InterceptionSystem{
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}});
        
        System.out.println(result);
    }
}

class Solution {
    public int solution(int[][] targets) {
        int ans = 0;
        int bound = 0;

        Arrays.sort(targets, new Comparator<int[]>() {
            public int compare(int[] x, int[] y){
                return x[0] - y[0];
            }
        });

        for(int target[]: targets){
            if(bound > target[0]){
                bound = Math.min(bound, target[1]);
            } else {
                ans++;
                bound = target[1];
            }
        }

        return ans;
    }
}