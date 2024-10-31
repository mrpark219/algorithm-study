package programmers.problem;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P340210 {

	static class Solution {

		final String PLUS = "+";
		final String MINUS = "-";

		public String[] solution(String[] expressions) {

			boolean[] baseArray = new boolean[10];
			String[][] expressionArray = new String[expressions.length][4];
			String[] answerArray;
			int answerCount = 0;
			int maxNumber = 1;

			// 분해 및 진수 범위 지정
			for(int i = 0; i < expressions.length; i++) {
				StringTokenizer st = new StringTokenizer(expressions[i], " ");

				String first = st.nextToken();
				String operator = st.nextToken();
				String second = st.nextToken();
				st.nextToken();
				String result = st.nextToken();

				expressionArray[i][0] = first;
				expressionArray[i][1] = operator;
				expressionArray[i][2] = second;
				expressionArray[i][3] = result;

				maxNumber = Math.max(maxNumber, Math.max(maxNumber(Integer.parseInt(first)), maxNumber(Integer.parseInt(second))));
			}

			// 가능한 진법 범위 지정
			for(int i = 2; i <= 9; i++) {
				if(maxNumber < i) {
					baseArray[i] = true;
				}
				else {
					baseArray[i] = false;
				}
			}

			// 가능한 진법 확인
			for(int i = 0; i < expressionArray.length; i++) {
				if(expressionArray[i][3].equals("X")) {
					answerCount++;
					continue;
				}

				int first = Integer.parseInt(expressionArray[i][0]);
				int second = Integer.parseInt(expressionArray[i][2]);
				String operator = expressionArray[i][1];
				int result = Integer.parseInt(expressionArray[i][3]);

				for(int j = 2; j <= 9; j++) {
					if(baseArray[j]) {
						if(operator.equals(PLUS)) {
							if(result != conver10To(convertTo10(first, j) + convertTo10(second, j), j)) {
								baseArray[j] = false;
							}
						}
						else if(operator.equals(MINUS)) {
							if(result != conver10To(convertTo10(first, j) - convertTo10(second, j), j)) {
								baseArray[j] = false;
							}
						}
					}
				}
			}

			// X 계산
			answerArray = new String[answerCount];
			int answerIndex = 0;
			for(int i = 0; i < expressionArray.length; i++) {
				if(!expressionArray[i][3].equals("X")) {
					continue;
				}

				int first = Integer.parseInt(expressionArray[i][0]);
				int second = Integer.parseInt(expressionArray[i][2]);
				String operator = expressionArray[i][1];

				Set<Integer> possibleSet = new HashSet<>();
				int answerBase = 1;
				for(int j = 2; j <= 9; j++) {
					if(baseArray[j]) {
						answerBase = j;

						if(operator.equals(PLUS)) {
							possibleSet.add(conver10To(convertTo10(first, j) + convertTo10(second, j), j));
						}
						else if(operator.equals(MINUS)) {
							possibleSet.add(conver10To(convertTo10(first, j) - convertTo10(second, j), j));
						}
					}
				}

				if(possibleSet.size() == 1) {
					int result = 0;
					for(int n : possibleSet) {
						result = n;
					}

					answerArray[answerIndex] = String.format("%d %s %d = %d", first, operator, second, result);
				}
				else {
					answerArray[answerIndex] = String.format("%d %s %d = %s", first, operator, second, "?");
				}
				answerIndex++;
			}

			return answerArray;
		}

		public int convertTo10(int number, int base) {
			int count = 0;
			int baseCount = 0;
			while(number != 0) {
				count += (number % 10) * Math.pow(base, baseCount);
				number /= 10;
				baseCount++;
			}
			return count;
		}

		public int conver10To(int number, int base) {
			int count = 0;
			int baseCount = 0;
			while(number != 0) {
				count += number % base * Math.pow(10, baseCount);
				number = number / base;
				baseCount++;
			}
			return count;
		}

		public int maxNumber(int number) {
			int maxNumber = 1;
			while(number != 0) {
				maxNumber = Math.max(maxNumber, number % 10);
				number = number / 10;
			}

			return maxNumber;
		}
	}
}
