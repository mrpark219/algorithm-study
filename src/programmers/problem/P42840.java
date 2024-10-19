package programmers.problem;

public class P42840 {

	static class Solution {
		public int[] solution(int[] answers) {

			int[] answer1 = {1, 2, 3, 4, 5};
			int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
			int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

			int count1 = 0;
			int count2 = 0;
			int count3 = 0;

			for(int i = 0; i < answers.length; i++) {

				int answer1Index = i % answer1.length;
				int answer2Index = i % answer2.length;
				int answer3Index = i % answer3.length;

				if(answers[i] == answer1[answer1Index]) {
					count1++;
				}
				if(answers[i] == answer2[answer2Index]) {
					count2++;
				}
				if(answers[i] == answer3[answer3Index]) {
					count3++;
				}
			}

			int max = Math.max(Math.max(count1, count2), count3);

			int[] maxArray = new int[3];
			int maxIndex = 0;

			if(max == count1) {
				maxArray[maxIndex] = 1;
				maxIndex++;
			}
			if(max == count2) {
				maxArray[maxIndex] = 2;
				maxIndex++;
			}
			if(max == count3) {
				maxArray[maxIndex] = 3;
				maxIndex++;
			}

			int[] result = new int[maxIndex];
			for(int i = 0; i < maxIndex; i++) {
				result[i] = maxArray[i];
			}

			return result;
		}
	}
}
