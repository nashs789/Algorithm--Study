using System;

public class Solution {
    public int solution(string s) {
        string[] arr = new string[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        
        for(int i = 0; i < arr.Length; i++){
            s = s.Replace(arr[i], i.ToString());
        }
        
        return Int32.Parse(s);
    }
}