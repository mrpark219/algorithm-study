package programmers.problem;

import java.util.ArrayList;
import java.util.List;

public class P12946 {

	static class Solution {

		List<int[]> answerList = new ArrayList<>();

		public int[][] solution(int n) {

			hanoi(n, 1, 3, 2);

			return answerList.toArray(new int[0][]);
		}

		public void hanoi(int n, int start, int end, int via) {

			if(n == 1) {
				answerList.add(new int[]{start, end});
				return;
			}

			hanoi(n - 1, start, via, end);
			answerList.add(new int[]{start, end});
			hanoi(n - 1, via, end, start);
		}
	}
}
