package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int[][] routes = new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};

		System.out.println(new P42884.Solution().solution(routes));
	}
}
