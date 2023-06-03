package 백준.약수_배수와소수2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 다음소수_4134 {

    /*
    * 메모리 : 100524KB
    * 시간:	868ms
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            long num2 = Long.parseLong(br.readLine());
            var bi = new BigInteger(String.valueOf(num2));

            if (bi.isProbablePrime(10)) {
                sb.append(num2).append("\n");
            } else {
                sb.append(bi.nextProbablePrime()).append("\n");
            }
        }
        System.out.println(sb);

    }
  }

/*
기존 소수 구하는 법으로 푸는 법으로 처리했더니, 시간초과남남
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            long test = Long.parseLong(br.readLine());

            boolean result = isPrime(test);

            long count = 1;
            long answer = 0;

            while (!result) {

                if (result == true) {
                    sb.append(test).append("\n");
                    break;
                } else {
                    answer = test + count;
                    result = isPrime(answer);
                    count++;
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }


    static boolean isPrime(long n) { // 시간복잡도 O(N)

        long test = n + 1;

        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }

    }*/
