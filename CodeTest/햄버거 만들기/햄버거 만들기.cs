using System;
using System.Collections.Generic;

public class Solution {
    public int solution(int[] ingredient) {
        List<int> list = new List<int>();
        int answer = 0;
        
        for(int i = 0; i < ingredient.Length; i++){
            list.Add(ingredient[i]);
            
            if(list.Count < 4){
                continue;
            }
            
            if(list[list.Count - 1] != 1 || list[list.Count -2] != 3
              || list[list.Count - 3] != 2 || list[list.Count - 4] != 1){
                continue;
            }
            
            for(int j = 0; j < 4; j++){
                list.RemoveAt(list.Count - 1);
            }
            
            answer++;
        }
        
        return answer;
    }
}