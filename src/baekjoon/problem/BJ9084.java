package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9084 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {

			int N = Integer.parseInt(br.readLine());

			int[] coinArray = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				coinArray[i] = Integer.parseInt(st.nextToken());
			}

			int target = Integer.parseInt(br.readLine());

			// 개수를 나타내는 DP
			int[] dp = new int[target + 1];
			dp[0] = 1;

			for(int coin : coinArray) {
				for(int i = coin; i <= target; i++) {
					dp[i] += dp[i - coin];
				}
			}

			sb.append(dp[target]).append("\n");
		}

		System.out.println(sb);
	}
}
