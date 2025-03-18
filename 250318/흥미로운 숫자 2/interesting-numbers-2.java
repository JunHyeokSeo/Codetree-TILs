import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		int cnt = 0;
		for (int i = x; i <= y; i++) {
			String str = String.valueOf(i);
			Map<Character, Integer> map = new HashMap<>();

			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				map.merge(c, 1, Integer::sum);
			}

			if (map.size() == 2 && map.values().stream().anyMatch(v -> v == 1))
				cnt++;
		}
		
		System.out.println(cnt);
	}
}