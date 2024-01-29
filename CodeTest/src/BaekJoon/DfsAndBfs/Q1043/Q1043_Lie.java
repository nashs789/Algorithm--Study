package BaekJoon.DfsAndBfs.Q1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1043_Lie {

    public static int N;
    public static int M;
    public static boolean[] notTricked;
    public static Set<Integer>[] party;
    public static LinkedList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new LinkedList[N + 1];
        notTricked = new boolean[N + 1];
        party = new HashSet[M];

        st = new StringTokenizer(br.readLine());
        int knowTrueCnt = Integer.parseInt(st.nextToken());

        for (int idx = 0; idx < knowTrueCnt; idx++) {
            notTricked[Integer.parseInt(st.nextToken())] = true;
        }

        for (int idx = 0; idx < adj.length; idx++) {
            adj[idx] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            party[i] = new HashSet();

            for (int j = 1; j < inp.length; j++) {
                party[i].add(inp[j]);
            }

            for (int j = 1; j <= inp[0] - 1; j++) {
                for (int k = j + 1; k <= inp[0]; k++) {
                    adj[inp[j]].add(inp[k]);
                    adj[inp[k]].add(inp[j]);
                }
            }
        }

        bfs();

        int cnt = party.length;

        for (int i = 0; i < party.length; i++) {
            for (int j = 1; j < notTricked.length; j++) {
                // 진실을 아는 사람 && 그 사람이 파티에 존재
                if (notTricked[j] && party[i].contains(j)) {
                    cnt--;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void bfs() {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int idx = 1; idx <= N; idx++) {
            if (visited[idx]) {
                continue;
            }

            queue.add(idx);
            visited[idx] = true;
            boolean tricked = true;
            Set<Integer> newTricked = new HashSet<>();

            while (!queue.isEmpty()) {
                int curNode = queue.poll();
                newTricked.add(curNode);

                // 진실을 아는 사람이 존재하는 경우
                if (notTricked[curNode]) {
                    tricked = false;
                }

                Iterator<Integer> it = adj[curNode].iterator();

                while (it.hasNext()) {
                    int linkedNode = it.next();

                    if (!visited[linkedNode]) {
                        visited[linkedNode] = true;
                        queue.add(linkedNode);
                    }
                }
            }

            // 진실을 아는 사람이 한 사람이라도 존재하여 해당 파티의 모든 사람이 진실을 알게된다.
            if (!tricked) {
                for (int n : newTricked) {
                    notTricked[n] = true;
                }
            }
        }
    }
}