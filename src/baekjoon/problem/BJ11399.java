package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11399 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int array[] = new int[N + 1];
		int count = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(array);

		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				count += array[j];
			}
		}

		System.out.println(count);
	}
}
