using System;

public class Solution {
    public string solution(int[] numbers) {
        Array.Sort(numbers, (x, y) =>
        {
            return (y.ToString() + x.ToString()).CompareTo(x.ToString() + y.ToString());
        });
        
        return numbers[0] == 0 ? "0" : string.Join("", numbers);
    }
}