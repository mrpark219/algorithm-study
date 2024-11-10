package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ14852 {

	static long[][] dp = new long[1000001][2];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		dp[0][0] = 0;
		dp[1][0] = 2;
		dp[2][0] = 7;
		dp[2][1] = 1;
		System.out.println(solution(n));
	}

	static long solution(int n) {
		for(int i = 3; i <= n; i++) {
			dp[i][1] = (dp[i - 1][1] + dp[i - 3][0]) % 1000000007;
			dp[i][0] = (3 * dp[i - 2][0] + 2 * dp[i - 1][0] + 2 * dp[i][1]) % 1000000007;
		}

		return dp[n][0];
	}
}
