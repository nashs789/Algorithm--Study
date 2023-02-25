using System;
using System.Collections.Generic;

public class Solution {
    public int solution(string[,] clothes) {
        int answer = 1;
        Dictionary<string, int> dictionary = new Dictionary<string, int>();
        
        for(int i = 0; i < clothes.GetLength(0); i++){
            string key = clothes[i, 1];
            
            if(dictionary.ContainsKey(key) == true){
                dictionary[key]++;   
            } else{
                dictionary.Add(key, 1);
            }
        }
        
        foreach (var item in dictionary)
        {
            answer *= (item.Value + 1);
        }
        
        return answer - 1;
    }
}