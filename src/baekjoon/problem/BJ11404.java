package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11404 {

	public static final int INF = 100 * 100000 * 100;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] distance = new int[n][n];

		for(int i = 0; i < n; i++) {
			Arrays.fill(distance[i], INF);
		}

		for(int i = 0; i < n; i++) {
			distance[i][i] = 0;
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			if(distance[a][b] > c) {
				distance[a][b] = c;
			}
		}

		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(distance[i][j] >= INF) {
					sb.append(0).append(" ");
				}
				else {
					sb.append(distance[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
