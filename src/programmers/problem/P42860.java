package programmers.problem;

public class P42860 {

	static class Solution {
		public int solution(String name) {

			int count = 0;
			int minMove = name.length() - 1;

			for(int i = 0; i < name.length(); i++) {

				char target = name.charAt(i);
				count += Math.min(target - 'A', 'Z' - target + 1);

				int nextIndex = i + 1;
				while(nextIndex < name.length() && name.charAt(nextIndex) == 'A') {
					nextIndex++;
				}

				int move = Math.min(i, name.length() - nextIndex) + i + name.length() - nextIndex;
				minMove = Math.min(minMove, move);
			}

			return count + minMove;
		}
	}
}
