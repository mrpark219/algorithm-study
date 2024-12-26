package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1946 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {

			int N = Integer.parseInt(br.readLine());

			int[][] inputArray = new int[N][2];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				inputArray[i][0] = A;
				inputArray[i][1] = B;
			}

			Arrays.sort(inputArray, ((o1, o2) -> o1[0] - o2[0]));

			int min = inputArray[0][1];
			int count = 1;

			for(int i = 1; i < N; i++) {
				if(inputArray[i][1] < min) {
					min = inputArray[i][1];
					count++;
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}
