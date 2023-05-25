import java.io.*;
import java.util.*;

/**
 * 백준 집합과 맵 - 듣보잡
 *
 * 메모리 : 26504
 * 시간  : 376ms
 */
public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> checkSet = new HashSet<>();
        Set<String> resultSet = new HashSet<>();

        for (int i=0; i<N; i++) {
            checkSet.add(br.readLine());
        }
        for (int i=0; i<M; i++){
            String name = br.readLine();
            if(checkSet.contains(name)) {
                resultSet.add(name);
            }
        }
        System.out.println(resultSet.size());
        resultSet.stream().sorted().forEach(i -> System.out.println(i));
    }
}
