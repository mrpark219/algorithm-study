package programmers.problem;

public class P43105 {

	static int solution(int[][] triangle) {

		// dp[a][b]: a: 단계, b: 위치 -> 최대값
		int[][] dp = new int[triangle.length][triangle[triangle.length - 1].length];
		dp[0][0] = triangle[0][0];

		for(int i = 1; i < triangle.length; i++) {

			for(int j = 0; j <= i; j++) {

				if(j == 0) {
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
				}
				else if(j == i) {
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1])
						+ triangle[i][j];
				}
			}
		}

		int max = 0;
		for(int i = 0; i < triangle[triangle.length - 1].length; i++) {
			max = Math.max(max, dp[triangle.length - 1][i]);
		}

		return max;
	}

	public static void main(String[] args) {

		int[][] triangle = {
			{7},
			{3, 8},
			{8, 1, 0},
			{2, 7, 4, 4},
			{4, 5, 2, 6, 5}
		};

		System.out.println(solution(triangle));
	}
}
