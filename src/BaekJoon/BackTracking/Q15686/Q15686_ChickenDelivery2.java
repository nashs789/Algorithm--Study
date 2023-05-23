package BaekJoon.BackTracking.Q15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q15686_ChickenDelivery2 {

    public static int N;
    public static int M;
    public static int[][] map;
    public static Store[] comb;
    public static List<Store> storeList;
    public static List<House> houseList;
    public static boolean[] visited;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        comb = new Store[M];

        storeList = new ArrayList<>();
        houseList = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                int type = Integer.parseInt(st.nextToken());

                if(type == 1){
                    houseList.add(new House(i, j));
                } else if(type == 2){
                    storeList.add(new Store(i, j));
                }
            }
        }

        visited = new boolean[storeList.size()];
        backTracking(0, 0);

        System.out.println(answer);
    }

    public static void backTracking(int storeIdx, int comIdx){
        if(comIdx == M){
            int sum = 0;

            for(Store s : comb){
                for(int i = 0; i < houseList.size(); i++){
                    House h = houseList.get(i);
                    int dist = Math.abs(s.x - h.x) + Math.abs(s.y - h.y);

                    if(h.min > dist){
                        h.min = dist;
                    }
                }
            }

            for(int idx = 0; idx < houseList.size(); idx++){
                sum += houseList.get(idx).min;
            }

            if(answer > sum){
                answer = sum;
            }

            for(int i = 0; i < houseList.size(); i++){
                House h = houseList.get(i);

                h.min = Integer.MAX_VALUE;
            }

            return;
        }

        for(int i = storeIdx; i < storeList.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                comb[comIdx] = storeList.get(i);
                backTracking(i + 1, comIdx + 1);
                visited[i] = false;
            }
        }
    }
}
// 12:00
/*
이 로직으로 약 1시간 풀어봤는데 남기는 치킨집이 무조건 최단 거리를 갖는게 아니였음
브루트 포스 혹은 백트래킹으로 푸는게 맞는듯
5 2
0 1 0 2 0
0 0 0 0 0
0 0 0 1 0
2 0 1 1 0
1 1 1 2 2
Correct: 13
WRONG: 11

5 2
1 1 2 0 2
2 1 1 2 2
0 0 2 1 0
2 0 1 1 0
0 1 0 2 1
Correct: 14
WRONG: 10

5 2
1 0 0 1 0
2 0 0 2 2
0 0 2 0 1
0 0 1 0 2
1 2 1 2 0
Correct: 11
WRONG: 6

6 2
2 0 1 2 1 0
2 0 0 0 1 0
1 1 0 0 2 2
1 2 0 0 2 1
0 0 0 1 0 2
0 0 0 0 0 0
Correct: 15
WRONG: 9

4 3
1 0 2 1
1 0 1 0
2 2 0 1
0 1 0 2
Correct: 8
WRONG: 7

5 3
1 2 1 0 2
2 1 1 0 1
0 0 1 1 0
0 0 0 1 2
1 2 1 0 0
Correct: 15
WRONG: 14
 */