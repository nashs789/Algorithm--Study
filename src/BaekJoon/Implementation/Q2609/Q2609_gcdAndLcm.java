package BaekJoon.Implementation.Q2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q2609_gcdAndLcm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        BigInteger n1 = new BigInteger(arr[0]);
        BigInteger n2 = new BigInteger(arr[1]);

        int gcd = n1.gcd(n2).intValue();

        System.out.println(gcd);
        System.out.println(n1.intValue() * n2.intValue() / gcd);
    }
}