/**
 * [ 문제 ]
 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
 * 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
 * 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 *
 * 사진 첨부 -> readme에 추가할 것
 *
 * [ 입력 ]
 * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 *
 * [ 출력 ]
 * 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 *
 * [ 예제 입력 ]                [ 예제 출력 ]
 * 7                                3
 * 0110100                          7
 * 0110101                          8
 * 1110101                          9
 * 0000111
 * 0100000
 * 0111110
 * 0111000
 */

package BaekJoon.DfsAndBfs.Q2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2667_ComplexNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, House> houseMap = new HashMap<>();
        int nodeIdx = 0;

        for(int i = 0; i < N; i++){
            int[] line = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            
            for(int j = 0; j < N; j++){
                houseMap.put(nodeIdx++, new House(line[j]));
            }
        }

        Graph graph = new Graph(N * N);

        graph.linkNode(N, houseMap);
        graph.BFS(houseMap);
        graph.printResult();
    }
}

class Graph{
    private int nodeCnt;
    private LinkedList<Integer>[] adj;
    private int complexCnt = 0;                                          // 단지 카운트
    private List<Integer> countOfHouseInComplex = new ArrayList<>();     // 단지 내에 있는 집 카운트

    Graph(int nodeCnt){
        this.nodeCnt = nodeCnt;
        adj = new LinkedList[nodeCnt];

        for(int idx = 0; idx < nodeCnt; idx++){
            adj[idx] = new LinkedList<>();
        }
    }

    void linkNode(int N, Map<Integer, House> houseMap){
        for(int idx = 0; idx < this.nodeCnt; idx++){
            // 비어있는 집일경우
            if(houseMap.get(idx).getEmpty() == 0){
                continue;
            }

            // 기준 노드로 부터 '상' 에 위치한 노드 연결
            if(idx - N >= 0 && houseMap.get(idx - N).getEmpty() == 1){
               adj[idx].offer(idx - N);
            }

            // 기준 노드로 부터 '하' 에 위치한 노드 연결
            if(idx + N < nodeCnt && houseMap.get(idx + N).getEmpty() == 1){
                adj[idx].offer(idx + N);
            }

            // 기준 노드로 부터 '좌' 에 위치한 노드 연결
            if((idx - 1) >= 0 && (idx - 1) % N != N - 1 && houseMap.get(idx - 1).getEmpty() == 1){
                adj[idx].offer(idx - 1);
            }

            // 기준 노드로 부터 '우' 에 위치한 노드 연결
            if((idx + 1) % N != 0 && houseMap.get(idx + 1).getEmpty() == 1){
                adj[idx].offer(idx + 1);
            }
        }
    }

    void BFS(Map<Integer, House> houseMap){
        boolean[] visited = new boolean[nodeCnt];
        Queue<Integer> queue = new LinkedList<>();

        for(int idx = 0; idx < this.nodeCnt; idx++){
            int houseCnt = 1;   // 각 단지별 집 카운트

            if(visited[idx] || houseMap.get(idx).getEmpty() == 0){
                continue;
            }

            queue.offer(idx);
            visited[idx] = true;
            this.complexCnt++;

            while (!queue.isEmpty()){
                int curNode = queue.poll();

                Iterator<Integer> it = adj[curNode].listIterator();

                while(it.hasNext()){
                    int linkedNode = it.next();

                    if(!visited[linkedNode]){
                        houseCnt++;
                        visited[linkedNode] = true;
                        queue.offer(linkedNode);
                    }
                }
            }

            countOfHouseInComplex.add(houseCnt);
        }
    }

    void printResult(){
        System.out.println(complexCnt);

        countOfHouseInComplex.sort(Comparator.naturalOrder());

        for(int idx = 0; idx < countOfHouseInComplex.size(); idx++){
            System.out.println(countOfHouseInComplex.get(idx));
        }
    }
}

class House{
    private int empty;      // 0: empty    1: not empty

    House(int empty){
        this.empty = empty;
    }

    int getEmpty(){
        return empty;
    }
}