package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2559 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] sumArray = new int[N + 1];
		int result = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			int input = Integer.parseInt(st.nextToken());
			sumArray[i] = sumArray[i - 1] + input;
		}

		for(int i = 1; i <= N - K + 1; i++) {
			 int sum = sumArray[i + K - 1] - sumArray[i - 1];
			 if(sum > result) {
				 result = sum;
			 }
		}

		System.out.println(result);
	}
}
