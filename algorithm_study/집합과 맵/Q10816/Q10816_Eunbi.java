import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
  백준 - 집합과 맵
  10816. 숫자 카드 2
  
  메모리 : 174552KB
  시간  : 1236ms
 */
public class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<Integer,Integer> cardMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(cardMap.get(num) == null) {
                cardMap.put(num,1);
            } else {
                cardMap.put(num,cardMap.get(num)+1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int[] result = new int[M];
        for(int i=0; i<M;i++) {
            int cardNum = Integer.parseInt(st.nextToken());
            if(cardMap.get(cardNum) != null){
                result[i] = cardMap.get(cardNum);
            } else {
                result[i] = 0;
            }
        }
        for (int num : result) {
            bw.write(num+" ");
        }
        bw.flush();
        bw.close();
    }
}
