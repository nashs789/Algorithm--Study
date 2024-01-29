/**
 *  [ 효율성 ]
 *  - 메모리: 53292KB
 *  - 시간 : 664ms
 */
package BaekJoon.SetAndMap.Q7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Q7785_MemberInCompany {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        NavigableSet<String> members = new TreeSet<>();

        for(int idx = 0; idx < cnt; idx++){
            String[] info = br.readLine().split(" ");
            String name = info[0];
            char status = info[1].charAt(0);

            if(status == 'e'){
                members.add(name);
            } else {
                members.remove(name);
            }
        }

        Iterator<String> it = members.descendingIterator();

        while(it.hasNext()){
            sb.append(it.next()).append('\n');
        }

        System.out.println(sb);
    }
}
