package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int[] diffs = {1, 5, 3};
		int[] times = {2, 4, 7};
		int limit = 30;

		System.out.println(new P340212.Solution().solution(diffs, times, limit));
	}
}
