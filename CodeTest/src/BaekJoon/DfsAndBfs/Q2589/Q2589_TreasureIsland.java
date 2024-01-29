package BaekJoon.DfsAndBfs.Q2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2589_TreasureIsland {

    public static int N;
    public static int M;
    public static int answer = Integer.MIN_VALUE;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().split("");
        }

        List<Vertex> list = getStartPoint();

        for(Vertex v : list){
            v.dist = 0;
            bfs(v);
        }

        System.out.print(answer);
    }

    public static void bfs(Vertex srtV){
        Queue<Vertex> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(srtV);
        visited[srtV.x][srtV.y] = true;

        while(!queue.isEmpty()){
            Vertex curV = queue.poll();
            answer = Math.max(answer, curV.dist);

            for(int moveIdx = 0; moveIdx < 4; moveIdx++){
                int nextX = curV.x + move[moveIdx][0];
                int nextY = curV.y + move[moveIdx][1];

                if(isValidCoord(nextX, nextY) && map[nextX][nextY].equals("L") && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.add(new Vertex(nextX, nextY, curV.dist + 1));
                }
            }
        }
    }

    public static List<Vertex> getStartPoint(){
        List<Vertex> list = new ArrayList<>();
        boolean[][] visited = new boolean[N][M];
        Queue<Vertex> queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                // 임의의 시작점 선정
                if(visited[i][j] || map[i][j].equals("W")){
                    continue;
                }

                Vertex maxV = new Vertex(0, 0, Integer.MIN_VALUE);
                visited[i][j] = true;
                queue.add(new Vertex(i, j, 0));

                while(!queue.isEmpty()){
                    Vertex curV = queue.poll();

                    if(maxV.dist < curV.dist){
                        maxV = curV;
                    }

                    for(int moveIdx = 0; moveIdx < 4; moveIdx++){
                        int nextX = curV.x + move[moveIdx][0];
                        int nextY = curV.y + move[moveIdx][1];

                        if(isValidCoord(nextX, nextY) && map[nextX][nextY].equals("L") && !visited[nextX][nextY]){
                            visited[nextX][nextY] = true;
                            queue.add(new Vertex(nextX, nextY, curV.dist + 1));
                        }
                    }
                }

                list.add(maxV);
            }
        }

        return list;
    }

    public static boolean isValidCoord(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

class Vertex{
    int x;
    int y;
    int dist;

    public Vertex(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}