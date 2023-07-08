1, 2, 3, 4를 중복없이 모든 순열을 완전탐색으로 출력하면

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

Process finished with exit code 0
