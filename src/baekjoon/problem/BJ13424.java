package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ13424 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		final int INF = 1000 * 100 * 100;
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] connectionInfo = new int[N + 1][N + 1];
			for(int i = 1; i < N + 1; i++) {
				Arrays.fill(connectionInfo[i], INF);
				connectionInfo[i][i] = 0;
			}

			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				connectionInfo[a][b] = c;
				connectionInfo[b][a] = c;
			}

			for(int k = 1; k <= N; k++) {
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						connectionInfo[i][j] = Math.min(
							connectionInfo[i][j],
							connectionInfo[i][k] + connectionInfo[k][j]);
					}
				}
			}

			int K = Integer.parseInt(br.readLine());
			int[] studentArray = new int[K];

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < K; i++) {
				studentArray[i] = Integer.parseInt(st.nextToken());
			}

			int minCount = Integer.MAX_VALUE;
			int index = 0;
			for(int i = 1; i <= N; i++) {

				int count = 0;
				for(int student : studentArray) {
					count += connectionInfo[student][i];
				}

				if(count < minCount) {
					index = i;
					minCount = count;
				}
			}

			sb.append(index).append("\n");
		}

		System.out.println(sb);
	}
}
