using System;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<int> answer = new List<int>();
        int[] array = Enumerable.Repeat<int>(0, 101).ToArray<int>();
        int afterDay = 1;
        
        for(int i = 0; i < progresses.Length; i++){
            while(progresses[i] + speeds[i] * afterDay < 100){
                afterDay++;
            }
            
            array[afterDay]++;
        }
        
        for(int i = 0; i < 101; i++){
            if(array[i] != 0){
                answer.Add(array[i]);
            }
        }
        
        return answer.ToArray();
    }
}