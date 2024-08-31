package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1564 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Integer.parseInt(br.readLine());

		long number = 1;
		for(long i = 2; i <= N; i++) {

			number *= i;
			while(number % 10 == 0) {
				number /= 10;
			}

			number %= 1000000000000L;
		}

		String result = Long.toString(number);
		if(result.length() > 5) {
			result = result.substring(result.length() - 5);
		}
		System.out.println(result);
	}
}
