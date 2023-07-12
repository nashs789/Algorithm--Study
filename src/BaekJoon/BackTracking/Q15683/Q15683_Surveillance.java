package BaekJoon.BackTracking.Q15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Q15683_Surveillance {

    public static int N;
    public static int M;
    public static int min = Integer.MAX_VALUE;
    public static List<Cctv> cctvs;
    public static List<Cctv> typeFive;
    public static int[][] office;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];
        cctvs = new ArrayList<>();
        typeFive = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                int type = Integer.parseInt(st.nextToken());

                if(0 < type && type < 5){
                    cctvs.add(new Cctv(i, j, type));
                }

                if(type == 5){
                    typeFive.add(new Cctv(i, j, type));
                }

                office[i][j] = type;
            }
        }

        setTypeFive();    // 5번째 타입은 90도로 돌려도 같기 때문에 사전처리
        backTracking(0, office);
        System.out.println(min);
    }

    public static void backTracking(int cctvIdx, int[][] office){
        if(cctvIdx == cctvs.size()){
            min = Math.min(min, getBlindSpot(office));
            return;
        }

        Cctv cctv = cctvs.get(cctvIdx);

        for(int idx = 0; idx < 4; idx++) {
            int[][] newOffice = copy(office);

            switch (cctv.type) {
                case 1:
                    onSurveillance(cctv.x, cctv.y, idx, newOffice);
                    break;
                case 2:
                    if(idx == 0){    // 0 left right
                        onSurveillance(cctv.x, cctv.y, 2, newOffice);
                        onSurveillance(cctv.x, cctv.y, 3, newOffice);
                    } else if(idx == 1){    // 1 up down
                        onSurveillance(cctv.x, cctv.y, 0, newOffice);
                        onSurveillance(cctv.x, cctv.y, 1, newOffice);
                    }
                    break;
                case 3:
                    if(idx == 0){    // 0 up right
                        onSurveillance(cctv.x, cctv.y, 0, newOffice);
                        onSurveillance(cctv.x, cctv.y, 3, newOffice);
                    } else if(idx == 1){    // 1 right down
                        onSurveillance(cctv.x, cctv.y, 3, newOffice);
                        onSurveillance(cctv.x, cctv.y, 1, newOffice);
                    } else if(idx == 2){    // 2 down left
                        onSurveillance(cctv.x, cctv.y, 1, newOffice);
                        onSurveillance(cctv.x, cctv.y, 2, newOffice);
                    } else {    // 3 left up
                        onSurveillance(cctv.x, cctv.y, 2, newOffice);
                        onSurveillance(cctv.x, cctv.y, 0, newOffice);
                    }
                    break;
                case 4:
                    if(idx == 0){   // 0 left up right
                        onSurveillance(cctv.x, cctv.y, 0, newOffice);
                        onSurveillance(cctv.x, cctv.y, 2, newOffice);
                        onSurveillance(cctv.x, cctv.y, 3, newOffice);
                    } else if(idx == 2){    // 1 up right down
                        onSurveillance(cctv.x, cctv.y, 0, newOffice);
                        onSurveillance(cctv.x, cctv.y, 3, newOffice);
                        onSurveillance(cctv.x, cctv.y, 1, newOffice);
                    } else if(idx == 3){    // 2 right down left
                        onSurveillance(cctv.x, cctv.y, 2, newOffice);
                        onSurveillance(cctv.x, cctv.y, 1, newOffice);
                        onSurveillance(cctv.x, cctv.y, 3, newOffice);
                    } else {    // 3 down left up
                        onSurveillance(cctv.x, cctv.y, 1, newOffice);
                        onSurveillance(cctv.x, cctv.y, 2, newOffice);
                        onSurveillance(cctv.x, cctv.y, 0, newOffice);
                    }
                    break;
                default:
            }

            backTracking(cctvIdx + 1, newOffice);
        }
    }

    public static void onSurveillance(int x, int y, int direction, int[][] office){
        x += move[direction][0];
        y += move[direction][1];

        while(!isInvalidCoord(x, y)){
            // 벽에 막혀서 사각지대 형성
            if(office[x][y] == 6){
                return;
            }

            office[x][y] = 7;
            x += move[direction][0];
            y += move[direction][1];
        }
    }

    public static void setTypeFive(){
        Iterator<Cctv> it = typeFive.listIterator();

        while(it.hasNext()){
            Cctv cctv = it.next();

            for(int idx = 0; idx < 4; idx++){
                // 상, 하, 좌, 우 감시상태로 만들기
                onSurveillance(cctv.x, cctv.y, idx, office);
            }
        }
    }

    public static int getBlindSpot(int[][] office){
        int spot = 0;

        for(int[] offices : office){
            for(int room : offices){
                if(room == 0){
                    spot++;
                }
            }
        }

        return spot;
    }

    // board 주소 값을 공유할 수 없으니 새로 복사해서 사용하게 해주는 함수 (2차원 배열 복사)
    public static int[][] copy(int[][] office){
        int[][] copyOffice = new int[N][];

        for(int idx = 0; idx < N; idx++){
            copyOffice[idx] = office[idx].clone();
        }

        return copyOffice;
    }

    public static boolean isInvalidCoord(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}

class Cctv{
    int x;
    int y;
    int type;    // 1: →    2: ← →    3: ↑ →    4: ← ↑ →

    public Cctv(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}