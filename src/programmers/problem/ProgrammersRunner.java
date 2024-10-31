package programmers.problem;

import java.util.Arrays;

public class ProgrammersRunner {

	public static void main(String[] args) {

		String[] expressions = {"14 + 3 = 17", "13 - 6 = X", "51 - 5 = 44"};

		System.out.println(Arrays.toString(new P340210.Solution().solution(expressions)));
	}
}
