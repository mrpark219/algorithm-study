package programmers.problem;

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
	}

}
