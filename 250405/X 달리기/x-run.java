import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();

		int dist = 0;
		int speed = 0;
		int time = 0;
		while (dist < x) {
			int a = (speed * (speed + 1)) / 2;

			if (dist + (speed + 1) + a <= x)
				speed++;
			else if (dist + speed + a <= x)
				speed += 0;
			else if (speed > 1)
				speed--;

			dist += speed;
			time++;
		}

		System.out.println(time);
	}
}