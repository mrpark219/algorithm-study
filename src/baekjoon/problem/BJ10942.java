package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ10942 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(br.readLine());

		int[] inputArray = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			inputArray[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] dp = new boolean[N + 1][N + 1];

		solve(dp, N, inputArray);

		int M = Integer.parseInt(br.readLine());

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			if(dp[S][E]) {
				sb.append("1").append("\n");
			}
			else {
				sb.append("0").append("\n");
			}
		}

		System.out.println(sb);
	}

	public static void solve(boolean[][] dp, int N, int[] inputArray) {

		// 범위가 1
		for(int i = 1; i <= N; i++) {
			dp[i][i] = true;
		}

		// 범위가 2
		for(int i = 1; i <= N - 1; i++) {
			if(inputArray[i] == inputArray[i + 1]) {
				dp[i][i + 1] = true;
			}
		}

		// 범위가 3 이상
		for(int i = 2; i <= N - 1; i++) {
			for(int j = 1; j <= N - i; j++) {
				if(inputArray[j] == inputArray[j + i] && dp[j + 1][j + i - 1]) {
					dp[j][j + i] = true;
				}
			}
		}
	}
}
