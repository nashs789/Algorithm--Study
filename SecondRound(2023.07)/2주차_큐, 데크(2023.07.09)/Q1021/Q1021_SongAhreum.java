/*
 *  [ 효율성 ]
 *  - 메모리: 14296KB
 *  - 시간 : 128ms
 */


package queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1021_SongAhreum {
	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());	// 큐의 크기(1 ~ N)
		int M = Integer.parseInt(st.nextToken());	// 뽑으려는 숫자의 개수
        
        LinkedList<Integer> q = new LinkedList<>();
		int cnt = 0;	// 2, 3번 연산 횟수 누적 합 변수
        
        for(int i = 1; i <= N; i++){
            q.add(i);
        }
        
        st = new StringTokenizer(br.readLine(), " "); //뽑으려는 수
        
        int[] target = new int[M];//뽑으려는 수를 담은 배열
        for(int i = 0; i < M; i++){
            target[i] = Integer.parseInt(st.nextToken());
            
            int index = q.indexOf(target[i]);
            int halfSize = q.size() / 2 ;  
                                  
            while(q.get(0) != target[i]){
                if(index <= halfSize){
                    q.addLast(q.pollFirst());
                    cnt++;
                } else {
                    q.addFirst(q.pollLast());
                    cnt++;                
                }    
            }
            q.poll();
        }
        System.out.println(cnt);
    }
}
