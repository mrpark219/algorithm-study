package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ16400 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		boolean[] numberArray = new boolean[N + 1];
		List<Integer> primeList = new ArrayList<>();
		long[] dp = new long[40000 + 1];

		// false = 소수
		// true = 소수 X
		for(int i = 2; i <= N; i++) {
			if(numberArray[i]) {
				continue;
			}

			for(int j = i * 2; j <= N; j += i) {
				numberArray[j] = true;
			}
		}

		for(int i = 2; i <= N; i++) {
			if(!numberArray[i]) {
				primeList.add(i);
			}
		}

		dp[0] = 1;
		for(int prime : primeList) {
			for(int i = prime; i <= N; i++) {
				dp[i] = (dp[i] + dp[i - prime]) % 123456789;
			}
		}

		System.out.println(dp[N]);
	}
}
