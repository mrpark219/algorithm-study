package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9095 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(br.readLine());
		int[] inputArray = new int[T];
		int max = Integer.MIN_VALUE;

		for(int i = 0; i < T; i++) {
			int input = Integer.parseInt(br.readLine());
			inputArray[i] = input;
			max = Math.max(max, input);
		}

		int[] dp = new int[max + 1];
		dp[0] = 1;
		for(int i = 1; i <= max; i++) {
			for(int j = 1; j <= 3; j++) {
				if(i >= j) {
					dp[i] = dp[i] + dp[i - j];
				}
			}
		}

		for(int i = 0; i < T; i++) {
			sb.append(dp[inputArray[i]]).append("\n");
		}

		System.out.println(sb);
	}
}
