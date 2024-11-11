package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ23048 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] colors = new int[N + 1];
		int color = 1;

		colors[1] = 1;
		for(int i = 2; i <= N; i++) {
			if(colors[i] == 0) {
				color++;
				for(int j = i; j <= N; j += i) {
					colors[j] = color;
				}
			}
		}

		sb.append(color).append("\n");

		for(int i = 1; i <= N; i++) {
			sb.append(colors[i]).append(" ");
		}

		System.out.println(sb);
	}
}
