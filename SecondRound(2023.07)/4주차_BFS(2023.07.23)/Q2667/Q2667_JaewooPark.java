/**
 *  [ 효율성 ]
 *  - 메모리: 14752KB
 *  - 시간 : 152ms
 */

package Baekjoon.July17;

import java.util.*;
import java.io.*;

public class Q2667_numAttatch {
    static int n;
    static int[] xCase = {1, 0, -1, 0};
    static int[] yCase = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> list;

    static boolean isInner(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n) {
            return true;
        }
        return false;
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        int area = 1;

        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = node.x + xCase[i];
                int newY = node.y + yCase[i];
                if (isInner(newX, newY) && !visited[newX][newY] && map[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    area++;
                    q.add(new Node(newX, newY));
                }
            }
        }
        list.add(area);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for (int e : list) {
            System.out.println(e);
        }
    }
}

class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
