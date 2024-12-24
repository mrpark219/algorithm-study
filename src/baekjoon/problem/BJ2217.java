package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2217 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] ropeArray = new int[N];

		for(int i = 0; i < N; i++) {
			ropeArray[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(ropeArray);

		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, ropeArray[i] * (N - i));
		}

		System.out.println(max);
	}
}
