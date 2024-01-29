import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
  백준 - 집합과 맵
  10815. 숫자 카드 
  메모리 : 152392KB
  시간  : 996ms
 */
public class Q10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Integer,Integer> cardMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            cardMap.put(Integer.parseInt(st.nextToken()),1);
        }

        int M = Integer.parseInt(br.readLine());
        int[] checkCards = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            checkCards[i] = cardMap.get(num) != null ? cardMap.get(num) : 0;
        }

        for(int i=0; i<checkCards.length;i++) {
            bw.write(checkCards[i] + " ");
        }
        br.close();
        bw.flush();
        bw.close();

    }
}
