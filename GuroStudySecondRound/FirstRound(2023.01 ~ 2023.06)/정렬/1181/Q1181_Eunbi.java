import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        String[] arr = new String[input];

        for(int i=0; i<arr.length; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });
        Arrays.stream(arr)
                .distinct()
                .forEach(word -> System.out.println(word));
    }
}
