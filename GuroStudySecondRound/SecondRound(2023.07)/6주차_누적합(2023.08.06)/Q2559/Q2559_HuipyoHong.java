/**
 *  [ 효율성 ]
 *  - 메모리: 112984KB
 *  - 시간 : 884ms
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] array = new int[n];
        int[] resultArray = new int[n - m + 1];

        Arrays.setAll(array, i -> (i > 0 ? array[i - 1] : 0) + scanner.nextInt());
        Arrays.setAll(resultArray, i -> array[i + m - 1] - (i > 0 ? array[i - 1] : 0));
        Arrays.sort(resultArray);
        System.out.println(resultArray[resultArray.length - 1]);
        scanner.close();
    }
}
