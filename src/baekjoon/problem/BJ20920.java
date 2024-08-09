package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ20920 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> wordMap = new HashMap<>();

		for(int i = 1; i <= N; i++) {
			String word = br.readLine();

			if(word.length() >= M) {
				wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
			}
		}

		List<String> wordList = new ArrayList<>(wordMap.keySet());

		wordList.sort((o1, o2) -> {
			if(wordMap.get(o1) - wordMap.get(o2) != 0) {
				return wordMap.get(o2) - wordMap.get(o1);
			}

			if(o1.length() != o2.length()) {
				return o2.length() - o1.length();
			}

			return o1.compareTo(o2);
		});

		wordList.forEach(s -> {
			sb.append(s).append("\n");
		});

		System.out.println(sb);
	}
}
