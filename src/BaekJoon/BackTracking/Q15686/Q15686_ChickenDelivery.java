package BaekJoon.BackTracking.Q15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q15686_ChickenDelivery {

    public static int N;
    public static int M;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        List<Store> storeList = new ArrayList<>();
        List<House> houseList = new ArrayList<>();

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

        // 치킨집과 집들 사이의 거리의 합
        for(int i = 0; i < storeList.size(); i++){
            Store s = storeList.get(i);

            for(int j = 0; j < houseList.size(); j++){
                House h = houseList.get(j);
                int dist = Math.abs(s.x - h.x) + Math.abs(s.y - h.y);

                s.dist += dist;
            }
        }

        // 치킨집 과 집들간의 거리가 가장 적은 순으로 오름차순
        storeList.sort(new Comparator<Store>() {
            @Override
            public int compare(Store o1, Store o2) {
                return o1.dist - o2.dist;
            }
        });

        // 치킨집 폐업
        while(storeList.size() != M){
            storeList.remove(M);
        }

        // 남은 치킨집과 집들 사이의 거리중 가장 가까운 '치킨 거리' 계산
        for(int i = 0; i < storeList.size(); i++){
            Store s = storeList.get(i);

            for(int j = 0; j < houseList.size(); j++){
                House h = houseList.get(j);
                int dist = Math.abs(s.x - h.x) + Math.abs(s.y - h.y);

                if(h.min > dist){
                    h.min = dist;
                }
            }
        }

        System.out.println("===== Store =====");
        for(Store s : storeList){
            System.out.println(s.x + "    " + s.y + "  === > " + s.dist);
        }

        System.out.println("===== House =====");
        for(House h : houseList){
            System.out.println(h.x + "    " + h.y + "  === > " + h.min);
        }

        int sum = 0;

        for(int idx = 0; idx < houseList.size(); idx++){
            sum += houseList.get(idx).min;
        }

        System.out.println(sum);
    }
}

class Store {
    int x;
    int y;
    int dist;

    public Store(int x, int y) {
        this.x = x;
        this.y = y;
        this.dist = 0;
    }
}

class House {
    int x;
    int y;
    int min;

    public House(int x, int y) {
        this.x = x;
        this.y = y;
        this.min = Integer.MAX_VALUE;
    }
}