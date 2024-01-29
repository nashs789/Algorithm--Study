import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [효율성]
 * 메모리 : 36532KB
 * 시간 : 416ms
 * 
 * [풀이]
 * 구간의 길이가 x로 고정된 부분합의 최대값과 구간의 개수
 * => 단순히 누적합 배열을 만든 후 구간합 계산
 */

public class Main{
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    static String solve(int n, int x, int[] visited){
        int[] pSum = new int[n+1];
        for(int i=1;i<=n;i++){
            pSum[i] = pSum[i-1] + visited[i];
        }

        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for(int i=x;i<=n;i++){
            if(pSum[i] - pSum[i-x] > max){
                max = pSum[i] - pSum[i-x];
                cnt = 1;
            }
            else if(pSum[i] - pSum[i-x] == max){
                cnt++;
            }
        }

        return (max == 0) ? "SAD" : max + "\n" + cnt;
    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        out.write(solve(n, x, arr));
        out.flush();
        out.close();
    }
}