1, 2, 3, 4를 중복을 허용하여 모든 순열을 완전탐색으로 출력하면

``` Java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.size(); k++) {
                    for (int l = 0; l < list.size(); l++) {
                        count++;
                        System.out.println(list.get(i) + ", " + list.get(j) + ", " + list.get(k) + ", " + list.get(l));
                    }
                }
            }
        }
        System.out.println("count: " + count);
    }
}
```

실행 결과: 
``` C
1, 1, 1, 1
1, 1, 1, 2
1, 1, 1, 3
1, 1, 1, 4
1, 1, 2, 1
1, 1, 2, 2
...
...
4, 4, 3, 1
4, 4, 3, 2
4, 4, 3, 3
4, 4, 3, 4
4, 4, 4, 1
4, 4, 4, 2
4, 4, 4, 3
4, 4, 4, 4
count: 256
```

1, 2, 3, 4를 중복없이 모든 순열을 출력하면

``` Java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                for (int k = 0; k < list.size(); k++) {
                    if (i == k || j == k) continue;
                    for (int l = 0; l < list.size(); l++) {
                        if (i == l || j == l || k == l) continue;
                        count++;
                        System.out.println(list.get(i) + ", " + list.get(j) + ", " + list.get(k) + ", " + list.get(l));
                    }
                }
            }
        }
        System.out.println("count: " + count);
    }
}
```

실행 결과: 
``` C
1, 2, 3, 4
1, 2, 4, 3
1, 3, 2, 4
1, 3, 4, 2
1, 4, 2, 3
1, 4, 3, 2
2, 1, 3, 4
2, 1, 4, 3
2, 3, 1, 4
2, 3, 4, 1
2, 4, 1, 3
2, 4, 3, 1
3, 1, 2, 4
3, 1, 4, 2
3, 2, 1, 4
3, 2, 4, 1
3, 4, 1, 2
3, 4, 2, 1
4, 1, 2, 3
4, 1, 3, 2
4, 2, 1, 3
4, 2, 3, 1
4, 3, 1, 2
4, 3, 2, 1
count: 24
```

1, 2, 3, 4 등 4가지의 숫자가 아닌 n개의 숫자의 순열을 구할경우 매번 n중 for문을 돌려야 하는가?

