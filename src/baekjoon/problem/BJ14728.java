package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14728 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[] timeArray = new int[N];
		int[] pointArray = new int[N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int K = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			timeArray[i] = K;
			pointArray[i] = S;
		}

		int[] dp = new int[T + 1];

		for(int i = 0; i < N; i++) {

			int time = timeArray[i];
			int point = pointArray[i];

			for(int j = T; j >= time; j--) {
				dp[j] = Math.max(dp[j], dp[j - time] + point);
			}
		}

		System.out.println(dp[T]);
	}
}
