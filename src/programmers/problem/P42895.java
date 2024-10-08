package programmers.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P42895 {

	static class SolutionDFS {

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

	static class SolutionDP {
		public int solution(int N, int number) {

			if(N == number) {
				return 1;
			}

			List<Set<Integer>> setList = new ArrayList<>();

			// 1개만
			Set<Integer> oneSet = new HashSet<>();
			oneSet.add(N);
			setList.add(oneSet);

			for(int i = 2; i <= 8; i++) {
				Set<Integer> tempSet = new HashSet<>();

				// 자기 반복
				tempSet.add(getN(N, i));

				// N개 반복
				for(int j = 1; j < i; j++) {
					Set<Integer> a = setList.get(j - 1);
					Set<Integer> b = setList.get(i - j - 1);

					for(int numA : a) {
						for(int numB : b) {
							tempSet.add(numA + numB);
							tempSet.add(numA - numB);
							tempSet.add(numB - numA);
							tempSet.add(numA * numB);
							if(numB != 0) {
								tempSet.add(numA / numB);
							}
							if(numA != 0) {
								tempSet.add(numB / numA);
							}
						}
					}
				}

				if(tempSet.contains(number)) {
					return i;
				}

				setList.add(tempSet);
			}

			return -1;
		}

		public int getN(int N, int count) {
			int temp = 0;
			for(int i = 0; i < count; i++) {
				temp = temp * 10 + N;
			}
			return temp;
		}
	}
}

