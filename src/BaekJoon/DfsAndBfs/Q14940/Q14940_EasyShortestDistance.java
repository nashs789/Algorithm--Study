package BaekJoon.DfsAndBfs.Q14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14940_EasyShortestDistance {

    private static int row = 0;
    private static int col = 0;
    private static int startX = 0;
    private static int startY = 0;
    private static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[][] nodeMap;
    private static int[][] distance;
    private static boolean[][] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        nodeMap = new int[row][col];
        distance = new int[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < col; j++){
                nodeMap[i][j] = Integer.parseInt(st.nextToken());

                if(nodeMap[i][j] == 2){
                    startX = i;
                    startY = j;
                }
            }
        }

        BFS();
        sb = new StringBuilder();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!visited[i][j] && nodeMap[i][j] == 1){
                    sb.append(-1).append(" ");
                } else {
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void BFS(){
        visited = new boolean[row][col];
        Queue<Point> queue = new LinkedList<>();

        visited[startX][startY] = true;
        queue.add(new Point(startX, startY));

        while(!queue.isEmpty()){
            Point curPoint = queue.poll();
            int curX = curPoint.x;
            int curY = curPoint.y;

            for(int idx = 0; idx < 4; idx++){
                int nextX = curX + move[idx][0];
                int nextY = curY + move[idx][1];

                if(nextX >= 0 && nextY >= 0 && nextX < row && nextY < col){
                    if(!visited[nextX][nextY] && nodeMap[nextX][nextY] == 1){
                        queue.add(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                        distance[nextX][nextY] = distance[curX][curY] + 1;
                    }
                }
            }
        }
    }
}

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}