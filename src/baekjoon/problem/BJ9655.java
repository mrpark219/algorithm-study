package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9655 {

	public static boolean[] dp = new boolean[1000 + 1];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		System.out.println(solution(N));
	}

	public static String solution(int N) {

		dp[1] = true;
		dp[2] = false;
		dp[3] = true;

		for(int i = 4; i <= N; i++) {
			dp[i] = !dp[i - 1];
		}

		return dp[N] ? "SK" : "CY";
	}
}
