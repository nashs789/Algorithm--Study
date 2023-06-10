package Programmers.Lv2.Q3;

import java.util.LinkedList;
import java.util.Queue;

public class Q3_gameMapShortestDistance_sol2 {

    public static int n;
    public static int m;
    public static boolean[][] visited;
    public static int[][] maps;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        maps = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<Node2> queue = new LinkedList<>();

        queue.add(new Node2(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node2 curNode = queue.poll();

            if(curNode.x == n - 1 && curNode.y == m - 1){
                return curNode.dist;
            }

            for(int moveIdx = 0; moveIdx < 4; moveIdx++){
                int newX = curNode.x + move[moveIdx][0];
                int newY = curNode.y + move[moveIdx][1];

                if(isValidCoord(newX, newY) && maps[newX][newY] == 1 && !visited[newX][newY]){
                    queue.add(new Node2(newX, newY, curNode.dist + 1));
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }

    public static boolean isValidCoord(int newX, int newY) {
        if(newX < 0 || newX >= n || newY < 0 || newY >= m){
            return false;
        }

        return true;
    }
}

class Node2{
    int x;
    int y;
    int dist;

    public Node2(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
