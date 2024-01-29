using System;

public class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(1 <= n / a){            
            answer += (n / a) * b;
            n = (n / a * b) + (n % a);
        }
        
        return answer;
    }
}