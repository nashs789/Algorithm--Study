import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
* HashSet 31120KB, 412ms
*
* LinkedList 30972KB / 3008ms
* */
public class Main {

    static LinkedList<String> linkedList = new LinkedList<>();
    static HashSet<String> hashSet = new HashSet<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        for (int i = 0; i < A; i++) {
            linkedList.add(br.readLine());
        }

       
        int count = 0;

        for(int i = 0; i < B; i++) {

            if(linkedList.contains(br.readLine())){
                count++;
            }
        }

        System.out.println(count);
    }
}
