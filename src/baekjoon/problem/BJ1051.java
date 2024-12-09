package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1051 {

	public static int N;
	public static int M;
	public static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for(int i = 0; i < N; i++) {

			String input = br.readLine();

			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		int length = Math.min(N, M);

		while(length > 1) {
			for(int i = 0; i <= N - length; i++) {
				for(int j = 0; j <= M - length; j++) {

					int number = map[i][j];

					if(number == map[i][j + length - 1] && number == map[i + length - 1][j] && number == map[i + length - 1][j + length - 1]) {
						System.out.println(length * length);
						return;
					}
				}
			}

			length--;
		}

		System.out.println(length * length);
	}
}
