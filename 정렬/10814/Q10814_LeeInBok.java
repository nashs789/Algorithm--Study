/**
 *  [ 효율성 ]
 *  - 메모리: 45816KB
 *  - 시간 : 576ms
 */
package BaekJoon.Sorting.Q10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q10814_OrderingByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        User[] users = new User[cnt];

        for(int idx = 0; idx < cnt; idx++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            users[idx] = new User(age, name, idx);
        }

        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if(o1.age == o2.age){
                    return o1.seq - o2.seq;
                }

                return o1.age - o2.age;
            }
        });

        for(User u : users){
            sb.append(u.age).append(' ').append(u.name).append('\n');
        }

        System.out.println(sb);
    }
}

class User{
    int age;
    String name;
    int seq;

    public User(int age, String name, int seq) {
        this.age = age;
        this.name = name;
        this.seq = seq;
    }
}