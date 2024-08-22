package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ25682 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] startWithBlack = new int[N + 1][M + 1];
		int[][] startWithWhite = new int[N + 1][M + 1];

		for(int i = 1; i <= N; i++) {

			String input = br.readLine();

			char startColor;
			if(i % 2 == 0) {
				startColor = 'W';
			}
			else {
				startColor = 'B';
			}
			// 흑, 백, 흑, 백 반복

			int blackSum = 0;
			int whiteSum = 0;
			for(int j = 1; j <= M; j++) {
				char color = input.charAt(j - 1);
				// 홀수번, 짝수번 - 시작과 홀수가 같아야 함
				if(j % 2 == 0) {
					if(startColor == color) {
						blackSum++;
					}
					else {
						whiteSum++;
					}
				}
				else {
					if(startColor == color) {
						whiteSum++;
					}
					else {
						blackSum++;
					}
				}

				startWithBlack[i][j] = blackSum + startWithBlack[i - 1][j];
				startWithWhite[i][j] = whiteSum + startWithWhite[i - 1][j];
			}
		}



		int minCount = Integer.MAX_VALUE;
		for(int i = 1; i <= N - K + 1; i++) {
			for(int j = 1; j <= M - K + 1; j++) {
				int blackCount = startWithBlack[i + K - 1][j + K - 1] - startWithBlack[i + K - 1][j - 1] - startWithBlack[i - 1][j + K - 1] + startWithBlack[i - 1][j - 1];
				int whiteCount = startWithWhite[i + K - 1][j + K - 1] - startWithWhite[i + K - 1][j - 1] - startWithWhite[i - 1][j + K - 1] + startWithWhite[i - 1][j - 1];

				if(blackCount < minCount) {
					minCount = blackCount;
				}
				if(whiteCount < minCount) {
					minCount = whiteCount;
				}
			}
		}
		

		System.out.println(minCount);
	}
}
