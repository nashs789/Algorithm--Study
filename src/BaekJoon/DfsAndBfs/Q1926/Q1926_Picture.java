package BaekJoon.DfsAndBfs.Q1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1926_Picture {

    public static int n;
    public static int m;
    public static int[][] paper;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    public static void bfs(){
        boolean[][] visited = new boolean[n][m];
        Queue<Coord> queue = new LinkedList<>();
        int area = 0;
        int maxSize = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] || paper[i][j] == 0){
                   continue;
                }

                int size = 0;
                area++;
                queue.add(new Coord(i, j));
                visited[i][j] = true;

                while(!queue.isEmpty()){
                    Coord curNode = queue.poll();
                    size++;

                    for(int k = 0; k < 4; k++){
                        int newX = curNode.x + move[k][0];
                        int newY = curNode.y + move[k][1];

                        if(isValidCoord(newX, newY) && !visited[newX][newY] && paper[newX][newY] == 1){
                            visited[newX][newY] = true;
                            queue.add(new Coord(newX, newY));
                        }
                    }
                }

                if(size > maxSize){
                    maxSize = size;
                }
            }
        }

        System.out.println(area);
        System.out.println(maxSize);
    }

    public static boolean isValidCoord(int x, int y){
        if(x < 0 || x >=n || y < 0 || y >= m){
            return false;
        }
        return true;
    }
}

class Coord {
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}