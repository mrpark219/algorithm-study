package programmers.problem;

import java.util.Arrays;

public class P42861 {

	static class Solution {

		int[] bridge;

		public int solution(int n, int[][] costs) {
			int costCount = 0;

			bridge = new int[n];
			for(int i = 0; i < n; i++) {
				bridge[i] = i;
			}

			Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

			for(int i = 0; i < costs.length; i++) {
				int start = costs[i][0];
				int end = costs[i][1];

				if(find(start) != find(end)) {
					union(start, end);
					costCount += costs[i][2];
				}
			}

			return costCount;
		}

		public int find(int n) {
			if(bridge[n] == n) {
				return n;
			}
			else {
				return bridge[n] = find(bridge[n]);
			}
		}

		public void union(int a, int b) {
			a = find(a);
			b = find(b);

			if(a != b) {
				bridge[a] = b;
			}
		}
	}
}
