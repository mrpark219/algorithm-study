package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2133 {

	public static Integer[] dp = new Integer[31];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 3;
		int n = Integer.parseInt(br.readLine());

		System.out.println(solution(n));
	}

	public static int solution(int n) {

		if(dp[n] == null) {
			int result = solution(n - 2) * 3;
			for(int i = 4; i <= n; i += 2) {
				result += 2 * solution(n - i);
			}
			dp[n] = result;
		}

		return dp[n];
	}
}
