package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ25192 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Set<String> chatUser = new HashSet<>();
		int count = 0;

		for(int i = 1; i <= N; i++) {

			String input = br.readLine();

			if(input.equals("ENTER")) {
				count += chatUser.size();
				chatUser.clear();
			}
			else {
				chatUser.add(input);
			}
		}

		count += chatUser.size();

		System.out.println(count);
	}
}
