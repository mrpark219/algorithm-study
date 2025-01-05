package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class BJ1405 {

	public static int N;
	public static double[] percentArray = new double[4];
	public static boolean[][] visited = new boolean[30][30];
	public static int[] moveX = {1, -1, 0, 0};
	public static int[] moveY = {0, 0, 1, -1};
	public static double result = 0d;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for(int i = 0; i < 4; i++) {
			percentArray[i] = Double.parseDouble(st.nextToken()) / 100;
		}

		dfs(15, 15, 0, 1d);

		System.out.println(new BigDecimal(result));
	}

	public static void dfs(int x, int y, int count, double percent) {

		if(N == count) {
			result += percent;
			return;
		}

		for(int i = 0; i < 4; i++) {
			int positionX = x + moveX[i];
			int positionY = y + moveY[i];

			if(!visited[positionX][positionY]) {
				visited[x][y] = true;
				dfs(positionX, positionY, count + 1, percent * percentArray[i]);
				visited[x][y] = false;
			}
		}
	}
}
