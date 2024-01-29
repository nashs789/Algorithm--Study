import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 집합과 맵 - 문자열 집합
 * 
 * 메모리 : 31568KB
 * 시간  : 412ms
 */
public class Q14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> checkSet = new HashSet<>();
        for (int i=0; i<N; i++) {
            String word = br.readLine();
            checkSet.add(word);
        }

        int count = 0;
        for(int i=0; i<M; i++) {
            String word = br.readLine();
            if(checkSet.contains(word)) {
                count ++;
            }
        }
        System.out.println(count);
    }
}
