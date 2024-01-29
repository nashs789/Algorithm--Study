// 121976KB, 1272ms

package backjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder stringBuilder = new StringBuilder();

		int pokemons = sc.nextInt();
		int qustions = sc.nextInt();

		Map<String, Integer> mapBook = new HashMap<String, Integer>();
		List<String> listBook = new ArrayList<String>();

		for (int i=0; i<pokemons; i++) {
			String pokemon = sc.next();
			mapBook.put(pokemon, i+1);
			
			listBook.add(pokemon);
		}
		
		for (int i = 0; i<qustions; i++) {
			String qustion = sc.next();
			if (mapBook.containsKey(qustion)) {
				stringBuilder.append(mapBook.get(qustion)+"\n");
			} else {
				stringBuilder.append(listBook.get(Integer.parseInt(qustion)-1)+"\n");
			}
		}
		
		System.out.print(stringBuilder);
	}
}
