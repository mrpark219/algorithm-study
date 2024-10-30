package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
		int[][] routes = {{4, 2}, {1, 3}, {2, 4}};

		System.out.println(new P340211.Solution().solution(points, routes));
	}
}
