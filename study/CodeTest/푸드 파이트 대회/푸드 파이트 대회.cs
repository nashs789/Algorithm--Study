using System;
using System.Linq;

public class Solution {
    public string solution(int[] food) {
        string first = "";
        
        for(int i = 1; i < food.Length; i++){
            first += String.Join("", Enumerable.Repeat(i, food[i] / 2).ToArray());
        }

        return first + "0" + String.Join("", first.ToCharArray().Reverse().ToArray());
    }
}