package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int[][] sizes = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};

		System.out.println(new P86491.Solution().solution(sizes));
	}
}
