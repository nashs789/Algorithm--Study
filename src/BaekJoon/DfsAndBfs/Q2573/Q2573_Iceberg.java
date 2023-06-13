package BaekJoon.DfsAndBfs.Q2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2573_Iceberg {

    public static int N;                // row
    public static int M;                // column
    public static int year;             // year
    public static Iceberg[][] map;      // 빙산 지도
    public static Set<Iceberg> notMelted = new HashSet<>();    // 녹지 않은 빙산들만 모아놓는 콜렉션
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Iceberg[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                int size = Integer.parseInt(st.nextToken());

                if(size != 0){
                    notMelted.add(new Iceberg(i, j, size));
                }

                map[i][j] = new Iceberg(i, j, size);
            }
        }

        while(!bfs()){

        }
    }

    public static boolean bfs(){
        Queue<Iceberg> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int area = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j] || map[i][j].size == 0){
                    continue;
                }

                area++;

                // 영역이 여러개로 나뉜 경우
                if(area > 1){
                    System.out.println(year);
                    return true;
                }

                queue.add(new Iceberg(i, j, map[i][j].size));
                visited[i][j] = true;

                while(!queue.isEmpty()){
                    Iceberg ib = queue.poll();

                    for(int idx = 0; idx < 4; idx++) {
                        int newX = ib.x + move[idx][0];
                        int newY = ib.y + move[idx][1];

                        if(isValidCoord(newX, newY) && !visited[newX][newY] && map[newX][newY].size != 0){
                            queue.add(new Iceberg(newX, newY, map[newX][newY].size));
                            visited[newX][newY] = true;
                        }
                    }
                }
            }
        }

        // 한 개의 영역도 남아있지 않는 케이스
        if(area == 0){
            System.out.println(0);
            System.exit(0);
        }

        setNextYear();
        return false;
    }

    public static void setNextYear(){
        for(Iceberg i : notMelted){
            if(i.size == 0){
                continue;
            }

            int seaSurf = 0;    // 주변 해수면 갯수

            for(int idx = 0; idx < 4; idx++){
                int newX = i.x + move[idx][0];
                int newY = i.y + move[idx][1];

                if(isValidCoord(newX, newY) && map[newX][newY].size == 0){
                    seaSurf++;
                }
            }

            i.size -= seaSurf;
        }

        // 현재 지도에서 다음 년도로 넘어갈 때 빙산이 녹는량 계싼
        for(Iceberg i : notMelted){
            map[i.x][i.y].size = i.size <= 0 ? 0 : i.size;
        }

        year++;
    }

    public static boolean isValidCoord(int x, int y){
        if(x >= N || x < 0 || y >= M || y < 0){
            return false;
        }
        return true;
    }
}

class Iceberg{
    int x;
    int y;
    int size;

    public Iceberg(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }
}