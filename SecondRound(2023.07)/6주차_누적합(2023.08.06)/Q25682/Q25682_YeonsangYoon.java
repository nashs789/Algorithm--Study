import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * [효율성]
 * 메모리 : 97320KB
 * 시간 : 552ms
 * 
 * [풀이]
 * 2차원 구간합 문제
 * n x m 배열 안에서 k x k 크기의 구간합을 구해야한다.
 * 
 * 주어진 board에서 w시작 체스판, b시작 체스판으로 변경할 때
 * 각 위치에서 색을 다시 칠해야하는 지에 대한 여부를 isChanged배열에 초기화한다.
 */

public class Main{
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    static int solve(int n, int m, int k, char[][] board){
        int[][] isChanged;
        int[][] pSum;
        int min = Integer.MAX_VALUE;

        // B시작
        isChanged = new int[n+1][m+1];
        pSum = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if((i+j)%2==0){
                    isChanged[i][j] = (board[i][j]=='B') ? 0 : 1;
                }
                else{
                    isChanged[i][j] = (board[i][j]=='W') ? 0 : 1;
                }
                pSum[i][j] = pSum[i-1][j] + pSum[i][j-1] - pSum[i-1][j-1] + isChanged[i][j];
            }
        }
        for(int i=k;i<=n;i++){
            for(int j=k;j<=m;j++){
                min = Math.min(min, pSum[i][j]-pSum[i-k][j]-pSum[i][j-k]+pSum[i-k][j-k]);
            }
        }
        
        // W시작
        isChanged = new int[n+1][m+1];
        pSum = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if((i+j)%2==0){
                    isChanged[i][j] = (board[i][j]=='W') ? 0 : 1;
                }
                else{
                    isChanged[i][j] = (board[i][j]=='B') ? 0 : 1;
                }
                pSum[i][j] = pSum[i-1][j] + pSum[i][j-1] - pSum[i-1][j-1] + isChanged[i][j];
            }
        }
        for(int i=k;i<=n;i++){
            for(int j=k;j<=m;j++){
                min = Math.min(min, pSum[i][j]-pSum[i-k][j]-pSum[i][j-k]+pSum[i-k][j-k]);
            }
        }
        
        return min;
    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] board = new char[n+1][m+1];
        for(int i=1;i<=n;i++){
            String line = in.readLine();
            for(int j=1;j<=m;j++){
                board[i][j] = line.charAt(j-1);
            }
        }

        out.write(String.valueOf(solve(n, m, k, board)));
        out.flush();
        out.close();
    }
}