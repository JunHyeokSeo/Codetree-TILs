import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static int n;
	public static int m;
	public static int minLineCnt = Integer.MAX_VALUE;
	public static List<Line> lines;
	public static List<Line> activeLines;
	public static String fullLineSimulationResult;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		lines = new ArrayList<>();
		activeLines = new ArrayList<>();

		for(int i = 0; i < m; i++){
			int left = sc.nextInt();
			int right = left + 1;
			int row = sc.nextInt();

			lines.add(new Line(left, right, row));
		}

		fullLineSimulationResult = simulation(lines);
		backTracking(0);
		System.out.println(minLineCnt);
	}

	public static String simulation(List<Line> linesForSimulation) {
		if (linesForSimulation.isEmpty()) {
			return Arrays.toString(IntStream.rangeClosed(1, n).toArray());
		}

		int[] people = new int[n];
		linesForSimulation.sort(Comparator.comparingInt(line -> line.row));
		int maxRow = linesForSimulation.get(linesForSimulation.size() - 1).row;

		for (int i = 1; i <= n; i++) {
			int col = i;

			for (int row = 0; row <= maxRow; row++) {
				for (Line line : linesForSimulation) {
					if (line.row != row)
						continue;

					if (line.left == col) {
						col++;
						break;
					} else if (line.right == col) {
						col--;
						break;
					}
				}
			}

			people[col - 1] = i;
		}

		return Arrays.toString(people);
	}

	public static void backTracking(int index) {
		if (index == m) {
			//이미 사용한 라인 개수가 minLineCnt 보다 같거나 많다면 넘어감
			if (activeLines.size() >= minLineCnt)
				return;

			//해당 조합 가지고 시뮬레이션
			String simulationResult = simulation(activeLines);
			if (fullLineSimulationResult.equals(simulationResult)) {
				minLineCnt = activeLines.size();
			}

			return;
		}

		//해당 라인 추가하여 조합 생성
		activeLines.add(lines.get(index));
		backTracking(index + 1);
		activeLines.remove(lines.get(index));

		//해당 라인 제외하고 조합 생성
		backTracking(index + 1);
	}

	public static class Line {
		public int left;
		public int right;
		public int row;

		public Line(int left, int right, int row) {
			this.left = left;
			this.right = right;
			this.row = row;
		}
	}
}