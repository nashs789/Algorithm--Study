/**
 *  [ 효율성 ]
 *  - 메모리: 19724KB
 *  - 시간 : 212ms
 */

 package Baekjoon.July18_2;

import java.util.*;
import java.io.*;

public class Q2636_cheese {
    static int eraseCount;
    static int beforeCount;
    static int rotateCount;
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] xCase = {1, 0, -1, 0};
    static int[] yCase = {0, 1, 0, -1};

    public static boolean isInner(int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < m);
    }
    public static void visitedReset() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static int bfs(int x, int y) {
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int px = node.getX() + xCase[i];
                int py = node.getY() + yCase[i];
                if (isInner(px, py) && !visited[px][py] && map[px][py] == 0) {
                    visited[px][py] = true;
                    q.add(new Node(px, py));
                }
                else if (isInner(px, py) && !visited[px][py] && map[px][py] == 1) {
                    visited[px][py] = true;
                    map[px][py] = 0;
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            //st = new StringTokenizer(br.readLine());
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        eraseCount = bfs(0, 0);
        while (eraseCount > 0) {
            rotateCount++;
            visitedReset();
            beforeCount = eraseCount;
            eraseCount = bfs(0, 0);
        }
        System.out.println(rotateCount + "\n" + beforeCount);
    }
}

class Node {
    private int x;
    private int y;
    Node (int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
