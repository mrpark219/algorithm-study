package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10986 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long[] modArray = new long[M];

		int sum = 0;
		for(int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			sum = (sum + number) % M;
			modArray[sum]++;
		}

		long count = modArray[0];
		for(long l : modArray) {
			count += l * (l - 1) / 2;
		}

		System.out.println(count);
	}
}
