package Programmers.Lv2.Q98;

import java.util.LinkedList;
import java.util.Queue;

public class Q98_EscapeMaze {

    private static int row = 0;
    private static int col = 0;
    private static Point strNode;
    private static Point endNode;
    private static Point leverNode;
    private static String[][] nodeMap;
    private static int move[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        String[] maps = {
                "EOOOO",
                "OOSOO",
                "XXXXO",
                "OOLOO",
                "OOOOO"
        };
        row = maps.length;
        col = maps[0].length();
        nodeMap = new String[row][col];

        for(int i = 0; i < row; i++){
            String[] temp = maps[i].split("");

            for(int j = 0; j < col; j++){
                nodeMap[i][j] = temp[j];

                if(nodeMap[i][j].equals("S")){
                    strNode = new Point(i, j);
                }

                if(nodeMap[i][j].equals("E")){
                    endNode = new Point(i, j);
                }

                if(nodeMap[i][j].equals("L")){
                    leverNode = new Point(i, j);
                }
            }
        }

        BFS();
    }

    static void BFS(){
        boolean[][] visited = new boolean[row][col];
        int[][] second = new int[row][col];
        Queue<Point> queue = new LinkedList<>();
        boolean lever = false;
        boolean escape = false;

        queue.add(strNode);
        visited[strNode.x][strNode.y] = true;

        while(!queue.isEmpty()){
            Point curNode = queue.poll();
            int curX = curNode.x;
            int curY = curNode.y;

            // 레버가 당겨졌으며 출구에 도착 했을 때
            if(curX == endNode.x && curY == endNode.y && lever){
                System.out.println(second[curX][curY]);
                escape = true;
                break;
            }

            for(int idx = 0; idx < 4; idx++){
                int nextX = curX + move[idx][0];
                int nextY = curY + move[idx][1];

                if(nextX >= 0 && nextY >= 0 && nextX < row && nextY < col){
                    // 지나갈 수 있을 때 Queue 에 값 저장 밑 거리 계산
                    if(!visited[nextX][nextY] && !nodeMap[nextX][nextY].equals("X")){
                        queue.add(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                        second[nextX][nextY] = second[curX][curY] + 1;
                    }

                    // 레버가 당겨지지 않은 상태에서 레버에 도달 했을 때
                    if(nextX == leverNode.x && nextY == leverNode.y && !lever){
                        lever = true;
                        // 왔던길을 다시 돌아가야 할 수 있으니 방문체크 초기화 및 Queue 초기화
                        queue.clear();
                        queue.add(new Point(nextX, nextY));
                        visited = new boolean[row][col];
                        break;
                    }
                }
            }
        }
        if(!escape){
            System.out.println(-1);
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