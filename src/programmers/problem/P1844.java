package programmers.problem;

import java.util.LinkedList;
import java.util.Queue;

public class P1844 {

	static class Solution {

		public int solution(int[][] maps) {
			int n = maps.length;
			int m = maps[0].length;

			int[] xMove = {-1, 1, 0, 0};
			int[] yMove = {0, 0, -1, 1};

			boolean[][] visited = new boolean[n][m];
			visited[0][0] = true;

			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[]{0, 0, 1});

			while(!queue.isEmpty()) {
				int[] current = queue.poll();
				int y = current[0];
				int x = current[1];
				int count = current[2];

				if(y == n - 1 && x == m - 1) {
					return count;
				}

				for(int i = 0; i < 4; i++) {
					int ny = y + yMove[i];
					int nx = x + xMove[i];

					if(ny >= 0 && ny < n && nx >= 0 && nx < m && maps[ny][nx] == 1 && !visited[ny][nx]) {
						visited[ny][nx] = true;
						queue.add(new int[]{ny, nx, count + 1});
					}
				}
			}

			return -1;
		}
	}

}
