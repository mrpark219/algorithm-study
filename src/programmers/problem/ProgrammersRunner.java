package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int[] scoville = new int[]{7,4,5,6};
		int K = 7;

		System.out.println(new P42626.Solution().solution(scoville, K));
	}
}
