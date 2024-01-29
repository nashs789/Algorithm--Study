/**
 *  [ 효율성 ]
 *  - 메모리: 16888KB
 *  - 시간 : 208ms
 */

package Baekjoon.July18;

import java.util.*;
import java.io.*;

public class Q2178_mazeSearch {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] xCase = {1, 0, -1, 0};
    static int[] yCase = {0, 1, 0, -1};

    public static boolean isInner(int x, int y) {
        if (x >= 0 && y >= 0 && x <= n - 1 && y <= m - 1) {
            return true;
        }
        return false;
    }
    public static void bfs() {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0,0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = node.getX() + xCase[i];
                int y = node.getY() + yCase[i];
                if (isInner(x, y) && !visited[x][y] && map[x][y] != 0) {
                    visited[x][y] = true;
                    map[x][y] = map[node.getX()][node.getY()] + 1;
                    q.add(new Node(x, y));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
        }
        bfs();
        System.out.println(map[n - 1][m - 1]);
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