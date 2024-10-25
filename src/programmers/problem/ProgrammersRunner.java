package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int k = 80;
		int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

		System.out.println(new P87946.Solution().solution(k, dungeons));
	}
}
