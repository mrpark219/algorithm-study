package programmers.problem;

public class P87946 {

	static class Solution {

		int[] visited;
		int maxCount = -1;

		public int solution(int k, int[][] dungeons) {

			int length = dungeons.length;
			visited = new int[length];
			for(int i = 0; i < length; i++) {
				visited[i] = 0;
			}

			tired(0, length, k, dungeons);

			return maxCount;
		}

		public void tired(int count, int length, int k, int[][] dungeons) {

			for(int i = 0; i < length; i++) {
				if(visited[i] == 0 && k >= dungeons[i][0]) {
					maxCount = Math.max(maxCount, count + 1);
					visited[i] = 1;
					tired(count + 1, length, k - dungeons[i][1], dungeons);
					visited[i] = 0;
				}
			}
		}
	}
}
