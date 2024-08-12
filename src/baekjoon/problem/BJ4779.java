package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4779 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input;
		while((input = br.readLine()) != null) {

			int N = Integer.parseInt(input);

			StringBuffer sb = new StringBuffer();
			for(int i = 1; i <= Math.pow(3, N); i++) {
				sb.append("-");
			}
			solution(sb, 1, (int) Math.pow(3, N));

			System.out.println(sb);
		}
	}

	public static void solution(StringBuffer N, int start, int end) {

		if(start == end) {
			return;
		}

		int range = (end - start + 1) / 3;

		solution(N, start, start + range - 1);

		for(int i = start + range; i <= start + range * 2 - 1; i++) {
			N.setCharAt(i - 1, ' ');
		}

		solution(N, start + range * 2, start + range * 3 - 1);
	}

}
