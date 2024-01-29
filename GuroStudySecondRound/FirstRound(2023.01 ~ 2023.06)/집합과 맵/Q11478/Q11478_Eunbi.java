import java.util.*;

/**
 * 백준 집합과 맵 - 서로 다른 부분 문자열의 개수
 *
 * 메모리 : 229716KB
 * 시간  : 812ms
 */
public class Q11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input =sc.next();
        Set<String> wordSet = new HashSet<>();

        for(int i=0; i<input.length(); i++) {
            for(int j=i+1; j<=input.length(); j++) {
                wordSet.add(input.substring(i,j));
            }
        }
        System.out.println(wordSet.size());

    }
}
