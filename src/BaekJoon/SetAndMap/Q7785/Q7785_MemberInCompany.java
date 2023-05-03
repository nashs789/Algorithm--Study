package BaekJoon.SetAndMap.Q7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Q7785_MemberInCompany {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        TreeSet<String> members = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

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

        for(String name : members){
            sb.append(name).append('\n');
        }

        System.out.println(sb);
    }
}
