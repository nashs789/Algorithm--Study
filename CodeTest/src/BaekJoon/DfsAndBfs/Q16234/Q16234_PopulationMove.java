package BaekJoon.DfsAndBfs.Q16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16234_PopulationMove {

    public static int N;
    public static int L;
    public static int R;
    public static Coord[][] map;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new Coord[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = new Coord(i, j, Integer.parseInt(st.nextToken()));
            }
        }
        int day = 0;

        while (bfs()){
            day++;
        }

        System.out.println(day);
    }

    public static boolean bfs(){
        Queue<Coord> queue = new LinkedList<>();    // BFS 로직을 위한 콜렉션
        Set<Coord> united = new HashSet<>();        // 연합된 국가들의 좌표값을 보관하기 위한 콜렉션
        visited = new boolean[N][N];
        boolean moveFlag = false;                   // 연합이 만들어져서 인구 이동이 있는경우 true 변경

        int sum = 0;    // 연합의 인구수 합
        int cnt = 0;    // 연합 국가의 개수

        // 첫 2중 for 문: 모든 국가들을 방문해서 주변 국가와 연합이 되도록 만들어줌(연합이 없으면 국가 1개로 진행)
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){     // 아직 방문하지 않은 국가가 있으니 시작점으로 BFS 로직 시작
                    queue.add(map[i][j]);
                    visited[i][j] = true;
                    united.add(map[i][j]);

                    while (!queue.isEmpty()){
                        Coord curCoord = queue.poll();
                        sum += curCoord.people;
                        cnt++;

                        // 4방향으로 이동
                        for(int idx = 0; idx < 4; idx++){
                            int newX = curCoord.x + move[idx][0];
                            int newY = curCoord.y + move[idx][1];

                            // 유효한 방향 조건
                            if(newX >= 0 && newX < N && newY >= 0 && newY < N){
                                int gap = Math.abs(curCoord.people - map[newX][newY].people);

                                if(!visited[newX][newY] && (L <= gap && gap <= R)){
                                    visited[newX][newY] = true;
                                    queue.add(map[newX][newY]);
                                    united.add(map[newX][newY]);
                                }
                            }
                        }
                    }

                    sum /= cnt;

                    // 연합 확인하는 중 국가가 2 이상이라는 것은 인구 이동이 한 번이라도 있었다는 뜻
                    if(cnt > 1){
                        moveFlag = true;
                    }

                    // 저장했던 좌표들을 인구 이동 후의 값으로 변경
                    for(Coord c : united){
                        map[c.x][c.y].people = sum;
                    }

                    sum = 0;
                    cnt = 0;
                    united.clear();
                }
            }
        }
        return moveFlag;
    }
}

class Coord{
    int x;
    int y;
    int people;

    public Coord(int x, int y, int people) {
        this.x = x;
        this.y = y;
        this.people = people;
    }
}
