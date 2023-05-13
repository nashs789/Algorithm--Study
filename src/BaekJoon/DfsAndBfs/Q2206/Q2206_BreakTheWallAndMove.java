package BaekJoon.DfsAndBfs.Q2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q2206_BreakTheWallAndMove {

    public static boolean[][] map;
    public static boolean[][][] visited;
    public static int row;
    public static int col;
    public static int[][] moveInfo = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sizeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        row = sizeInfo[0];
        col = sizeInfo[1];
        Node.col = col;
        Node.row = row;
        map = new boolean[row][col];            // true: 통과 가능, false: 통과 불가능
        visited = new boolean[row][col][2];     // x좌표, y좌표, (0: 벽을 부수지 않음, 1: 벽을 부숨)

        for(int i = 0; i < row; i++){
            int[] wallInfo = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

            for(int j = 0; j < col; j++){
                map[i][j] = wallInfo[j] == 0 ? true : false;
            }
        }

        bfs();
    }

    private static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 1, false));
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();

            if(curNode.x == row - 1 && curNode.y == col - 1){
                System.out.println(curNode.cnt);
                return;
            }

            System.out.println("curNode === > " + curNode.x + "    " + curNode.y + "    cnt: " + curNode.cnt + "    broke: " + curNode.broke);

            // 상, 하, 좌, 우 이동
            for(int idx = 0; idx < 4; idx++){
                int x = curNode.x + moveInfo[idx][0];
                int y = curNode.y + moveInfo[idx][1];

                // 방문 가능한 좌표인지 확인
                if(curNode.move(x, y)){
                    // 벽이 아닌경우
                    if(map[x][y]){
                        // 벽을 부수지 않았던 노드 && 방문하지 않았던 경우
                        if(!curNode.broke && !visited[x][y][0]){
                            queue.add(new Node(x, y, curNode.cnt + 1, curNode.broke));
                            visited[x][y][0] = true;
                        } else if(curNode.broke && !visited[x][y][1]){    // 벽을 부수고 이동한 노드 && 방문하지 않았던 경우
                            queue.add(new Node(x, y, curNode.cnt + 1, curNode.broke));
                            visited[x][y][1] = true;
                        }
                    } else {    // 벽인 경우
                        if(!curNode.broke){    // 아직 벽을 부술 기회가 있는 노드
                            queue.add(new Node(x, y, curNode.cnt + 1, !curNode.broke));
                            visited[x][y][1] = true;
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }
}

class Node{
    public static int row;
    public static int col;

    int x;
    int y;
    int cnt;
    boolean broke;  // true: 벽을 이미 부숨, false: 벽을 아직 안부숨

    public Node(int x, int y, int cnt, boolean broke) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.broke = broke;
    }

    public boolean move(int x, int y){
        if(x < 0 || x >= row || y < 0 || y >= col){
            return false;
        }

        return true;
    }
}
// 15:03
/*
8 8
01000100
01010100
01010100
01010100
01010100
01010100
01010100
00010100

answer: 29

5 10
0000011000
1101011010
0000000010
1111111110
1111000000

answer: 14

5 5
01100
01000
01110
01000
00010

answer: 9

8 4
0000
0110
1110
0000
0111
0000
1110
0000

answer: 11

6 4
0000
1110
0110
0000
0111
0000

answer: 9

 */