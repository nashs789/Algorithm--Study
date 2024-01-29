using System;
using System.Collections.Generic;

public class Solution {
    public string solution(string[] survey, int[] choices) {

        Dictionary<string, int> result = new Dictionary<string, int>
        {
            {"R",0}, {"T",0}, {"C",0}, {"F",0}, {"J",0}, {"M",0}, {"A",0}, {"N",0}
        };

        for (int i = 0; i < survey.Length; i++)
        {               
            int values=0;
            string valueName="";

            if (choices[i] >= 4)
            {
                values = 4-choices[i];
                valueName=survey[i][0].ToString();
            }
            else
            {
                values = choices[i]-4;
                valueName=survey[i][1].ToString();
            }

            result[valueName] += values;
        }

        string answer = result["R"] < result["T"] ? "T" : "R";
        answer += result["C"] < result["F"] ? "F" : "C";
        answer += result["J"] < result["M"] ? "M" : "J";
        answer += result["A"] < result["N"] ? "N" : "A";
        
        return answer;
    }
}