package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2776 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] note1 = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				note1[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(note1);

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for(int j = 0; j < M; j++) {
				boolean result = binarySearch(note1, Integer.parseInt(st.nextToken()));

				sb.append(result ? 1 : 0).append("\n");
			}
		}

		System.out.println(sb);
	}

	public static boolean binarySearch(int[] note1, int n) {
		int left = 0;
		int right = note1.length - 1;

		while(left <= right) {
			int middle = (left + right) / 2;

			if(note1[middle] == n) {
				return true;
			}
			else if(note1[middle] < n) {
				left = middle + 1;
			}
			else {
				right = middle - 1;
			}
		}

		return false;
	}
}
