package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {

	public static int whiteCount = 0;
	public static int blueCount = 0;
	public static int[][] array;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		array = new int[N + 1][N + 1];

		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solution(1, N, 1, N);

		System.out.println(whiteCount + "\n" + blueCount);
	}

	private static void solution(int xStart, int xEnd, int yStart, int yEnd) {

		boolean check = check(xStart, xEnd, yStart, yEnd);

		if(check) {
			return;
		}

		int xHalf = (xEnd - xStart + 1) / 2 + xStart - 1;
		int yHalf = (yEnd - yStart + 1) / 2 + yStart - 1;

		solution(xStart, xHalf, yStart, yHalf);
		solution(xHalf + 1, xEnd, yStart, yHalf);
		solution(xStart, xHalf, yHalf + 1, yEnd);
		solution(xHalf + 1, xEnd, yHalf + 1, yEnd);
	}

	public static boolean check(int xStart, int xEnd, int yStart, int yEnd) {

		int temp = array[xStart][yStart];

		for(int i = xStart; i <= xEnd; i++) {
			for(int j = yStart; j <= yEnd; j++) {
				if(temp != array[i][j]) {
					return false;
				}
			}
		}

		if(temp == 0) {
			whiteCount++;
		}
		else {
			blueCount++;
		}

		return true;
	}
}
