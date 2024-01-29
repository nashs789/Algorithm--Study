# **[ 자주 사용하는 라이브러리 or 함수 ]**

# **[ String ]**
1. String[] -> String (2023.01.10 추가)
- String.join(delimiter, String 배열);
- ex) String.join("", new String[]{"a", "b", "c"}); ===> "abc"

[ Array ]
1. int 배열을 Integer 배열로 만들
- Arrays.stream(배열).boxed().toArray(Integer[]::new)

2. 이진 탐색
- Arrays.binarySearch(배열, key);
   - 오름차순 정렬이 선제조건
   - 총 9개의 메소드가 overloading 되어있음 (다양한 타입에 대한 이진 탐색 제공)
   - 검색 성공시 key 와 일치하는 index 반환 (해당 요소가 여러개일 경우 무작위 반환 ===> 특정 index (x) )
   - 검색 실패시 삽입 포인트를 반환
      - ex1) key 값이 배열 요소들의 사이일 경우: key = x ===> return -(x + 1)
      - ex2) key 값이 모든 요소보다 클 경우: key = x ===> return -(배열.length + 1)

[ Map ]

[ Set ]
1. 배열을 Set 으로 변환하기
- Set<?> set = new HashSet(Arrays.asList(배열));

[ Stream ]
1. List<Integer> -> int[] (2023.01.17 추가)
- list.stream().mapToInt(i -> i).toArray()

[ IntStream ]
1. 특정한 범위의 숫자를 순차적으로 생성
- IntStream.range(str, end): 마지막 인자를 범위에 포함
- IntStream.rangeClosed(str, end): 마지막 인자를 범위에 미포함
    - ex) IntStream.rangeClosed(1, 5).map(e -> e * 2).filter(e -> e > 5).count();

