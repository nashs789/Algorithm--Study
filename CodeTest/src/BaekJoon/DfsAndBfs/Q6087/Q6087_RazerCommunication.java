package BaekJoon.DfsAndBfs.Q6087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q6087_RazerCommunication {

    public static int W;    // width = column
    public static int H;    // height = row
    public static String[][] map;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new String[H][W];
        Node srtNode = new Node(0, 0, 0, 5);

        for(int i = 0; i < H; i++){
            String[] mapRowInfo = br.readLine().split("");

            for(int j = 0; j < W; j++){
                // 탐색 시작점 세팅 (두 개의 C 중 한개만 있으면 됨)
                if(mapRowInfo[j].equals("C")){
                    srtNode = new Node(i, j, 0, 5);
                }
                map[i][j] = mapRowInfo[j];
            }
        }

        bfs(srtNode);
    }

    public static void bfs(Node srtNode){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[H][W];
        int[][] mirrors = new int[H][W];
        int answer = Integer.MAX_VALUE;

        queue.add(srtNode);
        visited[srtNode.x][srtNode.y] = true;

        while (!queue.isEmpty()){
            Node curNode = queue.poll();

            // 레이저 도착점인 C && 시작점과 다른 좌표의 C 인경우
            if(map[curNode.x][curNode.y].equals("C") && (curNode.x != srtNode.x || curNode.y != srtNode.y)){
                if(answer > curNode.mirror){
                    answer = curNode.mirror;
                }
            }

            for(int idx = 0; idx < 4; idx++){
                int newX = curNode.x + move[idx][0];
                int newY = curNode.y + move[idx][1];

                if(isValidCoord(newX, newY)){
                    if(map[newX][newY].equals("*")){
                        continue;
                    }

                    Node linkedNode;
                    // idx = 0, 1, 2, 3 (상, 하, 좌, 우)
                    // if, else if 는 합쳐도 무방(조건이 너무 길어져서 두 개로 나눴음)
                    if((curNode.dir == 0 || curNode.dir == 1) && (idx == 2 || idx == 3)){   // 현재 진행 방향은 '상', '하' 지만 움직이고자 하는 방향은 '좌', '우'인 케이스
                        linkedNode = new Node(newX, newY, curNode.mirror + 1, idx);
                    } else if((curNode.dir == 2 || curNode.dir == 3) && (idx == 0 || idx == 1)){    // 현재 진행 방향은 '좌', '우' 지만 움직이고자 하는 방향은 '상', '하'인 케이스
                        linkedNode = new Node(newX, newY, curNode.mirror + 1, idx);
                    } else {
                        linkedNode = new Node(newX, newY, curNode.mirror, idx);     // 진행방향 == 움직이고자 하는 방향
                    }

                    // 방문을 하지 않음 || 이미 방문한 노드가 거울을 더 많이 쓴 경우
                    if(!visited[newX][newY] || curNode.mirror < mirrors[newX][newY]){
                        queue.add(linkedNode);
                        visited[newX][newY] = true;
                        mirrors[newX][newY] = linkedNode.mirror;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean isValidCoord(int x, int y){
        if(x < 0 || x >= H || y < 0 || y >= W){
            return false;
        }
        return true;
    }
}

class Node{
    int x;
    int y;
    int mirror;
    int dir;    // 0, 1, 2, 3 (상, 하, 좌, 우) 5 (시작)

    public Node(int x, int y, int mirror, int dir) {
        this.x = x;
        this.y = y;
        this.mirror = mirror;
        this.dir = dir;
    }
}
