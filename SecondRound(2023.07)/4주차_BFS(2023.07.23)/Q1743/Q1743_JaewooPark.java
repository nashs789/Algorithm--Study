/**
 *  [ 효율성 ]
 *  - 메모리: 16308KB
 *  - 시간 : 184ms
 */

package Baekjoon.July17;

import java.util.*;
import java.io.*;
import java.awt.Point;

public class Q1743_avoidFood{
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int[] xCase = {1, 0, -1, 0};
    static int[] yCase = {0, 1, 0, -1};
    static Queue<Point> q;
    static ArrayList<Point> findTrash;

    static void bfs(Point p) {
        int count = 1;
        q = new LinkedList<Point>();
        q.add(p);
        while (!q.isEmpty()) {
            Point point = q.poll();
            Double dx = point.getX();
            Double dy = point.getY();
            int x = dx.intValue();
            int y = dy.intValue();
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + xCase[i];
                int newY = y + yCase[i];
                if (map[newX][newY] == -1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    count++;
                    q.add(new Point(newX, newY));
                }
            }
        }
        max = Math.max(count, max);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n + 2][m + 2];
        visited = new boolean[n + 2][m + 2];
        findTrash = new ArrayList<Point>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            findTrash.add(new Point(x, y));
            map[x][y] = -1;
        }

        for (Point e : findTrash) {
            Double dx = e.getX();
            Double dy = e.getY();
            int x = dx.intValue();
            int y = dy.intValue();

            if (!visited[x][y]) {
                bfs(e);
            }
        }
        System.out.println(max);
    }
}
