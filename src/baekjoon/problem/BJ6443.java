package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class BJ6443 {

	public static int[] alphabet;
	public static String word;
	public static int wordLength;
	public static Set<String> anagramSet = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			word = br.readLine();
			wordLength = word.length();

			alphabet = new int[26];

			for(int j = 0; j < wordLength; j++) {
				alphabet[word.charAt(j) - 'a']++;
			}

			solution(0, new StringBuffer());
		}

		anagramSet.forEach(s -> sb.append(s).append("\n"));

		System.out.println(sb);
	}

	public static void solution(int index, StringBuffer word) {

		if(index == wordLength) {
			anagramSet.add(word.toString());
			return;
		}

		for(int i = 0; i < 26; i++) {
			if(alphabet[i] != 0) {
				alphabet[i]--;
				solution(index + 1, word.append((char) (i + 'a')));
				word.deleteCharAt(word.length() - 1);
				alphabet[i]++;
			}
		}
	}
}
