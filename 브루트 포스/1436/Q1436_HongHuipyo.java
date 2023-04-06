package BaekJoon.BruteForce.Q1436;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Q1436_HongHuipyo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(IntStream.iterate(0, i -> IntStream.range(0, i).filter(j -> String.valueOf(j).contains("666")).count() != n, i -> i + 1).max().orElse(0));
        scanner.close();
    }
}
