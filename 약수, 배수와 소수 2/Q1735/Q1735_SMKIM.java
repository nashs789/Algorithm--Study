package 백준.약수_배수와소수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* 	메모리 : 15984
* 시간:	148
* */
public class 분수합_1735 {
    static int[] arrA = new int[2];
    static int[] arrB = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int up = A * D + B * C;
        int down = B * D;

        int result = gcd(up, down);
        up /= result;
        down /= result;

        sb.append(up + " " + down).append("\n");

        System.out.println(sb);


    }

    static int gcd(int a, int b) {

        while (b != 0) {

            int r = a % b; // 5 10
            System.out.println("a =" + a + ", b= " + b + ", r =" + r);
            a = b;
            b = r;
        }

        return a;
    }


}
