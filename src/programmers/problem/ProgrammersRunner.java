package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int n = 6;
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = {
			{4, 1, 10},
			{3, 5, 24},
			{5, 6, 2},
			{3, 1, 41},
			{5, 1, 24},
			{4, 6, 50},
			{2, 4, 66},
			{2, 3, 22},
			{1, 6, 25}};

		System.out.println(new P72413.Solution().solution(n, s, a, b, fares));
	}
}
