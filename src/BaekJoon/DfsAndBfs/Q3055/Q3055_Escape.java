package BaekJoon.DfsAndBfs.Q3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3055_Escape {

    public static int R;
    public static int C;
    public static Vertex srt;
    public static Vertex end;
    public static String[][] map;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];

        for(int i = 0; i < R; i++){
            map[i] = br.readLine().split("");

            for(int j = 0; j < C; j++){
                if(map[i][j].equals("S")){
                    srt = new Vertex(i, j, 0);
                }

                if(map[i][j].equals("D")){
                    end = new Vertex(i, j);
                }
            }
        }

        bfs();
        System.out.println("KAKTUS");
    }

    public static void bfs(){
        Queue<Vertex> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        int hour = 0;

        queue.add(srt);
        visited[srt.x][srt.y] = true;

        while (!queue.isEmpty()){
            Vertex curV = queue.poll();

            if(curV.hour == hour){
                beFlooded();
                hour++;
            }

            for(int moveIdx = 0; moveIdx < 4; moveIdx++){
                int newX = curV.x + move[moveIdx][0];
                int newY = curV.y + move[moveIdx][1];

                if(isValidCoord(newX, newY) && !visited[newX][newY]){
                    String mapInfo = map[newX][newY];

                    if(mapInfo.equals("D")){
                        System.out.println(curV.hour + 1);
                        System.exit(0);
                    }

                    if(mapInfo.equals("*") || mapInfo.equals("X")){
                        continue;
                    }

                    if(mapInfo.equals(".")){
                        map[newX][newY] = "S";
                        visited[newX][newY] = true;
                        queue.add(new Vertex(newX, newY, curV.hour + 1));
                    }
                }
            }
        }
    }

    public static void beFlooded(){
        boolean[][] newFlooded = new boolean[R][C];

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j].equals("*") && !newFlooded[i][j]){
                    for(int moveIdx = 0; moveIdx < 4; moveIdx++){
                        int newX = i + move[moveIdx][0];
                        int newY = j + move[moveIdx][1];

                        if(isValidCoord(newX, newY) && map[newX][newY].equals(".") && !newFlooded[newX][newY]){
                            newFlooded[newX][newY] = true;
                            map[newX][newY] = "*";
                        }
                    }
                }
            }
        }
    }

    public static boolean isValidCoord(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}

class Vertex {
    int x;
    int y;
    int hour;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vertex(int x, int y, int hour) {
        this.x = x;
        this.y = y;
        this.hour = hour;
    }
}