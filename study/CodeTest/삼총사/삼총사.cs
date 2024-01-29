using System;

public class Solution {
    public int solution(int[] number) {
        int answer = 0;

        for(int count=0; count<number.Length-2; ++count)
            for(int count2 = count+1; count2<number.Length-1; ++count2)
                for(int count3 = count2+1; count3<number.Length; ++count3)
                {
                    if(number[count]+number[count2]+number[count3] == 0)
                        answer++;
                }

        return answer;
    }
}