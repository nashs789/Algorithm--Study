package BaekJoon.BruteForce.Q1436;

import java.util.*;

public class Q1436_HongHuipyo {
    private static final Stack<Integer> indices = new Stack<>();

    private static int answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()[1];
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(array, 0, M);
        System.out.println(answer);
    }

    static void dfs(int[] array, int index, int M) {
        if (indices.size() > 3)
            return;
        for (int i = index; i < array.length; i++) {
            if (indices.contains(array[i]))
                continue;
            indices.push(array[i]);
            if (indices.size() == 3 && indices.stream().mapToInt(Integer::intValue).sum() <= M)
                answer = Math.max(answer, indices.stream().mapToInt(Integer::intValue).sum());
            else
                dfs(array, i, M);
            indices.pop();
        }
    }
}
