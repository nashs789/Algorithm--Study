import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [효율성]
 * - 메모리 : 23028KB
 * - 시간 : 296ms
 * 
 * [풀이]
 * pSum[i] : 1 ~ i번째 원소들의 합
 * pSum[a] - pSum[b] : b+1 ~ a번째 원소들의 합(a - b개)
 */

public class Main {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    
    static int solve(int n, int k, int[] arr){
        // 누적합 초기화
        int[] pSum = new int[n+1];
        for(int i=1;i<=n;i++){
            pSum[i] = pSum[i-1] + arr[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i+k<=n;i++){
            max = Math.max(max, pSum[i+k]-pSum[i]);
        }

        return max;
    }
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(in.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        out.write(String.valueOf(solve(n, k, arr)));
        out.flush();
        out.close();
    }
}
