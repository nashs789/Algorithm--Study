/*
 *  [ ȿ���� ]
 *  - �޸�: 14296KB
 *  - �ð� : 128ms
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
        
        int N = Integer.parseInt(st.nextToken());	// ť�� ũ��(1 ~ N)
		int M = Integer.parseInt(st.nextToken());	// �������� ������ ����
        
        LinkedList<Integer> q = new LinkedList<>();
		int cnt = 0;	// 2, 3�� ���� Ƚ�� ���� �� ����
        
        for(int i = 1; i <= N; i++){
            q.add(i);
        }
        
        st = new StringTokenizer(br.readLine(), " "); //�������� ��
        
        int[] target = new int[M];//�������� ���� ���� �迭
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
