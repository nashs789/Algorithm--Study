/**
 *  [ 효율성 ]
 *  - 메모리: 18072KB
 *  - 시간 : 224ms
 */

package BaekJoon.SetAndMap.Q1302;

import java.util.*;
import java.util.stream.*;

public class Q1302_HuipyoHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(
                Stream.iterate(scanner.next(), i -> scanner.next())
                        .limit(n)
                        .collect(Collectors.groupingBy(o -> o))
                        .entrySet()
                        .stream()
                        .sorted((o1, o2) -> {
                            if (o1.getValue().size() == o2.getValue().size()) {
                                return o1.getKey().compareTo(o2.getKey());
                            } else {
                                return Integer.compare(o2.getValue().size(), o1.getValue().size());
                            }
                        })
                        .collect(Collectors.toList())
                        .get(0)
                        .getKey()
        );
        scanner.close();
    }
}
