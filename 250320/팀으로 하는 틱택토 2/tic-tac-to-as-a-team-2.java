import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp1 = sc.next();
		String inp2 = sc.next();
		String inp3 = sc.next();

		int cnt = 0;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (i == j)
					continue;

				final int num1 = i;
				final int num2 = j;

				String tmp1 = inp1.charAt(0) + String.valueOf(inp2.charAt(0)) + inp3.charAt(0);
				String tmp2 = inp1.charAt(1) + String.valueOf(inp2.charAt(1)) + inp3.charAt(1);
				String tmp3 = inp1.charAt(2) + String.valueOf(inp2.charAt(2)) + inp3.charAt(2);
				String tmp4 = inp1;
				String tmp5 = inp2;
				String tmp6 = inp3;
				String tmp7 = inp1.charAt(0) + String.valueOf(inp2.charAt(1)) + inp3.charAt(2);
				String tmp8 = inp1.charAt(2) + String.valueOf(inp2.charAt(1)) + inp3.charAt(0);

				boolean success = false;

				if (tmp1.chars().allMatch(c -> c == ('0' + num1) || c == ('0' + num2)) && tmp1.chars().anyMatch(c -> c == ('0' + num1)) && tmp1.chars().anyMatch(c -> c == ('0' + num2))) success = true;
				if (tmp2.chars().allMatch(c -> c == ('0' + num1) || c == ('0' + num2)) && tmp2.chars().anyMatch(c -> c == ('0' + num1)) && tmp2.chars().anyMatch(c -> c == ('0' + num2))) success = true;
				if (tmp3.chars().allMatch(c -> c == ('0' + num1) || c == ('0' + num2)) && tmp3.chars().anyMatch(c -> c == ('0' + num1)) && tmp3.chars().anyMatch(c -> c == ('0' + num2))) success = true;
				if (tmp4.chars().allMatch(c -> c == ('0' + num1) || c == ('0' + num2)) && tmp4.chars().anyMatch(c -> c == ('0' + num1)) && tmp4.chars().anyMatch(c -> c == ('0' + num2))) success = true;
				if (tmp5.chars().allMatch(c -> c == ('0' + num1) || c == ('0' + num2)) && tmp5.chars().anyMatch(c -> c == ('0' + num1)) && tmp5.chars().anyMatch(c -> c == ('0' + num2))) success = true;
				if (tmp6.chars().allMatch(c -> c == ('0' + num1) || c == ('0' + num2)) && tmp6.chars().anyMatch(c -> c == ('0' + num1)) && tmp6.chars().anyMatch(c -> c == ('0' + num2))) success = true;
				if (tmp7.chars().allMatch(c -> c == ('0' + num1) || c == ('0' + num2)) && tmp7.chars().anyMatch(c -> c == ('0' + num1)) && tmp7.chars().anyMatch(c -> c == ('0' + num2))) success = true;
				if (tmp8.chars().allMatch(c -> c == ('0' + num1) || c == ('0' + num2)) && tmp8.chars().anyMatch(c -> c == ('0' + num1)) && tmp8.chars().anyMatch(c -> c == ('0' + num2))) success = true;

				if (success) {
					cnt++;
				}


			}
		}
		System.out.println(cnt / 2);
	}
}