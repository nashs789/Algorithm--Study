using System;

public class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++){
            int count = 0;
            
            for(int j = 1; j <= Math.Sqrt(i); j++){
                if(j * j == i){
                    count += 1;
                } else if(i % j == 0){
                    count += 2;
                }
            }
            
            answer += limit < count ? power : count;
        }
        
        return answer;
    }
}