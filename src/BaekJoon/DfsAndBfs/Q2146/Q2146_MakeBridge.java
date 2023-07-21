package BaekJoon.DfsAndBfs.Q2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2146_MakeBridge {

    public static int N;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static int[][] map;
    public static boolean[][] visited;
    public static List<Vertex> list;
    public static Queue<Integer> answer = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int idx = 0; idx < N; idx++){
            map[idx] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int area = 1;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    setArea(new Vertex(i, j, 0, area++));
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int mapInfo = map[i][j];

                if(mapInfo != 0 && !set.contains(mapInfo)){
                    set.add(mapInfo);
                    list.add(new Vertex(i, j, 0, mapInfo));
                }
            }
        }

        while(true){
            if(list.size() == 1){
                System.out.println(0);
                break;
            }

            for(Vertex srtV : list){
                visited = new boolean[N][N];
                bfs(srtV);
                srtV.dist += 1;
            }

            if(answer.size() > 0){
                System.out.println(answer.poll());
                break;
            }
        }
    }

    public static void bfs(Vertex srtV){
        Queue<Vertex> queue = new LinkedList<>();

        queue.add(srtV);
        visited[srtV.x][srtV.y] = true;
        
        while(!queue.isEmpty()){
            Vertex curV = queue.poll();

            for(int moveIdx = 0; moveIdx < 4; moveIdx++){
                int nextX = curV.x + move[moveIdx][0];
                int nextY = curV.y + move[moveIdx][1];

                if(isValidCoord(nextX, nextY)){
                    int nextMapInfo = map[nextX][nextY];

                    if(nextMapInfo != 0 && nextMapInfo != curV.island){
                        int islandIdx = list.indexOf(new Vertex(0, 0, 0, nextMapInfo));

                        answer.add(curV.dist + list.get(islandIdx).dist);
                    }

                    if(nextMapInfo == 0){
                        map[nextX][nextY] = curV.island;
                        visited[nextX][nextY] = true;
                    }

                    if(!visited[nextX][nextY] && nextMapInfo == curV.island){
                        visited[nextX][nextY] = true;
                        queue.add(new Vertex(nextX, nextY, curV.dist, curV.island));
                    }
                }
            }
        }
    }

    public static void setArea(Vertex srtV){
        Queue<Vertex> queue = new LinkedList<>();

        queue.add(srtV);
        visited[srtV.x][srtV.y] = true;

        while(!queue.isEmpty()){
            Vertex curV = queue.poll();
            map[curV.x][curV.y] = curV.island;

            for(int moveIdx = 0; moveIdx < 4; moveIdx++){
                int nextX = curV.x + move[moveIdx][0];
                int nextY = curV.y + move[moveIdx][1];

                if(isValidCoord(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    queue.add(new Vertex(nextX, nextY, 0, curV.island));
                }
            }
        }
    }

    public static boolean isValidCoord(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

class Vertex{
    int x;
    int y;
    int dist;
    int island;

    public Vertex(int x, int y, int dist, int island) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.island = island;
    }

    @Override
    public boolean equals(Object obj){
        Vertex v = (Vertex) obj;

        return this.island == v.island;
    }
}