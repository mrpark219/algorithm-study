package programmers.problem;

import java.util.Arrays;

public class P72413 {

	static class Solution {

		public int solution(int n, int s, int a, int b, int[][] fares) {

			final int INF = 100000 * 201;

			int[][] distance = new int[n + 1][n + 1];

			for(int i = 1; i <= n; i++) {
				Arrays.fill(distance[i], INF);
			}

			for(int i = 1; i <= n; i++) {
				distance[i][i] = 0;
			}

			for(int i = 0; i < fares.length; i++) {
				int start = fares[i][0];
				int end = fares[i][1];
				int cost = fares[i][2];

				distance[start][end] = cost;
				distance[end][start] = cost;
			}

			for(int k = 1; k <= n; k++) {
				for(int i = 1; i <= n; i++) {
					for(int j = 1; j <= n; j++) {

						if(distance[i][j] > distance[i][k] + distance[k][j]) {
							distance[i][j] = distance[i][k] + distance[k][j];
						}
					}
				}
			}

			int minCost = distance[s][a] + distance[s][b];

			for(int i = 1; i <= n; i++) {
				minCost = Math.min(minCost, distance[s][i] + distance[i][a] + distance[i][b]);
			}

			return minCost;
		}
	}
}
