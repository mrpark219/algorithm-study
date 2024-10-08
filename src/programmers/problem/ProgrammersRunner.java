package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int[] numbers = new int[]{1, 1, 1, 1, 1};
		int target = 3;

		System.out.println(new P43165.Solution().solution(numbers, target));
	}
}
