import java.io.*;
import java.util.*;

/**
    백준 - 집합과 맵
    7785 회사에 있는 사람
    
    메모리 : 61872KB
    시간  : 1660ms
 */
public class Q7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<String,String> infoMap = new HashMap();
        for (int i=0; i < N; i++) {
            String[] input = br.readLine().split(" ");
           infoMap.put(input[0],input[1]);
        }

        List<String> list = new ArrayList<>();

        for(Map.Entry<String,String> entryset : infoMap.entrySet()) {
            if(entryset.getValue().equals("enter")){
                list.add(entryset.getKey());
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        for(String name : list) {
            bw.write(name + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
