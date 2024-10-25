package programmers.problem;

import java.util.Stack;

public class P42883 {

	static class Solution {
		public String solution(String number, int k) {
			StringBuilder answer = new StringBuilder();
			int length = number.length() - k;

			int index = 0;
			for(int i = 0; i < length; i++) {
				char maxChar = '0';

				for(int j = index; j <= number.length() - (length - i); j++) {
					if(number.charAt(j) > maxChar) {
						maxChar = number.charAt(j);
						index = j + 1;
					}

					if(maxChar == '9') {
						break;
					}
				}

				answer.append(maxChar);
			}

			return answer.toString();
		}

		public String solutionStack(String number, int k) {

			StringBuilder sb = new StringBuilder();
			Stack<Character> stack = new Stack<>();

			for(int i = 0; i < number.length(); i++) {

				char current = number.charAt(i);

				while(k > 0 && !stack.isEmpty() && stack.peek() < current) {
					stack.pop();
					k--;
				}

				stack.push(current);
			}

			while(k > 0) {
				stack.pop();
				k--;
			}

			for(char c : stack) {
				sb.append(c);
			}

			return sb.toString();
		}
	}
}
