package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10816 {

	public static int[] inputArray;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		inputArray = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			inputArray[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(inputArray);

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		for(int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());

			sb.append(endIndex(number) - startIndex(number)).append(' ');
		}

		System.out.println(sb);
	}

	private static int endIndex(int number) {

		int start = 0;
		int end = inputArray.length;

		while(start < end) {
			int middle = (start + end) / 2;

			if(number < inputArray[middle]) {
				end = middle;
			}
			else {
				start = middle + 1;
			}
		}

		return start;
	}

	private static int startIndex(int number) {

		int start = 0;
		int end = inputArray.length;

		while(start < end) {
			int middle = (start + end) / 2;

			if(number <= inputArray[middle]) {
				end = middle;
			}
			else {
				start = middle + 1;
			}
		}

		return start;
	}
}
