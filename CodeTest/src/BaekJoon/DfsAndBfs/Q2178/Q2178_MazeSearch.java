/**
 * [ 문제 ]
 * N×M크기의 배열로 표현되는 미로가 있다.
 *
 * 1	0	1	1	1	1
 * 1	0	1	0	1	0
 * 1	0	1	0	1	1
 * 1	1	1	0	1	1
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
 * 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 *
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 *
 * [ 입력 ]
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 *
 * [ 출력 ]
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 *
 * [ 예제 입력 ]                [ 예제 출력 ]
 * 4 6                             15
 * 101111
 * 101010
 * 101011
 * 111011
 *
 * [ 예제 입력 ]                [ 예제 출력 ]
 * 4 6                              9
 * 110110
 * 110110
 * 111111
 * 111101
 *
 * [ 예제 입력 ]                [ 예제 출력 ]
 * 2 25                             38
 * 1011101110111011101110111
 * 1110111011101110111011101
 *
 * [ 예제 입력 ]                [ 예제 출력 ]
 * 7 7                              13
 * 1011111
 * 1110001
 * 1000001
 * 1000001
 * 1000001
 * 1000001
 * 1111111
 */

package BaekJoon.DfsAndBfs.Q2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2178_MazeSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cnt = br.readLine().split(" ");
        int row = Integer.parseInt(cnt[0]) + 1;
        int col = Integer.parseInt(cnt[1]) + 1;
        int total = (row - 1) * (col - 1);
        Map<Integer, Point> nodeMap = new HashMap<>();

        int pathIdx = 1;

        for(int i = 1; i < row; i++){
            int[] onePath = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

            for(int j = 0; j < onePath.length; j++){
                nodeMap.put(pathIdx++, new Point(onePath[j]));
            }
        }

        Graph graph = new Graph(total + 1);
        graph.linkNode(col - 1, total);
        graph.BFS(nodeMap);
    }
}

class Graph {
    private int nodeCnt;
    private LinkedList<Integer>[] adj;

    Graph(int nodeCnt){
        this.nodeCnt = nodeCnt;
        adj = new LinkedList[nodeCnt];

        for(int idx = 0; idx < this.nodeCnt; idx++){
            adj[idx] = new LinkedList<>();
        }
    }

    void linkNode(int col, int total){
        for(int idx = 1; idx < this.nodeCnt; idx++){
            // 기준으로 부터 '우' 노드가 유요한 노드인지 파악
            if( (idx + 1) % col != 1){
                adj[idx].offer(idx + 1);
            }

            // 기준으로 부터 '좌' 노드가 유요한 노드인지 파악
            if( (idx - 1) % col != 0 &&  idx - 1 != 0){
                adj[idx].offer(idx - 1);
            }

            // 기준으로 부터 '하' 노드가 유요한 노드인지 파악
            if( (idx + col) < (total + 1)){
                adj[idx].offer(idx + col);
            }

            // 기준으로 부터 '상' 노드가 유요한 노드인지 파악
            if( (idx - col) > 0){
                adj[idx].offer(idx - col);
            }
        }
    }

    void BFS(Map<Integer, Point> nodeMap){
        boolean[] visited = new boolean[nodeCnt];
        Queue<Integer> queue = new LinkedList();

        queue.offer(1);
        visited[1] = true;
        nodeMap.get(1).setDistance(1);

        while(!queue.isEmpty()){
            int curNode = queue.poll();
            Point curPoint = nodeMap.get(curNode);

            // 마지막 노드 도착시 종료
            if(curNode == nodeCnt - 1){
                System.out.print(curPoint.getDistance());
                break;
            }

            Iterator<Integer> it = adj[curNode].listIterator();

            while(it.hasNext()){
                int linkedNode = it.next();

                // 방문 했던 노드인지 && 지나갈 수 있는 노드인지 (1: open  2: close)
                if(!visited[linkedNode] && nodeMap.get(linkedNode).getOpen() == 1){
                    queue.offer(linkedNode);
                    // 방문 체크
                    visited[linkedNode] = true;
                    // 다음 노드 거리 1증가
                    nodeMap.get(linkedNode).setDistance(curPoint.getDistance() + 1);
                }
            }
        }
    }
}

class Point{
    private int open;
    private int distance;

    Point(int open){
        this.open = open;
    }

    public int getDistance() {
        return distance;
    }

    public int getOpen() {
        return open;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}