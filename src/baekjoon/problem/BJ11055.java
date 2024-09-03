package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11055 {

	public static int[] inputArray;
	public static Integer[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		inputArray = new int[N];
		dp = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			inputArray[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < N; i++) {
			solution(i);
		}

		int max = -1;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}

	public static int solution(int index) {

		if(dp[index] == null) {
			dp[index] = inputArray[index];

			for(int i = index - 1; i >= 0; i--) {
				if(inputArray[i] < inputArray[index]) {
					dp[index] = Math.max(solution(i) + inputArray[index], dp[index]);
				}
			}
		}

		return dp[index];
	}
}
