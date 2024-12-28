package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1213 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		int[] alphabetArray = new int[26];

		for (int i = 0; i < input.length(); i++) {
			alphabetArray[input.charAt(i) - 'A']++;
		}

		int oddCount = 0;
		String oddChar = "";
		StringBuilder front = new StringBuilder();

		for (int i = 0; i < 26; i++) {
			if (alphabetArray[i] % 2 != 0) {
				oddCount++;
				oddChar = String.valueOf((char) (i + 'A'));
			}

			if (oddCount > 1) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}

			for (int j = 0; j < alphabetArray[i] / 2; j++) {
				front.append((char) (i + 'A'));
			}
		}

		sb.append(front).append(oddChar).append(front.reverse());
		System.out.println(sb);
	}
}
