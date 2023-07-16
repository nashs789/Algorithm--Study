# ** [ 7월 15일 기록 ] **
- 인원: 5명
- 장소: 구로 할리스 카페
- 시간: 10:00 - 13:00

# ** [ To - DO ] **
- 과제: DP(TODO)
    - url: https://www.acmicpc.net/problem/1743
      1. https://www.acmicpc.net/problem/2178
      2. https://www.acmicpc.net/problem/2644
      3. https://www.acmicpc.net/problem/
      4. https://www.acmicpc.net/problem/
      5. https://www.acmicpc.net/problem/
      6. https://www.acmicpc.net/problem/
      7. https://www.acmicpc.net/problem/2636 (Optional)
    

- 공부한 것 세미발표로 스터디원들과 공유하기
    - 발표자: 박진슬님
    - 발표내용: DP (Dynamic Programming)

# ** [ 건의 사항 ] **
1. 스터디원이 고정되면 깃허브 메인 README 에 스터디 참여인원 정리해서 올리는 것
    - 래퍼런스 처럼 사용할 수 있도록 누구와 함께한지 서로가 서로를 증명해주는 자료가 되었으면 합니다.
    

2. 스터디 시간 변경 (2 시간 -> 3 시간)
    - 알고리즘과 문제가 복잡해지면서 설명하는데 많은 시간이 소요됨을 감안하여 1시간 늘리려고 합니다.
    

3. 스터디 난이도
    - 현재 스터디 난이도는 진행하는데 어려움이 없다고 생각되어 이대로 진행 하려고 합니다.
    - 난이도를 낮추기 보다는 유지하고, 서로에게 동기부여가 되자 라고 의견 나왔습니다.
    - 이미 문제 풀이가 가능한 것을 푸는 것 보다는 성장을 위한 도전을 목표로 진행하기로 했습니다. 
    

4. 스터디룸에서 발표 할 때 시간 제한을 두자
    - 세미 발표(공부한 알고리즘 발표): 15분 
    - 문제 리뷰 및 질문 받는 시간: 10분 (질문에 따라 길어짐은 유연하게 처리)
    - 풀어온 코드를 잘 미리 정리해서 시간을 효율적으로 쓰자는 취지 이기 때문에 무조건 적인 시간은 아닙니다.
    - 위 시간들은 Maximum 입니다.
    

5. 스터디명(Final)
    - 투표 결과에 따라서 이번 주 내로 반영
    

6. 문제 선정 방식
    - 한 사람당 1문제씩 선택 하기로 하였습니다.
    - 문제 선정에 대한 기준은 별도로 없으며, 해당 주차 알고리즘으로 풀이가 가능한 문제로 선택 하시면 됩니다.
    

7. 스터디 불참에 대하여
    - 스터디에서 따로 패널티는 부여하지 않습니다.
    - 2회 연속 불참은 지양 부탁드립니다.
      
# ** [ 발표 내용 ] **
- 순열에서의 DFS

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

n개의 슷자를 중복을 허용하여 스택과 재귀함수를 이용하여 깊이우선 탐색으로 순열을 구하면 아래와 같다.

``` Java
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stack<Integer> stack = new Stack<>();

        dfs(list, stack);
        System.out.println("count: " + count);
    }

    private static void dfs(List<Integer> list, Stack<Integer> stack) {
        for (int i = 0; i < list.size(); i++) {
            stack.push(list.get(i));
            if (stack.size() == list.size()) {
                count++;
                System.out.println(stack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            } else {
                dfs(list, stack);
            }
            stack.pop();
        }
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

백트래킹이란? 원하는 해가 아닌것을 가지치기하며 되돌아가는 기법
즉 백트래킹을 이용하여 중복을 제거한 모든 순열을 출력하면

``` Java
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stack<Integer> stack = new Stack<>();

        backTracking(list, stack);
        System.out.println("count: " + count);
    }

    private static void backTracking(List<Integer> list, Stack<Integer> stack) {
        for (int i = 0; i < list.size(); i++) {
            if (stack.contains(list.get(i))) continue;
            stack.push(list.get(i));
            if (stack.size() == list.size()) {
                count++;
                System.out.println(stack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            } else {
                backTracking(list, stack);
            }
            stack.pop();
        }
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

즉 코드에서 dfs와의 차이는 if문의 여부로 확인할수 있음 
아래 코드는 중복을 허용하되, 홀수개만 탐색하는 백트래킹 코드

``` Java
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stack<Integer> stack = new Stack<>();

        backTracking(list, stack);
        System.out.println("count: " + count);
    }

    private static void backTracking(List<Integer> list, Stack<Integer> stack) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) continue;
            stack.push(list.get(i));
            if (stack.size() == list.size()) {
                count++;
                System.out.println(stack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            } else {
                backTracking(list, stack);
            }
            stack.pop();
        }
    }
}
```

실행 결과: 
``` C
1, 1, 1, 1
1, 1, 1, 3
1, 1, 3, 1
1, 1, 3, 3
1, 3, 1, 1
1, 3, 1, 3
1, 3, 3, 1
1, 3, 3, 3
3, 1, 1, 1
3, 1, 1, 3
3, 1, 3, 1
3, 1, 3, 3
3, 3, 1, 1
3, 3, 1, 3
3, 3, 3, 1
3, 3, 3, 3
count: 16
```

- 그래프에서의 DFS

4개의 노드가 있고 
아래와 같이 간선이 연결되있을때,
``` C
1: 2, 3, 4
2: 1, 4
3: 1, 4
4: 1, 2, 3
```

``` Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> nodes = new HashMap<>() {
            {
                put(1, List.of(2, 3, 4));
                put(2, List.of(1, 4));
                put(3, List.of(1, 4));
                put(4, List.of(1, 2, 3));
            }
        };
        int start = 1;

        dfs(nodes, start, new Stack<>(), new HashSet<>(List.of(start)));
    }

    private static void dfs(Map<Integer, List<Integer>> edgeMap, int v, Stack<Integer> stack, Set<Integer> visited) {
        System.out.println(v); // 탐색순서
        for (int next : edgeMap.get(v)) {
            if (visited.contains(next)) continue;
            stack.push(next);
            visited.add(next);
            if (!stack.isEmpty()) {
                dfs(edgeMap, next, stack, visited);
            }
            stack.pop();
        }
    }
}
```

탐색순서는 아래와 같이 출력된다.
``` C
1
2
4
3
```
