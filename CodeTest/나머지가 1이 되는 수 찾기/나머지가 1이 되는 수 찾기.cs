using System;

public class Solution {
    public int solution(int n) {
        int answer = 2;
        
        while(1 != n % answer){
            answer++;
        }
        
        return answer;
    }
}