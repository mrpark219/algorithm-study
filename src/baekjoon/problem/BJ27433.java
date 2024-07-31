package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ27433 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		System.out.print(factorial(N));
	}

	public static long factorial(int n) {

		if(n == 0 || n == 1) {
			return 1;
		}

		return n * factorial(n - 1);
	}
}
