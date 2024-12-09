package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ1251 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		List<String> list = new ArrayList<>();

		for(int i = 1; i < input.length(); i++) {
			for(int j = i + 1; j < input.length(); j++) {
				StringBuilder word1 = new StringBuilder(input.substring(0, i));
				StringBuilder word2 = new StringBuilder(input.substring(i, j));
				StringBuilder word3 = new StringBuilder(input.substring(j));

				list.add(word1.reverse().append(word2.reverse()).append(word3.reverse()).toString());
			}
		}

		Collections.sort(list);

		System.out.println(list.get(0));
	}
}
