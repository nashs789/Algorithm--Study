import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Map<String, String> passwordMap = new HashMap<>();
        
        for(int i=0; i< M; i++) {
            String[] input = br.readLine().split(" ");
            passwordMap.put(input[0],input[1]);
        }

        for(int i=0; i<N; i++) {
            bw.write(passwordMap.get(br.readLine()) +"\n");
        }
        bw.flush();
        bw.close();

    }
}
