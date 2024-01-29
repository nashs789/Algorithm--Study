package Programmers.Lv1.Q34;

import java.util.Arrays;

public class Q34_DartGame {
    public static void main(String[] args) {
        String dartResult = "1D2S3T*";
        int answer = 0;

        int len = dartResult.length();
        String tempScore = "";
        int[] roundScore = new int[3];
        int roundIdx = 0;

        for(int idx = 0; idx < len; idx++){
            char letter = dartResult.charAt(idx);

            switch (letter){
                case 'S':
                    roundScore[roundIdx++] = Integer.parseInt(tempScore);
                    tempScore = "";
                    break;
                case 'D':
                    roundScore[roundIdx++] = (int) Math.pow(Integer.parseInt(tempScore), 2.0);
                    tempScore = "";
                    break;
                case 'T':
                    roundScore[roundIdx++] = (int) Math.pow(Integer.parseInt(tempScore), 3.0);
                    tempScore = "";
                    break;
                case '*':
                    roundScore[--roundIdx] *= 2;
                    if(roundIdx > 0){
                        roundScore[--roundIdx] *= 2;
                        roundIdx++;
                    }
                    roundIdx++;
                    break;
                case '#':
                    roundScore[--roundIdx] *= -1;
                    roundIdx++;
                    break;
                default:
                    tempScore += letter;
            }
        }

        answer = Arrays.stream(roundScore).sum();
        System.out.println("answer = " + answer);
    }
}
