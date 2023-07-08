package BaekJoon.QueueAndDeque.Q5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Q5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int idx = 0; idx < TC; idx++){
            char[] regs = br.readLine().toCharArray();
            int numCnt = Integer.parseInt(br.readLine());
            // 1. '[', ']' 제거 ===> replace 보다는 첫 글자랑 마지막 글자 지우는게 효율면에서 좋음
            // 2. ',' 기준으로 숫자들 잘라서 배열 요소로 만든다.
            // 3. 공백인 경우는 제외한다. (공백은 캐스팅 불가능 ===> 에러 발생)
            // 4. Wrapper Class 로 Boxing
            // 5. List 로 변환하는 이유는 addAll 이 콜렉션 객체만 파라미터로 받기 떄문에
            List<Integer> seq = Arrays.stream(br.readLine().replaceAll("[\\[\\]]", "").split(","))
                                      .filter(e -> !e.equals(""))
                                      .mapToInt(Integer::parseInt)
                                      .boxed()
                                      .collect(Collectors.toList());
            LinkedList<Integer> deque = new LinkedList<>();
            boolean isReverse = false;
            boolean error = false;

            deque.addAll(seq);

            loop:
            for(char r : regs){
                if(r == 'R'){
                    isReverse = !isReverse;
                } else {
                    // 큐가 비어있는지 체크 후 false 케이스는 error
                    if(!deque.isEmpty()){
                        // isReverse: ture ===> 역방향
                        if(isReverse){
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    } else {
                        sb.append("error").append('\n');
                        error = true;
                        break loop;
                    }
                }
            }

            // 에러인 경우 요소를 출력할 필요가 없음(이미 위에서 error로 입력함)
            if(!error){
                Iterator<Integer> it;

                // 정방향, 역방향 확인 후 iterator 출력 방향 결정
                if(isReverse){
                    it = deque.descendingIterator();
                } else {
                    it = deque.iterator();
                }

                // 출력 포맷에 맞춰서 파싱
                // 1. 큐가 비어있을 떄: 남은 배열 요소가 없음
                // 2. 큐가 비어있지 않음: 남은 배열 요소 출력 및 파싱
                if(deque.isEmpty()){
                    sb.append('[').append(']').append('\n');
                } else {
                    sb.append('[');
                    while(it.hasNext()){
                        sb.append(it.next()).append(',');
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(']').append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}