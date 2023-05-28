package BaekJoon.SetAndMap.Q4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Q4358_Ecology {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SortedMap<String, Double> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        String str;
        int total = 0;

        while((str = br.readLine()) != null){
            map.put(str, map.getOrDefault(str, 0.0) + 1);

            total++;
        }

        Iterator<String> it = map.keySet().iterator();

        while(it.hasNext()){
            String key = it.next();
            String rate = String.format("%.4f", Math.round( (map.get(key) / total) * 1000000) / 10000.0);

            sb.append(key).append(' ').append(rate).append('\n');
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}