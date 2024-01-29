package BaekJoon.BackTracking.Q12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12100_2048Easy {

    public static int N;                          // N * N 사이즈 board
    public static int max = Integer.MIN_VALUE;    // 현재 board 에서 최대 값
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
        // 최대 이동 횟수 5번
        if(round == 5){
            max = Math.max(max, getMaxValue(board));
            return;
        }

        for(int i = round; i < 5; i++){
            // 4방향 이동
            for(int j = 0; j < 4; j++) {
                backTracking(i + 1, moveBoard(j, board));
            }
        }
    }

    // 0: 상, 1: 하, 2: 좌, 3: 우
    public static int[][] moveBoard(int direction, int[][] board){
        int[][] newBoard = copy(board);
        boolean[][] sum = new boolean[N][N];    // 이미 합쳐진 경우 처리 배열

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
        // nexX, newY: 현재 위치에서 이동 or 합쳐질 좌표
        int newX = i + move[direction][0];
        int newY = j + move[direction][1];

        if(isInvalidCoord(newX, newY)){
            return;
        }

        // 이동할 위치가 0인 케이스
        // 0이 더 이상 나오지 않거나 유효하지 않은 좌표가 나올 때 까지 이동한다
        // 이동시: 현재 좌표와 다음 좌표가 direction 만큼 이동한다
        while(!isInvalidCoord(newX, newY) && board[newX][newY] == 0){
            board[newX][newY] = board[i][j];
            board[i][j] = 0;
            i = newX;
            j = newY;
            newX += move[direction][0];
            newY += move[direction][1];
        }

        if(isInvalidCoord(newX, newY)){
            return;
        }

        // 현재 좌표와 이동할 좌표가 갖는 수가 같을 경우 값을 합해준다.
        // 이동할 좌표 값이 0이 아닌경우 && 이동할 보드 좌표의 값 == 현재 보드 좌표의 값 && 합해진 적 없는 케이스
        if(board[newX][newY] != 0 && board[newX][newY] == board[i][j] && !sum[newX][newY]){
            board[newX][newY] += board[i][j];
            sum[newX][newY] = true;
            board[i][j] = 0;    // 값이 합해진 후 현재 좌표 값은 0으로 변경
        }
    }

    // board 주소 값을 공유할 수 없으니 새로 복사해서 사용하게 해주는 함수 (2차원 배열 복사)
    public static int[][] copy(int[][] board){
        int[][] copyBoard = new int[N][];

        for(int idx = 0; idx < N; idx++){
            copyBoard[idx] = board[idx].clone();
        }

        return copyBoard;
    }

    // 좌표가 유효하지 않음: true, 유효함: false
    public static boolean isInvalidCoord(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    // board 에서 가장 큰 값을 찾음
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