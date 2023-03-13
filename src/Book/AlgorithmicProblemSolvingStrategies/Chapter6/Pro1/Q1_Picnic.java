package Book.AlgorithmicProblemSolvingStrategies.Chapter6.Pro1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1_Picnic {

    private static int C = 0;
    private static int n = 0;
    private static int m = 0;
    private static int cnt = 0;
    private static Set<String> totalPair = new HashSet<>();
    private static LinkedList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        for(int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            adj = new LinkedList[n];

            for(int j = 0; j < n; j++){
                adj[j] = new LinkedList<>();
            }

            for(int j = 0; j < m; j++){
                int student1 = Integer.parseInt(st.nextToken());
                int student2 = Integer.parseInt(st.nextToken());

                adj[student1].add(student2);
                adj[student2].add(student1);
            }

            getCount(0, new boolean[n], new HashSet<>(), "");
            System.out.println(cnt);
            cnt = 0;
        }
    }

    private static void getCount(int idx, boolean[] pairs, HashSet<String> pairSet, String key) {
        for(int i = idx; i < pairs.length; i++){
            if(pairs[i]){
                continue;
            }

            Iterator<Integer> it = adj[i].listIterator();

            while(it.hasNext()){
                int friend = it.next();

                if(pairs[friend]){
                    continue;
                }

                key = i > friend ? friend + " " + i : i + " " + friend;
                boolean[] copy = Arrays.copyOf(pairs, pairs.length);
                copy[i] = true;
                copy[friend] = true;
                pairSet.add(key);

                if(isAllPairs(copy)){
                    String newKey = "";
                    List<String> list = new ArrayList<>(pairSet);
                    Collections.sort(list, new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            return Integer.parseInt(o1.substring(0, 1)) - Integer.parseInt(o2.substring(0, 1));
                        }
                    });

                    for(String a : list){
                        newKey += a + " ";
                    }

                    if(!totalPair.contains(newKey) && pairSet.size() == n / 2){
                        totalPair.add(newKey);
                        cnt++;
                    }

                    return;
                }

                getCount(i + 1, copy, new HashSet<>(pairSet), key);

                if(it.hasNext()){
                    pairSet.remove(key);
                } else {
                    pairSet.clear();
                }
            }
        }
    }

    private static boolean isAllPairs(boolean[] pairs) {
        for(int idx = 0; idx < pairs.length; idx++){
            if(!pairs[idx]){
                return false;
            }
        }
        return true;
    }
}
