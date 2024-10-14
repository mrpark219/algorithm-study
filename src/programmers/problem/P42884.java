package programmers.problem;

import java.util.Arrays;

public class P42884 {

	static class Solution {
		public int solution(int[][] routes) {

			Arrays.sort(routes, (a, b) -> {
				return a[1] - b[1];
			});

			int location = routes[0][1];
			int count = 1;

			for(int i = 1; i < routes.length; i++) {
				if(routes[i][0] > location) {
					count++;
					location = routes[i][1];
				}
			}

			return count;
		}
	}
}
