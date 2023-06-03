package 백준.약수_배수와소수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
/*
* gcd 계산 14524	140
* BigInteger : 	16084	188
*
* */


public class 최소공배수_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            BigInteger a = new BigInteger(String.valueOf(A));
            BigInteger b = new BigInteger(String.valueOf(B));
            BigInteger test = a.gcd(b);

            int test2 = Integer.parseInt(String.valueOf(test));

            //  int result = gcd(A, B);

            //sb.append(A * B / result).append("\n");
            sb.append( A * B /test2).append("\n");
        }
        System.out.println(sb);
    }

    static int gcd(int a, int b) {

        while (b != 0) {

            int r = a % b; // 5 10
            System.out.println("a ="+a + ", b= "+b +", r =" +r);
            a = b;
            b = r;
        }

        return a;
    }


}
