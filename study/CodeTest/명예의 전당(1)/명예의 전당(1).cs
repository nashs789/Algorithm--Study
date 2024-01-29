using System;
using System.Collections;

public class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.Length];
        ArrayList list = new ArrayList();
        
        for(int i = 0; i < score.Length; i++){
            list.Add(score[i]);
            list.Sort();
            
            answer[i] = (int)(k < list.Count ? list[list.Count- k] : list[0]);
        }
        
        return answer;
    }
}