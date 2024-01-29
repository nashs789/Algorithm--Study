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