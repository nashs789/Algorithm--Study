/**
 * [ 접근 순서 ]
 * 1. 검수해야 하는 체스판의 사이즈는 8 * 8 이다.
 *     - 어떤 사이즈의 판이 들어와도 최소값의 결과를 만들어 내는건 8 * 8 사이즈 체스판이다.
 *
 * 2. 맨 위 좌측 상단이 W(백색), B(흑색) 두 가지 가능성을 가진 체스판이 있다.
 *     - 한 개의 체스판에는 2번의 검수가 필요하다.
 *
 * 3. 새로운 체스판을 만들 때에 인덱스 잘 체크 할것.
 *     - 가지고 있는 판은 N * M 으로 8 ~ 50까지의 수를 갖기 때문에 그 안에서 8 * 8 사이즈 체스판을 만들어야 한다.
 *
 *  [ 개선 가능성 ]
 * 1. 탐색으로 풀게 될 경우
 *     - 탐색할 인덱스에 대한 제한 조건을 만들어야 해서 더 복잡해질듯 싶다.
 *
 * 2. 매번 새로운 8 * 8을 구성하는 것 (연산 횟수가 많아짐)
 *     - 전체 판을 가지고 연산하는 방법이 있을거 같지만 제한 조건이 복잡할 것 같아서 포기
 *
 *  [ 효율성 ]
 *  - 메모리: 14900KB
 *  - 시간 : 168ms
 */

package BaekJoon.BruteForce.Q1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018_PaintChessBoard {

    private static int row;
    private static int col;
    private static int min = 64;                                // 다시 칠해야하는 최대 값(8 * 8 = 64)
    private static String[][] board;                            // 입력받는 전체 크기의 보드
    private static String[][] regularBoard = new String[8][8];  // 8 * 8 사이즈의 보드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        board = new String[row][col];

        for(int i = 0; i < row; i++){
            String[] arr = br.readLine().split("");

            for(int j = 0; j < col; j++){
                board[i][j] = arr[j];
            }
        }

        // -8: 8의 크기를 넘는 경우
        // ex) col 값으로 13이 들어온 경우 총 6개의 경우를 만들 수 있다(예제 입력2)
        for(int i = 0; i <= col - 8; i++){
            for(int j = 0; j <= row - 8; j++){
                changeBoard(j, i);  // 새로운 체스판 생성
                checkColor("W");    // 0, 0 좌표의 체스판이 하얀색으로 시작하는 경우 체크
                checkColor("B");    // 0, 0 좌표의 체스판이 검은색으로 시작하는 경우 체크
            }
        }

        System.out.println(min);
    }

    public static void checkColor(String color){
        int cnt = 0;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                // (i + j) % 2: 체스판에서 홀수와 짝수는 한 가지의 색밖에 가지지 못함
                if((i + j) % 2 == 0){
                    if(!regularBoard[i][j].equals(color)){
                       cnt++;
                    }
                } else {
                    if(regularBoard[i][j].equals(color)){
                        cnt++;
                    }
                }
            }
        }

        if(cnt < min){
            min = cnt;
        }
    }

    public static void changeBoard(int x, int y){
        int idxI = 0;

        // +8: 들어온 인덱스(x, y) 로부터 총 8개의 체스판이 만들어지기 위해서 반복이 8번 되어야함
        for(int i = x; i < x + 8; i++){
            int idxJ = 0;

            for(int j = y; j < y + 8; j++){
                regularBoard[idxI][idxJ] = board[i][j];
                idxJ++;
            }
            idxI++;
        }
    }
}