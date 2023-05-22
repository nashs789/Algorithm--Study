package BaekJoon.BackTracking.Q2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Q2580_Sudoku {

    public static int[][] sudoku;
    // visited 는 방문 보다는 숫자가 있음 유무
    public static boolean[][] visitedRow;   // 가로의 숫자(1 ~ 9) 체크
    public static boolean[][] visitedCol;   // 세로의 숫자(1 ~ 9) 체크
    public static boolean[][] visitedArea;  // 3 * 3 사이즈 숫자(1 ~ 9) 체크
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        visitedRow = new boolean[9][9];
        visitedCol = new boolean[9][9];
        visitedArea = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int j = 0; j < 9; j++){
                sudoku[i][j] = row[j];

                if(row[j] != 0){
                    visitedRow[i][row[j] - 1] = true;
                    visitedCol[j][row[j] - 1] = true;
                    visitedArea[getSquareIdx(i, j)][row[j] - 1] = true;
                }
            }
        }
        backTracking(0);
    }

    static void backTracking(int x){
        for(int i = x; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(sudoku[i][j] == 0){
                    Iterator<Integer> it = getPossibilities(i, j).iterator();   // 현재 위치에 들어갈 수 있는 숫자들 얻어옴

                    while(it.hasNext()){
                        int num = it.next() - 1;

                        if(isOk(i, j, num)){
                            sudoku[i][j] = num + 1;                      // 빈 칸에 숫자 입력
                            visitedRow[i][num] = true;                   // 해당 칸에 해당하는 row 에 숫자 채움
                            visitedCol[j][num] = true;                   // 해당 칸에 해당하는 col 에 숫자 채움
                            visitedArea[getSquareIdx(i, j)][num] = true; // 해당 칸에 해당하는 3 * 3 정사각형에 에 숫자 채움
                            backTracking(i);
                            sudoku[i][j] = 0;
                            visitedRow[i][num] = false;
                            visitedCol[j][num] = false;
                            visitedArea[getSquareIdx(i, j)][num] = false;
                        }
                    } // while end
                    return;    // 모든 숫자 순회 후 빈칸을 충족하는 숫자가 없는 경우 리턴
                }
            }
        }

        // 반복문을 통해 [8][8] 까지 전부 채운 경우 출력 후 종료
        for(int a[] : sudoku){
            for(int b : a){
                sb.append(b).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
        System.exit(0);
    }

    /**
     * 빈칸에 들어갈 수 있는 모든 숫자 반환
     * @param x: 좌표 x
     * @param y: 좌표 y
     * @return
     */
    static Set<Integer> getPossibilities(int x, int y){
        Set<Integer> set = new HashSet<>();

        for(int idx = 0; idx < 9; idx++){
            int num = idx + 1;

            if(!visitedRow[x][idx]){
                set.add(num);
            }

            if(visitedCol[y][idx]){
                set.remove(num);
            }

            if(visitedArea[getSquareIdx(x, y)][idx]){
                set.remove(num);
            }
        }

        return set;
    }

    /**
     * 현재 빈 칸에 해당하는 숫자가 들어갈 수 있는지 체크
     * @param x: 좌표 x
     * @param y: 좌표 y
     * @param num: 숫자 (1 ~ 9)
     * @return
     */
    static boolean isOk(int x, int y, int num){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++) {
                if (visitedRow[x][num] || visitedCol[y][num] || visitedArea[getSquareIdx(x, y)][num]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 3 * 3 정사각형 사이즈 인덱스 구하는 메소드
    static int getSquareIdx(int x, int y) {
        return (x / 3) * 3 + (y / 3);
    }
}