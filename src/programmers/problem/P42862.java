package programmers.problem;

public class P42862 {

	static class Solution {
		public int solution(int n, int[] lost, int[] reserve) {

			int[] students = new int[n];

			for(int i = 0; i < n; i++) {
				students[i]++;
			}

			for(int i : lost) {
				students[i - 1]--;
			}

			for(int i : reserve) {
				students[i - 1]++;
			}

			for(int i = 0; i < n; i++) {
				if(i - 1 >= 0 && students[i - 1] == 0 && students[i] >= 2) {
					students[i - 1]++;
					students[i]--;
				}

				if(i + 1 < n && students[i + 1] == 0 && students[i] >= 2) {
					students[i + 1]++;
					students[i]--;
				}
			}

			int count = 0;
			for(int i : students) {
				if(i >= 1) {
					count++;
				}
			}

			return count;
		}
	}
}
