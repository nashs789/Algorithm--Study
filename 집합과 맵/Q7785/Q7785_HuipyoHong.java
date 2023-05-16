/**
 *  [ 효율성 ]
 *  - 메모리: 148276KB
 *  - 시간 : 2352ms
 */

package BaekJoon.SetAndMap.Q7785;

import java.util.*;
import java.util.stream.*;

public class Q7785_HuipyoHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        IntStream.range(0, n)
                .mapToObj(value -> new String[] {scanner.next(), scanner.next()})
                .collect(Collectors.groupingBy(strings -> strings[0]))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().stream().flatMap(Arrays::stream).reduce((o, o2) -> o2).orElse("").equals("enter"))
                .sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey()))
                .forEach(entry -> System.out.println(entry.getKey()));
        scanner.close();
    }
}
