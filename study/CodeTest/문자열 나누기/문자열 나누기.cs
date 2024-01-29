using System;

public class Solution {
    public int solution(string s) {
        int answer = 0;
        int equal = 0;
        int different = 0;
        char criteria = ' ';
        
        for(int i = 0; i < s.Length; i++){
            if(criteria.Equals(' ') == true){
                criteria = s[i];
            }
            
            if(criteria.Equals(s[i]) == true){
                equal++;
            } else{
                different++;
            }
            
            if(equal == different){
                answer++;
                equal = 0;
                different = 0;
                criteria = ' ';
            }
        }
        
        
        return equal == 0 ? answer : answer + 1;
    }
}