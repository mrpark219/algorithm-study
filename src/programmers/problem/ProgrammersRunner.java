package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

		System.out.println(new P1844.Solution().solution(maps));
	}
}
