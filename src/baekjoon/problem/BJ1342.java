package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1342 {

	public static int[] alphabet = new int[27];
	public static int count;
	public static int length;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		length = S.length();

		for(int i = 0; i < length; i++) {
			alphabet[S.charAt(i) - 'a']++;
		}

		solution(' ', 0);

		System.out.println(count);
	}

	public static void solution(char previous, int index) {

		if(index == length) {
			count++;
			return;
		}

		for(int i = 0; i < 27; i++) {
			if(alphabet[i] == 0) {
				continue;
			}

			char now = (char) (i + 'a');
			if(now != previous) {
				alphabet[i]--;
				solution(now, index + 1);
				alphabet[i]++;
			}
		}
	}
}
