/*
 *  [ ȿ���� ]
 *  - �޸�: 20264KB
 *  - �ð� : 380ms
 */
package queue_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
public class Q10866_SongAhreum {

	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<Integer>();
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String tokens[] = str.split(" ");
            String command = tokens[0];
            
            //push �ΰ�����ɾ�
            if(tokens.length == 2){
                int n = Integer.parseInt(tokens[1]);
                if(command.equals("push_front")){
                    q.addFirst(n);                 
                    continue;
                }
                if(command.equals("push_back")){
                    q.addLast(n);                    
                    continue;
                }
            }
            //command�� empty���� ����üũ
            if(command.equals("empty")){
                if(q.isEmpty()){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                continue;
            }
            //sizeüũ
            if(command.equals("size")){
                int a = q.size();
                System.out.println(a);
                continue;
            }
            
            //��������ɾ� : ��������� ��°���
            //pop_front/pop_back/front/back
            if(q.isEmpty()){
                System.out.println(-1);
            } else {
               if(command.equals("pop_front")){
                int a = q.pollFirst();
                System.out.println(a);
                continue;
                }
                if(command.equals("pop_back")){
                    int a = q.pollLast();
                    System.out.println(a);
                    continue;
                }          
                if(command.equals("front")){
                    int a = q.getFirst();
                    System.out.println(a);
                    continue;
                }
                if(command.equals("back")){
                    int a = q.getLast();
                    System.out.println(a);
                    continue;
                } 
            }                 
        }
    }

}
