# 이분탐색 알고리즘 (Binary Search Algorithm)
--------------------------------------------------

- 배열에서 어떤값 e를 찾을때 얼마나 효율적이게 빠르게 찾는가?

## 순차탐색

- 배열에서 0부터 배열의 끝까지 하나씩 탐색하면서 순차적으로 찾는 방식
- 단순 향상된 for문 또는 forEach문으로 탐색

기본적인 예시

```java
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        for (int j : array) {
            System.out.println(j);
            if (j == 4) break;
        }
    }
}
```
실행 결과: 
``` C
1
2
3
4
```

## 이분탐색

![이분탐색 알고리즘 간단 예시](https://i.namu.wiki/i/iyRr3QXm_nLi654fDApbkWSGcGPUCgloYW2PHrcDQN5ikUeAVkTTiBG0MlHergKDmj-eMapIEcpleSdOnreW7uXLT5Esyy1dd4QO_eh7w6NXlvjpWCqPaj9-LMZsWeyaI39uGBwwnzwwq_aZYqOwZw.webp)

- 이분탐색은 탐색전 오름차순으로 정렬이 되어있다고 가정했을때 탐색
- 중간값을 기준으로 시작과 끝점을 줄여나가며 up and down 으로 탐색

기본적인 예시

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int low = 0;
        int high = array.length - 1;

        Arrays.sort(array);
        while (low <= high) {
            int mid = (low + high) / 2;

            System.out.println(array[mid]);
            if (array[mid] == 4) break;
            if (array[mid] > 4) high = mid - 1;
            else low = mid + 1;
        }
    }
}
```
실행 결과: 
``` C
3
4
```

## 순차탐색과 이분탐색의 성능 비교

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {21, 1, 4, 7, 9, 20, 15, 11, 10, 5, 12, 14, 17, 2, 3, 8, 13, 18, 16, 19, 6};

        System.out.println(countOfLinearSearch(array, 17)); // 13
        System.out.println(countOfBinarySearch(array, 17)); // 3
    }

    private static int countOfLinearSearch(int[] array, int n) {
        int count = 0;

        for (int e : array) {
            count++;
            if (e == n) return count;
        }
        return count;
    }

    private static int countOfBinarySearch(int[] array, int n) {
        int low = 0;
        int high = array.length;
        int count = 0;

        Arrays.sort(array);
        while (n != array[(low + high) / 2]) {
            count++;
            if (count > array.length) return -1;
            if (n < array[(low + high) / 2]) high = (low + high) / 2;
            else low = (low + high) / 2;
        }
        return count;
    }
}
```

## 자바 언어에서의 이분탐색
- java.util패키지의 Arrays클래스에서 제공

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {21, 1, 4, 7, 9, 20, 15, 11, 10, 5, 12, 14, 17, 2, 3, 8, 13, 18, 16, 19, 6};

        Arrays.sort(array);
        System.out.println(Arrays.binarySearch(array, 14)); // 13
    }
}
```

## 결론
- 정렬이 되어있고 찾으려는 숫자가 큰 숫자일때, 시간초과를 줄이고 싶을때 이분탐색을 사용
- 정렬이 되어있지 않았을때, 어떤 정렬을 수행하느냐에 따라 순차탐색과 이분탐색의 효율성을 고려해보는것이 좋을거 같다.
