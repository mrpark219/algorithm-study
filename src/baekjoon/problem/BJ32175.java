package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ32175 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] cupArray = new int[N];
		long[] dp = new long[H + 1];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cupArray[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = 1;
		for(int i = 1; i <= H; i++) {
			for(int j = 0; j < N; j++) {
				if(i - cupArray[j] >= 0) {
					dp[i] = (dp[i] + dp[i - cupArray[j]]) % ((long) Math.pow(10, 9) + 7);
				}
			}
		}

		System.out.println(dp[H]);
	}
}
