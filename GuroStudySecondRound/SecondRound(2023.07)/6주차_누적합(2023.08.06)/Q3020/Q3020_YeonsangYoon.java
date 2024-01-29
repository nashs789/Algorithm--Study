import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [효율성]
 * 메모리 : 35448KB	
 * 시간 : 360ms
 * 
 * [풀이]
 * 석순 : 밑에서 생성, 종유석 : 위에서 생성
 * obstacle[i] : i번째 장애물의 길이(i가 홀수 : 석순, i가 짝수 : 종유석)
 * 
 * down[i] : 길이가 i인 석순의 개수
 * up[i] : 길이가 i인 종유석의 개수
 * 
 * downCnt[i] : i번째 구간에서 파괴해야할 석순의 개수
 * upCnt[i] : i번째 구간에서 파괴해야할 종유석의 개수
 * 
 * 누적합 계산 점화식 : 
 * downCnt[i-1] = downCnt[i] + down[i-1]
 * upCnt[i] = upCnt[i-1] + up[h-i-1]
 */

public class Main{
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    static String solve(int n, int h, int[] obstacle){
        // 장애물 배열 초기화
        int[] down = new int[h+1];
        int[] up = new int[h+1];
        for(int i=1;i<=n;i++){
            if(i%2==1)
                down[obstacle[i]]++;
            else
                up[obstacle[i]]++;
        }

        // 누적합 배열 생성
        int[] downCnt = new int[h+1];
        int[] upCnt = new int[h+1];
        for(int i=h;i>=2;i--){
            downCnt[i-1] = downCnt[i] + down[i-1];
        }
        for(int i=1;i<=h;i++){
            upCnt[i] = upCnt[i-1] + up[h-i+1];
        }

        // 최소값 계산
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=h;i++){
            if(upCnt[i] + downCnt[i] < min){
                min = upCnt[i] + downCnt[i];
                cnt = 1;
            }
            else if(upCnt[i] + downCnt[i] == min){
                cnt++;
            }
        }

        return min + " " + cnt;
    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(in.readLine());
        }

        out.write(solve(n, h, arr));
        out.flush();
        out.close();
    }
}