package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11727 {

	static Integer[] dp = new Integer[1001];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		dp[1] = 1;
		dp[2] = 3;

		System.out.println(solution(n));
	}

	public static int solution(int n) {

		if(dp[n] == null) {
			dp[n] = (solution(n - 1) + solution(n - 2) * 2) % 10007;
		}

		return dp[n];
	}
}
