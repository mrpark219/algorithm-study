package programmers.problem;

public class P43165 {

	static class Solution {

		public int count = 0;
		public int[] numberArray;
		public int targetNumber;

		public int solution(int[] numbers, int target) {

			numberArray = numbers;
			targetNumber = target;

			dfs(0, 0);

			return count;
		}

		public void dfs(int index, int current) {

			if(numberArray.length == index) {
				if(current == targetNumber) {
					count++;
				}

				return;
			}

			dfs(index + 1, current + numberArray[index]);
			dfs(index + 1, current - numberArray[index]);
		}
	}
}
