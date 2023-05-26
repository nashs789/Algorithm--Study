import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 집합과 맵 - 나는야 포켓몬 마스터 이다솜
 * 메모리 : 107364KB
 * 시간 : 932ms
 */
public class Q1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Map<String,Integer> pocketmonNameMap = new HashMap<>();
        Map<Integer,String> pocketmonNumberMap = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=1; i<=N; i++) {
            String pocketmon = br.readLine();
            pocketmonNameMap.put(pocketmon,i);
            pocketmonNumberMap.put(i,pocketmon);
        }
        for (int i=0; i<M; i++) {
            String answer = br.readLine();
            if(isNumber(answer)) {
                bw.write(pocketmonNumberMap.get(Integer.parseInt(answer)) + "\n");
            } else {
                bw.write(pocketmonNameMap.get(answer) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static Boolean isNumber(String answer) {
        try {
            Long.parseLong(answer);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
