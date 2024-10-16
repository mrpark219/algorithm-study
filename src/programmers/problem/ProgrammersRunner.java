package programmers.problem;

import java.util.Arrays;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

		System.out.println(Arrays.toString(new P42748.Solution().solution(array, commands)));
	}
}
