package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18808 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] notebook = new int[N][M];
		int[][][] stickerArray = new int[K][][];

		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			int[][] sticker = new int[R][C];

			for(int j = 0; j < R; j++) {
				st = new StringTokenizer(br.readLine());
				for(int z = 0; z < C; z++) {
					sticker[j][z] = Integer.parseInt(st.nextToken());
				}
			}

			stickerArray[i] = sticker;
		}

		for(int i = 0; i < stickerArray.length; i++) {
			stickerAttach(notebook, stickerArray[i], i + 1);
		}

		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(notebook[i][j] != 0) {
					count++;
				}
			}
		}

		System.out.println(count);
	}

	public static void stickerAttach(int[][] notebook, int[][] sticker, int index) {

		boolean attack = true;

		for(int z = 0; z < 360; z += 90) {
			for(int r = 0; r < notebook.length; r++) {
				for(int c = 0; c < notebook[0].length; c++) {

					int[][] rotate = rotate(sticker, z);

					// 시작 좌표 구하기
					if(rotate[0][0] != 0 && notebook[r][c] != 0) {
						continue;
					}

					// 길이 초과
					if(r + rotate.length > notebook.length || c + rotate[0].length > notebook[0].length) {
						continue;
					}

					for(int i = 0; i < rotate.length; i++) {
						for(int j = 0; j < rotate[0].length; j++) {
							if(notebook[r + i][c + j] == 0 || rotate[i][j] == 0) {
								if(rotate[i][j] == 1) {
									notebook[r + i][c + j] = index;
								}
								attack = true;
							}
							else {
								// 붙이기 초기화
								for(int a = r; a < r + rotate.length; a++) {
									for(int b = c; b < c + rotate[0].length; b++) {
										if(notebook[a][b] == index) {
											notebook[a][b] = 0;
										}
									}
								}
								attack = false;
								break;
							}
						}
						if(!attack) {
							break;
						}
					}

					if(attack) {
						return;
					}
				}
			}
		}
	}

	public static int[][] rotate(int[][] sticker, int angle) {

		int[][] result;

		for(int a = angle; a > 0; a -= 90) {

			int r = sticker.length;
			int c = sticker[0].length;

			result = new int[c][r];

			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					result[j][r - 1 - i] = sticker[i][j];
				}
			}

			sticker = result;
		}

		return sticker;
	}
}
