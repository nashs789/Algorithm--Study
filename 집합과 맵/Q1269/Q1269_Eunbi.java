import java.io.*;
import java.util.*;

/**
  백준  - 집합과 맵  
  1269. 대칭 차집합
  
  메모리 : 83256KB
  시간  : 724ms
**/
public class Q1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Set<Integer> result = new HashSet<>();
        st = new StringTokenizer(br.readLine()," ");
        for (int i= 0; i<A; i++) {
            int num = Integer.parseInt(st.nextToken());
            result.add(num);
        }
      
        st = new StringTokenizer(br.readLine()," ");
        for (int i= 0; i<B; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(result.contains(num)) {
                result.remove(num);
            } else {
                result.add(num);
            };
        }
      
        br.close();
    }
}
