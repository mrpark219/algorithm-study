package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1124 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		boolean[] isPrime = new boolean[B + 1];
		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		isPrime[1] = false;

		for(int i = 2; i * i <= B; i++) {
			if(isPrime[i]) {
				for(int j = i * i; j <= B; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int underPrimeCount = 0;

		for(int i = A; i <= B; i++) {
			int count = 0;
			int temp = i;

			for(int j = 2; j * j <= i; j++)
				if(isPrime[j]) {
					while(temp % j == 0) {
						count++;
						temp /= j;
					}
				}

			if(temp > 1) {
				count++;
			}
			if(isPrime[count]) {
				underPrimeCount++;
			}
		}

		System.out.println(underPrimeCount);
	}
}
