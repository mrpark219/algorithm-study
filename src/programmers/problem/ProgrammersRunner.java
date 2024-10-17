package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};

		System.out.println(new P42576.Solution().solution(participant, completion));
	}
}
