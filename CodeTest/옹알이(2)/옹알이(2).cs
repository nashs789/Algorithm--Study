using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

public class Solution {
    public int solution(string[] babbling) {
        int answer = 0;
        string[] arr = {"aya", "ye", "woo", "ma"};
        
        for(int i = 0; i < babbling.Length; i++){
            for(int j = 0; j < arr.Length; j++){
                if(babbling[i].Contains(arr[j] + arr[j]) == true){
                    break;
                }
                
                if(babbling[i].Contains(arr[j]) == true){               
                    babbling[i] = babbling[i].Replace(arr[j], " ");
                }
                
                if(babbling[i].Trim().Length == 0){
                    answer++;
                    break;
                }
                
            }
        }
        
        
        return answer;
    }
}