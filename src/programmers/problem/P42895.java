package programmers.problem;

public class P42895 {

	static class Solution {

		public int answer = 9;
		public int result;
		public int n;

		public int solution(int N, int number) {

			result = number;
			n = N;

			dfs(0, 0);

			if(answer > 8) {
				return -1;
			}

			return answer;
		}

		public void dfs(int count, int number) {

			if(count > 8) {
				return;
			}

			if(result == number) {
				answer = Math.min(count, answer);
				return;
			}

			int temp = 0;
			for(int i = 0; i < 8 - count; i++) {
				temp = temp * 10 + n;
				dfs(count + 1 + i, number + temp);
				dfs(count + 1 + i, number - temp);
				dfs(count + 1 + i, number * temp);
				dfs(count + 1 + i, number / temp);
			}
		}
	}
}

