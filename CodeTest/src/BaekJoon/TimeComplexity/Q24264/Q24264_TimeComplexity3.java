package BaekJoon.TimeComplexity.Q24264;

import java.io.*;

public class Q24264_TimeComplexity3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.print((long)Math.pow(n, 2) + "\n2");
    }
}
// 테스트 케이스중에 정수로 표현이 불가능한 수가 있는걸로 보임 ===> 실패 5번함