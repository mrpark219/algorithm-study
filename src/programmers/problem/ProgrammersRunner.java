package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int n = 4;
		int[][] costs = new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

		System.out.println(new P42861.Solution().solution(n, costs));
	}
}
