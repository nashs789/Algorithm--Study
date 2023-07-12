package BaekJoon.BackTracking.Q12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12100_2048Easy {

    public static int N;
    public static int max = Integer.MIN_VALUE;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, board);
        System.out.println(max);
    }

    public static void backTracking(int round, int[][] board){
        if(round == 5){
            max = Math.max(max, getMaxValue(board));
            return;
        }

        for(int i = round; i < 5; i++){
            for(int j = 0; j < 4; j++) {
                backTracking(i + 1, moveBoard(j, board));
            }
        }
    }

    // 0: 상, 1: 하, 2: 좌, 3: 우
    public static int[][] moveBoard(int direction, int[][] board){
        int[][] newBoard = copy(board);
        boolean[][] sum = new boolean[N][N];

        switch (direction){
            case 0:
                up(newBoard, sum);
                break;
            case 1:
                down(newBoard, sum);
                break;
            case 2:
                left(newBoard, sum);
                break;
            case 3:
                right(newBoard, sum);
                break;
            default:
        }

        return newBoard;
    }

    public static void right(int[][] board, boolean[][] sum){
        for(int j = N - 1; j >= 0; j--){
            for(int i = 0; i < N; i++){
                move(i, j, 3, board, sum);
            }
        }
    }

    public static void left(int[][] board, boolean[][] sum){
        for(int j = 0; j < N; j++){
            for(int i = 0; i < N; i++){
                move(i, j, 2, board, sum);
            }
        }
    }

    public static void down(int[][] board, boolean[][] sum){
        for(int i = N - 1; i >= 0; i--){
            for(int j = 0; j < N; j++){
                move(i, j, 1, board, sum);
            }
        }
    }

    public static void up(int[][] board, boolean[][] sum){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                move(i, j, 0, board, sum);
            }
        }
    }

    public static void move(int i, int j, int direction, int[][] board, boolean[][] sum){
        int newX = i + move[direction][0];
        int newY = j + move[direction][1];
        int newI = i;
        int newJ = j;

        if(isInvalidCoord(newX, newY)){
            return;
        }

        while(!isInvalidCoord(newX, newY) && board[newX][newY] == 0){
            board[newX][newY] = board[newI][newJ];
            board[newI][newJ] = 0;
            newI = newX;
            newJ = newY;
            newX += move[direction][0];
            newY += move[direction][1];
        }

        if(isInvalidCoord(newX, newY)){
            return;
        }

        if(board[newX][newY] != 0 && board[newX][newY] == board[newI][newJ] && !sum[newX][newY]){
            board[newX][newY] += board[newI][newJ];
            sum[newX][newY] = true;
            board[newI][newJ] = 0;
        }
    }

    public static int[][] copy(int[][] board){
        int[][] copyBoard = new int[N][];

        for(int idx = 0; idx < N; idx++){
            copyBoard[idx] = board[idx].clone();
        }

        return copyBoard;
    }

    public static boolean isInvalidCoord(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    public static int getMaxValue(int[][] board){
        int localMax = Integer.MIN_VALUE;

        for(int[] nums : board){
            for(int num : nums){
                localMax = Math.max(num, localMax);
            }
        }

        return localMax;
    }
}

// 0인경우: 비어있을 경우 이동
// 0이 아닌데 같은 숫자인경우: 숫자가 합쳐지고 현 위치 0으로
// 0이 아닌데 다른 숫자인경우: 움직임 없음

// 9
// 11:32 - 13:30
// 2시간 11분