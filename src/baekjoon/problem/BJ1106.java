package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1106 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] costArray = new int[N];
		int[] clientArray = new int[N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int cost = Integer.parseInt(st.nextToken());
			int client = Integer.parseInt(st.nextToken());

			costArray[i] = cost;
			clientArray[i] = client;
		}

		// j 고객 수를 유치하기 위한 최소 비용
		int[] dp = new int[C + 101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for(int i = 0; i < N; i++) {
			int cost = costArray[i];
			int client = clientArray[i];

			for(int j = client; j < dp.length; j++) {
				if(dp[j - client] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - client] + cost);
				}
			}
		}

		int result = Integer.MAX_VALUE;
		for(int i = C; i < dp.length; i++) {
			result = Math.min(result, dp[i]);
		}

		System.out.println(result);
	}
}
