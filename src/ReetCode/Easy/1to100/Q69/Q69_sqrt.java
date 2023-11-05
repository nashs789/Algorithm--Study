/**
* Author    : Lee In Bok 
* Date      : 2023.11.05(Sun)
* Spend Time: 06m 34s
* Runtime   : 2 ms (Beats 91.16%)
* Memory    : 39.5 MB (Beats 64%)
* Algoritm  : Binary Search
 */

public class Q69_sqrt {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.mySqrt(4));
    } 
}

class Solution {
    public int mySqrt(int x) {
        long ans = 0;
        long srt = 0;
        long end = x;

        while(srt <= end){
            long mid = (srt + end) / 2;
            long res = mid * mid;

            if(res == x){
                return (int)mid;
            } else if(res > x){
                end = mid - 1;
            } else {
                srt = mid + 1;
                ans = mid;
            }
        } 

        return (int)ans;
    }
}