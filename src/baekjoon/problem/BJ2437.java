package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2437 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] weightArray = new int[N];

		for(int i = 0; i < N; i++) {
			weightArray[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(weightArray);

		int sum = 0;
		for(int i = 0; i < N; i++) {
			if(sum + 1 < weightArray[i]) {
				break;
			}

			sum += weightArray[i];
		}

		System.out.println(sum + 1);
	}
}
