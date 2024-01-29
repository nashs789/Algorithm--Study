using System;

public class Solution {
    public int solution(string t, string p) {
        int answer = 0;

        for(int i = 0; i < t.Length - p.Length + 1; i++){
            if(Int64.Parse(t.Substring(i, p.Length)) <= Int64.Parse(p)){
                answer++;
            } 
        }
        
        return answer;
    }
}