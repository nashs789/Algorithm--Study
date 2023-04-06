package BaekJoon.BruteForce.Q1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018_PaintChessBoard {

    private static int row;
    private static int col;
    private static int min = 64;
    private static String[][] board;
    private static String[][] regularBoard = new String[8][8];

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

        for(int i = 0; i <= col - 8; i++){
            for(int j = 0; j <= row - 8; j++){
                changeBoard(j, i);
                checkColor("W");
                checkColor("B");
            }
        }

        System.out.println(min);
    }

    public static void checkColor(String color){
        int cnt = 0;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
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