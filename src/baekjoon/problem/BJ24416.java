package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ24416 {

	public static int recursionCount = 0;
	public static int dpCount = 0;
	public static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		dp = new int[n + 1];

		fib(n);
		fibonacci(n);

		System.out.println(recursionCount + " " + dpCount);
	}

	public static int fib(int n) {
		if(n == 1 || n == 2) {
			recursionCount++;
			return 1;
		}
		else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	public static int fibonacci(int n) {
		dp[1] = dp[2] = 1;
		for(int i = 3; i <= n; i++) {
			dpCount++;
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
