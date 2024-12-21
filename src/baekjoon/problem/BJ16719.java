package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16719 {

	public static boolean[] visited;
	public static String input;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		input = br.readLine();
		visited = new boolean[input.length()];

		solution(0, input.length() - 1, sb);

		System.out.println(sb);
	}

	public static void solution(int start, int end, StringBuilder sb) {

		if(start > end) {
			return;
		}

		int minIndex = start;
		for(int i = start; i <= end; i++) {
			if(input.charAt(minIndex) > input.charAt(i)) {
				minIndex = i;
			}
		}

		visited[minIndex] = true;

		for(int i = 0; i < input.length(); i++) {
			if(visited[i]) {
				sb.append(input.charAt(i));
			}
		}
		sb.append("\n");

		solution(minIndex + 1, end, sb);
		solution(start, minIndex - 1, sb);
	}
}
