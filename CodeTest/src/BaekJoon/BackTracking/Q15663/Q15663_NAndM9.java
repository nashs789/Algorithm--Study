package BaekJoon.BackTracking.Q15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15663_NAndM9 {

    public static int N;
    public static int M;
    public static int[] arr;
    public static int[] seq;
    public static boolean[] visited;
    public static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        visited = new boolean[N];
        seq = new int[M];

        backTracking(0);
        List<String> list = new ArrayList(set);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int[] nums1 = Arrays.stream(o1.split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] nums2 = Arrays.stream(o2.split(" ")).mapToInt(Integer::parseInt).toArray();

                for(int idx = 0; idx < nums1.length; idx++){
                    if(nums1[idx] != nums2[idx]){
                        return nums1[idx] - nums2[idx];
                    }
                }

                // 여기로 넘어오는 케이스는 없음
                return nums1[0] - nums2[0];
            }
        });

        for(String s : list){
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }

    public static void backTracking(int seqIdx) {
        if(seqIdx == M){
            StringBuilder sb = new StringBuilder();
            for(int num : seq){
                sb.append(num + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            set.add(sb.toString());

            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                seq[seqIdx] = arr[i];
                backTracking(seqIdx + 1);
                visited[i] = false;
            }
        }
    }
}