package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] prefixSumArray = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			sum += Integer.parseInt(st.nextToken());;
			prefixSumArray[i] = sum;
		}

		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int startIndex = Integer.parseInt(st.nextToken());
			int endIndex = Integer.parseInt(st.nextToken());

			sb.append(prefixSumArray[endIndex] - prefixSumArray[startIndex - 1]).append("\n");
		}

		System.out.println(sb);
	}
}
