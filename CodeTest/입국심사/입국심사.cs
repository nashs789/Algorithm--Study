using System;
using System.Linq;

public class Solution {
    public ulong solution(int n, int[] times) {
        Array.Sort(times);
        
        var right = (ulong)times[times.Length - 1] * (ulong)n;
        var left = (ulong)0;
        var answer = right;
        
        while (left <= right)
        {
            var mid = (left + right) / (ulong)2;
            var count = (ulong)0;
            
            for (int i = 0; i < times.Length; i++)  
            {
                count += (ulong)mid / (ulong)times[i];
                
                if (count >= (ulong)n)
                    answer = Math.Min(answer, mid);
            }

            if (count < (ulong)n) 
            {
                left  = mid + 1;
            }
            else 
            {
                right = mid - 1;
            }
        }
        
    return answer;
    }
}