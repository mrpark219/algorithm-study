package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};

		System.out.println(new P42862.Solution().solution(n, lost, reserve));
	}
}
