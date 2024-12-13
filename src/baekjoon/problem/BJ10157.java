package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10157 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());

		if(K > C * R) {
			System.out.println(0);
			return;
		}

		int[] moveX = {-1, 0, 1, 0};
		int[] moveY = {0, 1, 0, -1};

		boolean[][] visited = new boolean[R][C];

		int x = R - 1;
		int y = 0;
		int direction = 0;

		for(int i = 0; i < K - 1; i++) {

			visited[x][y] = true;
			int nextX = x + moveX[direction];
			int nextY = y + moveY[direction];

			if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C || visited[nextX][nextY]) {
				direction = (direction + 1) % 4;
				nextX = x + moveX[direction];
				nextY = y + moveY[direction];
			}

			x = nextX;
			y = nextY;
		}

		System.out.println((y + 1) + " " + (R - x));
	}
}