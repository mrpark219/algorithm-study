package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1010 {

	public static int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(br.readLine());

		for(int i = 1; i <= T; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(solution(M, N)).append("\n");
		}

		System.out.println(sb);
	}

	public static int solution(int n, int r) {

		if(dp[n][r] > 0) {
			return dp[n][r];
		}

		if(n == r || r == 0) {
			return 1;
		}

		dp[n][r] = solution(n - 1, r - 1) + solution(n - 1, r);
		return dp[n][r];
	}
}
