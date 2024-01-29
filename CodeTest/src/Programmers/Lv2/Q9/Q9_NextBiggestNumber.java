package Programmers.Lv2.Q9;

import java.util.Arrays;

public class Q9_NextBiggestNumber {
    public static void main(String[] args) {
        int n = 78;
        long orgCnt = Arrays.stream(Integer.toBinaryString(n).split("")).filter(e -> e.equals("1")).count();

        while(true){
            long nextCnt = Arrays.stream(Integer.toBinaryString(++n).split("")).filter(e -> e.equals("1")).count();

            if(orgCnt == nextCnt){
                System.out.println(n);
                break;
            }
        }
    }
}