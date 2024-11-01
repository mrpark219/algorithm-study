package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int k = 3;
		int n = 5;
		int[][] reqs = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}};

		System.out.println(new P214288.Solution().solution(k, n, reqs));
	}
}
