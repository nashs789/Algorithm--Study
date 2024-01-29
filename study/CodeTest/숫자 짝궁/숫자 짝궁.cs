using System;
using System.Linq;
using System.Text;

public class Solution {
    public string solution(string X, string Y) {
        StringBuilder answer = new StringBuilder();
    
        for(int i = 9; 0 <= i; i--){
            int countX = X.Count(item => item == (0x30 + i));
            int countY = Y.Count(item => item == (0x30 + i));
            
            
            answer.Append(Convert.ToChar(0x30 + i), countX < countY ? countX : countY);
        }
        
        if(answer.Length == 0){
            return "-1";
        } else if (answer.ToString().Count(x => x != '0') == 0)
            return "0";
        else{
            return answer.ToString();
        }
    }
}