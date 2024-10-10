package programmers.problem;

public class P86491 {

	static class Solution {
		public int solution(int[][] sizes) {

			int maxSize = 0;
			int minSize = 0;

			for(int i = 0; i < sizes.length; i++) {

				int height = sizes[i][0];
				int width = sizes[i][1];

				maxSize = Math.max(maxSize, height);
				maxSize = Math.max(maxSize, width);

				int tempSize = Math.min(height, width);
				minSize = Math.max(minSize, tempSize);
			}

			return maxSize * minSize;
		}
	}
}
