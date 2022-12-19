using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(string s) {
        int[] answer = new int[s.Length];
        Dictionary<char, int> disctionary = new Dictionary<char, int>();

        for(int i = 0; i < s.Length; i++){
            if(disctionary.ContainsKey(s[i]) == true){
                answer[i] = i - disctionary[s[i]];
                disctionary[s[i]] = i;
            } else{
                disctionary.Add(s[i], i);
                answer[i] = -1;
            }
        }
        
        
        return answer;
    }
}