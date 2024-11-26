package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1446 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[][] input = new int[N][3];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[D + 1];
		for(int i = 0; i <= D; i++) {
			dp[i] = i;
		}

		for(int i = 1; i <= D; i++) {
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);

			for(int j = 0; j < N; j++) {
				if(input[j][1] == i) {
					dp[i] = Math.min(dp[i], dp[input[j][0]] + input[j][2]);
				}
			}
		}

		System.out.println(dp[D]);
	}
}
