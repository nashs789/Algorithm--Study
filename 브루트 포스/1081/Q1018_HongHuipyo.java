/**
 *  [ 효율성 ]
 *  - 메모리: 62432KB
 *  - 시간 : 876ms
 */

package BaekJoon.BruteForce.Q1018;

import java.util.*;

public class Q1018_HongHuipyo {
    private static int LIMIT = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] array = initArray(n, scanner);
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= n - LIMIT; i++) {
            for (int j = 0; j <= m - LIMIT; j++) {
                answer = Math.min(answer, compare(i, j, array));
            }
        }
        System.out.println(answer);
        scanner.close();
    }

    private static String[] initArray(int n, Scanner scanner) {
        String[] result = new String[n];

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String binaryString = s.replaceAll("B", "1").replaceAll("W", "0");
            result[i] = binaryString;
        }
        return result;
    }

    private static String[] initArrayToCompare() {
        String[] result = new String[LIMIT];

        Arrays.setAll(result, value -> String.format("%8s", Integer.toBinaryString(value % 2 == 0 ? 170 : 85)).replace(' ', '0'));
        return result;
    }

    private static String[] initArrayToCompareReverse(String[] array) {
        String[] result = new String[array.length];

        Arrays.setAll(result, value -> Integer.toBinaryString(~Integer.parseInt(array[value], 2)).substring(32 - LIMIT, 32));
        return result;
    }

    private static int compare(int n, int m, String[] array) {
        int[] counts = new int[2];
        String[] arrayToCompare = initArrayToCompare();
        String[] arrayToCompareReversed = initArrayToCompareReverse(arrayToCompare);

        for (int i = n; i < n + LIMIT; i++) {
            for (int j = m; j < m + LIMIT; j++) {
                if (array[i].charAt(j) != arrayToCompare[i - n].charAt(j - m)) {
                    counts[0]++;
                }
                if (array[i].charAt(j) != arrayToCompareReversed[i - n].charAt(j - m)) {
                    counts[1]++;
                }
            }
        }
        return Math.min(counts[0], counts[1]);
    }
}
